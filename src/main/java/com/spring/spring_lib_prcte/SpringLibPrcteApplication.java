package com.spring.spring_lib_prcte;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.spring_lib_prcte.service.EmployeeService;

@SpringBootApplication
public class SpringLibPrcteApplication implements CommandLineRunner {

	private EmployeeService employeeService;

	public SpringLibPrcteApplication(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringLibPrcteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		employeeService.calculateTotalSalaryForEachDepartment();
		employeeService.calculateAverageSalaryForEachDepartment();
		employeeService.highestPaidEmployeeInEachDept();
		employeeService.findSecondHighestPaidEmpInEachDept();
		employeeService.partitionEmployeeIntoTwoGroupsBasedOnSalary();

		// List<Employee> employees = employeeInMemoryDB.getAllEmployees();

		// Map<String, List<Employee>> employeesByDepartment = employees.stream()
		// .collect(Collectors.groupingBy(Employee::getDepartment));

		// employeesByDepartment.forEach((department, empList) -> {
		// System.out.println("Department: " + department);
		// empList.forEach(emp -> System.out.println(" - " + emp.getName() + " (Salary:
		// " + emp.getSalary() + ")"));
		// });

		// // Calculate average salary by department
		// Map<String, Double> averageSalaryByDepartment = employees.stream()
		// .collect(Collectors.groupingBy(Employee::getDepartment,
		// Collectors.averagingDouble(Employee::getSalary)));

		// averageSalaryByDepartment.forEach((department, avgSalary) -> {
		// System.out.println("Average salary in " + department + ": " + avgSalary);
		// });

		// // Find the highest paid employee in each department
		// Map<String, Employee> highestPaidByDepartment = employees.stream()
		// .collect(Collectors.groupingBy(Employee::getDepartment,
		// Collectors.collectingAndThen(
		// Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())),
		// empOpt -> empOpt.orElse(null))));

		// highestPaidByDepartment.forEach((department, emp) -> {
		// if (emp != null) {
		// System.out.println(
		// "Highest paid in " + department + ": " + emp.getName() + " (Salary: " +
		// emp.getSalary() + ")");
		// }
		// });

		// // filter employees with salary above 70000 and group
	}

}
