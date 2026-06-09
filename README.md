# Spring Practice Library

A playground project for exploring Spring Boot libraries, developer tools, and advanced configurations.

## BootUI Integration

This project integrates [BootUI](https://github.com/jdubois/boot-ui)—an embedded, local-only developer console for Spring Boot applications (similar in concept to the Quarkus Dev UI). 

Once the application is running locally, you can access the BootUI console at:
👉 **[http://localhost:8080/bootui](http://localhost:8080/bootui)**

---

## Key Features

BootUI provides a rich dashboard and diagnostics panels grouped as follows:

### 📊 Overview & Scanners
- **Live Memory & Health Cards:** Automatically polls the Actuator health status and displays real-time JVM memory breakdown (heap, metaspace, code cache, direct memory, and thread stacks).
- **Security & Health Scoring:** On-demand audit scoring out of 100 summarizing your application's architecture, API design, security posture, database hygiene, and dependencies.

### 🐙 GitHub Integration
- **Local Git & Repository Metadata:** Connects to the local `origin` remote, tracking pull requests, open issues, GitHub Actions workflow executions, rate limits/quotas, and security alerts.

### 🛡️ Smart Advisors
- **Architecture Scan:** Curated, zero-config [ArchUnit](https://www.archunit.org/) ruleset executing statically against your bytecode to detect dependency cycles, bad coding practices, and Spring stereotype proxy issues.
- **REST API Scan:** Runs 36 best-practice rules covering routing, resource naming, status codes, input validation, and pagination constraints.
- **Spring Context Scan:** Inspects the live, running application context and environment for sub-optimal properties or configuration.
- **Hibernate & JPA Scan:** Reviews the metamodel of the JPA `EntityManagerFactory` for eager fetch issues, problematic ID generators, risky `ddl-auto` configurations, and fetch plans.
- **Memory Diagnostics:** Diagnoses JVM management bean metrics to find heap pressure, metaspace saturation, native-footprint risk, and thread deadlocks.
- **Security & Pentesting:** Passively scans `SecurityFilterChain` configurations and runs local OWASP Top 10 hygiene checks via synthetic requests to verify CORS, security headers, cookie flags, and endpoint exposure.

---

## Configuration

You can customize the console behaviour in your application properties:

```yaml
# Make the entire BootUI dashboard read-only
bootui.read-only: true

# Exclude BootUI's internal runtime data from monitoring panels
bootui.monitoring.exclude-self: true

# Disable or restrict specific panels
bootui.panels.architecture.enabled: false
bootui.panels.github.read-only: true
```

Individual advisor warnings can also be permanently **dismissed** directly from the UI. Dismissed rules are stored in a local, developer-specific file at `.bootui/boot-ui.yml`.
