package com.spring.spring_lib_prcte.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.spring_lib_prcte.model.Employee;

@Component
public class EmployeeInMemoryDB {
    private final List<Employee> EMPLOYEES = List.of(
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
            new Employee("E026", "Zack", 66000, "Marketing"),
            new Employee("E027", "Aaron", 72000, "Engineering"),
            new Employee("E028", "Beth", 61000, "Sales"),
            new Employee("E029", "Carl", 68000, "Marketing"),
            new Employee("E030", "Diana", 74000, "Engineering"),
            new Employee("E031", "Ethan", 63000, "Sales"),
            new Employee("E032", "Fiona", 69000, "Marketing"),
            new Employee("E033", "George", 71000, "Engineering"),
            new Employee("E034", "Hannah", 62000, "Sales"),
            new Employee("E035", "Ian", 67000, "Marketing"),
            new Employee("E036", "Jane", 73000, "Engineering"),
            new Employee("E037", "Kevin", 64000, "Sales"),
            new Employee("E038", "Laura", 66000, "Marketing"),
            new Employee("E039", "Mike", 72000, "Engineering"),
            new Employee("E040", "Nina", 61000, "Sales"),
            new Employee("E041", "Oscar", 68000, "Marketing"),
            new Employee("E042", "Pam", 74000, "Engineering"),
            new Employee("E043", "Quinn", 63000, "Sales"),
            new Employee("E044", "Rachel", 69000, "Marketing"),
            new Employee("E045", "Sam", 71000, "Engineering"),
            new Employee("E046", "Tina", 62000, "Sales"),
            new Employee("E047", "Uma", 67000, "Marketing"),
            new Employee("E048", "Vince", 73000, "Engineering"),
            new Employee("E049", "Wendy", 64000, "Sales"),
            new Employee("E050", "Xander", 66000, "Marketing"));

    public List<Employee> getAllEmployees() {
        return this.EMPLOYEES;
    }

}
