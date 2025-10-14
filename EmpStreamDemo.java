package com.example;
import java.util.*;
import java.util.stream.Collectors;

public class EmpStreamDemo {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(101, "Alice", "IT", 75000, 28,
                Arrays.asList("Java", "Spring", "SQL")),
            new Employee(102, "Bob", "HR", 55000, 35,
                Arrays.asList("Communication", "Recruitment")),
            new Employee(103, "Charlie", "IT", 82000, 30,
                Arrays.asList("Java", "Docker", "Kubernetes")),
            new Employee(104, "David", "Finance", 60000, 40,
                Arrays.asList("Excel", "Accounts", "SAP")),
            new Employee(105, "Eve", "IT", 95000, 25,
                Arrays.asList("Python", "Machine Learning")),
            new Employee(101, "Alice", "IT", 75000, 28,
                Arrays.asList("Java", "Spring", "SQL")) // duplicate
        );
        System.out.println("=== Original Employee List ===");
        employees.forEach(System.out::println);

        // FILTER → Employees with salary > 70000
        System.out.println("\n=== Filter: Salary > 70000 ===");
        employees.stream()
                .filter(e -> e.getSalary() > 70000)
                .forEach(System.out::println);

        // MAP → Get list of names
        System.out.println("\n=== Map: Extract Employee Names ===");
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);

        // DISTINCT → Remove duplicate employees
        System.out.println("\n=== Distinct: Remove Duplicates ===");
        employees.stream()
                .distinct()
                .forEach(System.out::println);

        // SORTED → Sort by salary (ascending)
        System.out.println("\n=== Sort: By Salary (Ascending) ===");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .forEach(System.out::println);

        // SORTED → Sort by name (descending)
        System.out.println("\n=== Sort: By Name (Descending) ===");
        employees.stream()

                .sorted(Comparator.comparing(Employee::getName).reversed())
                .forEach(System.out::println);

        // FLATMAP → Get a list of ALL unique skills from all employees
        System.out.println("\n=== FlatMap: All Unique Skills ===");
        employees.stream()
                .flatMap(e -> e.getSkills().stream())
                .distinct()
                .forEach(System.out::println);

        // COUNT → Number of employees in IT
        long itCount = employees.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase("IT"))
                .count();
        System.out.println("\nTotal Employees in IT Department = " + itCount);
        // AVERAGE → Average salary of all employees
        double avgSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
        System.out.println("Average Salary of Employees = " + avgSalary);

        // COLLECT → Group employees by department
        System.out.println("\n=== Grouping by Department ===");
        Map<String, List<Employee>> grouped = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        grouped.forEach((dept, list) -> {
            System.out.println(dept + " : " + list);
        });

        // FIND → Any employee older than 35
        System.out.println("\n=== Find Any Employee Age > 35 ===");
        employees.stream()
                .filter(e -> e.getAge() > 35)
                .findAny()
                .ifPresent(System.out::println);
    }
}