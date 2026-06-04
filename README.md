# spring-practice-lib

Java and Spring Boot practice project.

## Java 8 Streams API Practice Questions

Use the project `Employee` model and service layer to practice solving these with Java 8 Streams.

### Intermediate To Advanced

- [x] 1. Find the highest-paid employee in each department.
- [x] 2. Group employees by department and calculate the average salary of each department.
- [x] 3. Find the second-highest salary among all employees.
- [x] 4. Find the second-highest-paid employee in each department.
- [x] 5. Partition employees into two groups: salary greater than `50000` and salary less than or equal to `50000`.
- [x] 6. Get a comma-separated string of all employee names sorted alphabetically.
- [x] 7. Find duplicate employee names from a list of employees.
- [x] 8. Find the department with the highest total salary.
- [ ] 9. Count how many employees have each skill.
- [ ] 10. Flatten all employee skills into a unique sorted list.
- [ ] 11. Find employees who have more than 3 skills.
- [ ] 12. Group employees by department, then by age group.
- [ ] 13. Find the youngest employee in each department.
- [ ] 14. Find the top 3 highest-paid employees.
- [ ] 15. Find employees whose salary is above the average salary of the company.

### More Complex Challenges

- [ ] 16. Convert a list of employees into a map where the key is employee id and the value is employee name. Handle duplicate ids safely.
- [ ] 17. Group employees by department and return only departments having more than 3 employees.
- [ ] 18. Find the most common skill among all employees.
- [ ] 19. Sort employees first by department, then by salary descending, then by name.
- [ ] 20. Create a `Map<String, List<String>>` where the key is department and the value is a list of employee names.
- [ ] 21. Create a `Map<String, Double>` where the key is department and the value is max salary in that department.
- [ ] 22. Find employees who know both `Java` and `Spring`.
- [ ] 23. Find employees who know `Java` but not `Spring Boot`.
- [ ] 24. Find departments where all employees earn more than `40000`.
- [ ] 25. Find departments where at least one employee has `AWS` skill.

### Expert Level

- [ ] 26. Find the employee with the longest name in each department.
- [ ] 27. Group employees by the first letter of their name.
- [ ] 28. Find the salary rank of each employee based on salary descending.
- [ ] 29. Find employees with the same salary, only including salaries used by more than one employee.
- [ ] 30. Calculate salary statistics per department using `DoubleSummaryStatistics`.
- [ ] 31. Find the highest-paid employee among employees having `Java` skill.
- [ ] 32. Find the department-wise top 2 highest-paid employees.
- [ ] 33. Given a list of orders, customers, and products, use streams to find the top 5 customers by total order value.
- [ ] 34. Given a paragraph, find the top 10 most frequent words using streams.
- [ ] 35. Given a list of strings, group anagrams together using streams.

### Mini Project Challenge: Employee Analytics Service

Create stream-based methods for:

```java
Optional<Employee> highestPaidEmployee();

Map<String, Optional<Employee>> highestPaidByDepartment();

Map<String, Double> averageSalaryByDepartment();

List<Employee> topNHighestPaidEmployees(int n);

Map<String, Long> skillWiseEmployeeCount();

List<Employee> employeesAboveCompanyAverageSalary();

Map<String, List<Employee>> departmentWiseEmployeesSortedBySalary();

Map<String, DoubleSummaryStatistics> salaryStatsByDepartment();
```

Recommended questions to try first: `1`, `3`, `8`, `10`, `16`, `18`, `24`, `30`, and `32`.
