# ============================================================
#  dev-start.ps1  —  Start Spring Boot app in Docker (dev mode)
#  Usage: .\auto\dev-start.ps1
# ============================================================

$ProjectRoot = Split-Path -Parent $PSScriptRoot
$ComposeBase = "compose.yaml"
$ComposeDev  = "compose.dev.yaml"

Write-Host ""
Write-Host "========================================" -ForegroundColor Cyan
Write-Host "  Spring Boot Dev Startup" -ForegroundColor Cyan
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""

# ── Step 1: Build JAR locally ────────────────────────────────
Write-Host "[1/3] Building JAR with Gradle..." -ForegroundColor Yellow

Set-Location $ProjectRoot
& ".\gradlew.bat" bootJar -x test

if ($LASTEXITCODE -ne 0) {
    Write-Host ""
    Write-Host "[ERROR] Gradle build failed. Fix the errors above and try again." -ForegroundColor Red
    exit 1
}

Write-Host "[1/3] JAR built successfully." -ForegroundColor Green
Write-Host ""

# ── Step 2: Ensure Qdrant is up and healthy ──────────────────
Write-Host "[2/3] Ensuring Qdrant is running..." -ForegroundColor Yellow

docker-compose -f $ComposeBase -f $ComposeDev up qdrant -d --wait

if ($LASTEXITCODE -ne 0) {
    Write-Host ""
    Write-Host "[ERROR] Failed to start Qdrant. Is Docker running?" -ForegroundColor Red
    exit 1
}

Write-Host "[2/3] Qdrant is healthy." -ForegroundColor Green
Write-Host ""

# ── Step 3: Restart Spring Boot app container ────────────────
Write-Host "[3/3] Starting Spring Boot app container..." -ForegroundColor Yellow

docker-compose -f $ComposeBase -f $ComposeDev up app --build --force-recreate -d

if ($LASTEXITCODE -ne 0) {
    Write-Host ""
    Write-Host "[ERROR] Failed to start app container." -ForegroundColor Red
    exit 1
}

Write-Host "[3/3] App container started." -ForegroundColor Green
Write-Host ""

# ── Done ─────────────────────────────────────────────────────
Write-Host "========================================" -ForegroundColor Cyan
Write-Host "  App is running at http://localhost:8080" -ForegroundColor Cyan
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""
Write-Host "  Useful commands:" -ForegroundColor DarkGray
Write-Host "    docker logs sprlibprc -f          # follow logs" -ForegroundColor DarkGray
Write-Host "    docker-compose down               # stop all" -ForegroundColor DarkGray
Write-Host ""
