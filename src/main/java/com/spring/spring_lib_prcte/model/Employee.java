package com.spring.spring_lib_prcte.model;

import java.util.List;

public class Employee {
    private String id;
    private String name;
    private String department;
    private int age;
    private double salary;
    private List<String> skills;

    public Employee(String id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public Employee(String id, String name, double salary, String department, int age, List<String> skills) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.age = age;
        this.skills = skills;
    }

    public int getAge() {
        return age;
    }

    public List<String> getSkills() {
        return skills;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }
}
