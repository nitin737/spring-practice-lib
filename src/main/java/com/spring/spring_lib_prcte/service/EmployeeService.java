package com.spring.spring_lib_prcte.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spring.spring_lib_prcte.model.Employee;
import com.spring.spring_lib_prcte.repository.EmployeeInMemoryDB;

@Service
public class EmployeeService {
    private EmployeeInMemoryDB employeeInMemoryDB;

    public EmployeeService(EmployeeInMemoryDB employeeInMemoryDB) {
        this.employeeInMemoryDB = employeeInMemoryDB;
    }

    public void calculateTotalSalaryForEachDepartment() {
        Map<String, Double> totalSalaryByDepartment = employeeInMemoryDB.getAllEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.summingDouble(Employee::getSalary)));

        System.out.println("Total Salary by Department:");
        totalSalaryByDepartment.forEach((department, totalSalary) -> {
            System.out.println("Total salary in " + department + ": " + totalSalary);
        });
        System.out.println("----------------------------------");
    }

    public void calculateAverageSalaryForEachDepartment() {
        System.out.println("Average Salary by Department");
        employeeInMemoryDB.getAllEmployees().stream().collect(
                Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
                .forEach((department, averageSalary) -> {
                    System.out.println("Average Salary in " + department + " averageSalary: " + averageSalary);
                });
        System.out.println("----------------------------------");
    }

    public void highestPaidEmployeeInEachDept() {
        System.out.println("Highest Paid Employee in Each Department");
        employeeInMemoryDB.getAllEmployees().stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.maxBy(Comparator.comparing(Employee::getSalary))))
                .forEach((department, empOpt) -> {
                    empOpt.ifPresent(emp -> System.out.println("Highest paid employee in " + department + ": "
                            + emp.getName() + " with salary " + emp.getSalary()));
                });
        System.out.println("----------------------------------");
    }

    public void findSecondHighestSalary() {
        System.out.println("Second Highest Salary among all employees");

        employeeInMemoryDB.getAllEmployees().stream().sorted(Comparator.comparing(Employee::getSalary)).skip(1)
                .findFirst();
    }

    public void findSecondHighestPaidEmpInEachDept() {
        System.out.println("Second highest paid employee in each Department");
        employeeInMemoryDB.getAllEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.collectingAndThen(Collectors.toList(),
                                empList -> empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
                                        .skip(1).findFirst())))
                .forEach((department, emp) -> System.out
                        .println("Second Highest Salary of " + department + " for Employee "
                                + emp.get().getName() + " with Salary " + emp.get().getSalary()));
    }

    public void partitionEmployeeIntoTwoGroupsBasedOnSalary() {
        System.out.println("Parition Employees into two groups based on salary");
        Map<Boolean, List<Employee>> employeePartition = employeeInMemoryDB.getAllEmployees().stream()
                .collect(Collectors.partitioningBy((emp) -> emp.getSalary() > 65000));
        employeePartition.forEach((booleanValue, empList) -> {
            empList.forEach(emp -> System.out.println("key: " + booleanValue + ", value: " + emp.getSalary()));
        });
    }

    public void getCommaSeparatedStringOfAllEmployeeNamesSortedAlphabetically() {
        System.out.println("Comma Separated String of all employee names sorted alphabetically");
        String result = employeeInMemoryDB.getAllEmployees().stream().map(Employee::getName).sorted()
                .collect(Collectors.joining(","));
        System.out.println(result);
        System.out.println("----------------------------------");
    }

    public void findDuplicateEmployeeNames() {
        System.out.println("Find Duplicate Employee Names");
        Map<String, Long> duplicateEmployees = employeeInMemoryDB.getAllEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getName, Collectors.counting()));

        duplicateEmployees.forEach((key, value) -> {
            if (value > 1)
                System.out.println("Employee " + key + " has duplicate entries with count: " + value);
        });

        System.out.println("----------------------------------");
    }

    public void findTheDepartmentWithTheHighestTotalSalary() {
        System.out.println("Find The Department With The Highest Total Salary");
        Map<String, Double> totalSalaryByDepartment = employeeInMemoryDB.getAllEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));

        Optional<String> deptWithHighestSalary = totalSalaryByDepartment.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);

        System.out.println("Depart with highest Salary is: " + deptWithHighestSalary.get());
        System.out.println("----------------------------------");
    }
}
