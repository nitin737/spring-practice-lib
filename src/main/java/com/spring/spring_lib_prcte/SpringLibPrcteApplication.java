package com.spring.spring_lib_prcte;

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
		employeeService.getCommaSeparatedStringOfAllEmployeeNamesSortedAlphabetically();
		employeeService.findDuplicateEmployeeNames();
		employeeService.findTheDepartmentWithTheHighestTotalSalary();

	}

}
