package com.spring.spring_lib_prcte;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.spring_lib_prcte.model.Employee;

@SpringBootApplication
public class SpringLibPrcteApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringLibPrcteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Employee> employees = List.of(
				new Employee("E001", "Alice", 70000, "Engineering"),
				new Employee("E002", "Bob", 65000, "Marketing"),
				new Employee("E003", "Charlie", 72000, "Engineering"),
				new Employee("E004", "David", 60000, "Sales"),
				new Employee("E005", "Eve", 68000, "Marketing"),
				new Employee("E006", "Frank", 75000, "Engineering"),
				new Employee("E007", "Grace", 62000, "Sales"),
				new Employee("E008", "Heidi", 69000, "Marketing"),
				new Employee("E009", "Ivan", 71000, "Engineering"),
				new Employee("E010", "Judy", 63000, "Sales"),
				new Employee("E011", "Karl", 67000, "Marketing"),
				new Employee("E012", "Leo", 73000, "Engineering"),
				new Employee("E013", "Mallory", 64000, "Sales"),
				new Employee("E014", "Nina", 66000, "Marketing"),
				new Employee("E015", "Oscar", 72000, "Engineering"),
				new Employee("E016", "Peggy", 61000, "Sales"),
				new Employee("E017", "Quentin", 68000, "Marketing"),
				new Employee("E018", "Ruth", 74000, "Engineering"),
				new Employee("E019", "Steve", 63000, "Sales"),
				new Employee("E020", "Trudy", 69000, "Marketing"),
				new Employee("E021", "Uma", 71000, "Engineering"),
				new Employee("E022", "Victor", 62000, "Sales"),
				new Employee("E023", "Wendy", 67000, "Marketing"),
				new Employee("E024", "Xavier", 73000, "Engineering"),
				new Employee("E025", "Yvonne", 64000, "Sales"),
				new Employee("E026", "Zack", 66000, "Marketing")

		);

		Map<String, List<Employee>> employeesByDepartment = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));

		employeesByDepartment.forEach((department, empList) -> {
			System.out.println("Department: " + department);
			empList.forEach(emp -> System.out.println(" - " + emp.getName() + " (Salary: " + emp.getSalary() + ")"));
		});

		// Calculate average salary by department
		Map<String, Double> averageSalaryByDepartment = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,
						Collectors.averagingDouble(Employee::getSalary)));

		averageSalaryByDepartment.forEach((department, avgSalary) -> {
			System.out.println("Average salary in " + department + ": " + avgSalary);
		});

		// Find the highest paid employee in each department
		Map<String, Employee> highestPaidByDepartment = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,
						Collectors.collectingAndThen(
								Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())),
								empOpt -> empOpt.orElse(null))));

		highestPaidByDepartment.forEach((department, emp) -> {
			if (emp != null) {
				System.out.println(
						"Highest paid in " + department + ": " + emp.getName() + " (Salary: " + emp.getSalary() + ")");
			}
		});

		// filter employees with salary above 70000 and group  
	}

}
