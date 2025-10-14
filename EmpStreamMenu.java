package com.example;
import java.util.*;
import java.util.stream.Collectors;

public class EmpStreamMenu {
    private static final List<Employee> employees = new ArrayList<>();
    public static void main(String[] args) {
        initializeEmployees();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n========= EMPLOYEE STREAM MENU =========");
            System.out.println("1. Display All Employees");
            System.out.println("2. Filter Employees with Salary > 70000");
            System.out.println("3. Map - Show All Employee Names");
            System.out.println("4. Distinct - Remove Duplicate Employees");
            System.out.println("5. Sort - By Salary (Ascending)");
            System.out.println("6. Sort - By Name (Descending)");
            System.out.println("7. FlatMap - Show All Unique Skills");
            System.out.println("8. Count - Employees in IT Department");
            System.out.println("9. Average - Salary of All Employees");
            System.out.println("10. Group By Department");
            System.out.println("11. Find Any Employee Age > 35");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline
            switch (choice) {
                case 1 -> displayAll();
                case 2 -> filterBySalary();
                case 3 -> mapNames();
                case 4 -> distinctEmployees();
                case 5 -> sortBySalary();
                case 6 -> sortByNameDesc();
                case 7 -> flatMapSkills();
                case 8 -> countITDept();
                case 9 -> averageSalary();
                case 10 -> groupByDept();
                case 11 -> findAnyAbove35();
                case 0 -> System.out.println("Exiting... Thank you!");
                default -> System.out.println("Invalid Choice! Try again.");
            }
        } while (choice != 0);
        sc.close();
    }

    private static void initializeEmployees() {
        employees.add(new Employee(101, "Alice", "IT", 75000, 28,
                Arrays.asList("Java", "Spring", "SQL")));
        employees.add(new Employee(102, "Bob", "HR", 55000, 35,
                Arrays.asList("Communication", "Recruitment")));
        employees.add(new Employee(103, "Charlie", "IT", 82000, 30,
                Arrays.asList("Java", "Docker", "Kubernetes")));
        employees.add(new Employee(104, "David", "Finance", 60000, 40,
                Arrays.asList("Excel", "Accounts", "SAP")));
        employees.add(new Employee(105, "Eve", "IT", 95000, 25,
                Arrays.asList("Python", "Machine Learning")));
        employees.add(new Employee(101, "Alice", "IT", 75000, 28,
                Arrays.asList("Java", "Spring", "SQL"))); // duplicate
    }
    private static void displayAll() {
        System.out.println("\n--- All Employees ---");
        employees.forEach(System.out::println);
    }
    private static void filterBySalary() {
        System.out.println("\n--- Employees with Salary > 70000 ---");
        employees.stream()
                .filter(e -> e.getSalary() > 70000)
                .forEach(System.out::println);
    }
    private static void mapNames() {
        System.out.println("\n--- Employee Names ---");
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }
    private static void distinctEmployees() {
        System.out.println("\n--- Distinct Employees ---");
        employees.stream()
                .distinct()
                .forEach(System.out::println);
    }
    private static void sortBySalary() {
        System.out.println("\n--- Employees Sorted by Salary (Ascending) ---");
                employees.stream()
                        .sorted(Comparator.comparing(Employee::getSalary))
                        .forEach(System.out::println);
    }
    private static void sortByNameDesc() {
        System.out.println("\n--- Employees Sorted by Name (Descending) ---");
                employees.stream()
                        .sorted(Comparator.comparing(Employee::getName).reversed())
                        .forEach(System.out::println);
    }
    private static void flatMapSkills() {
        System.out.println("\n--- All Unique Skills ---");
        employees.stream()
                .flatMap(e -> e.getSkills().stream())
                .distinct()
                .forEach(System.out::println);
    }
    private static void countITDept() {
        long count = employees.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase("IT"))
                .count();
        System.out.println("\nTotal Employees in IT Department: " +
                count);
    }
    private static void averageSalary() {
        double avg = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
        System.out.println("\nAverage Salary of All Employees: " + avg);
    }
    private static void groupByDept() {
        System.out.println("\n--- Employees Grouped by Department ---");
        Map<String, List<Employee>> groupMap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        groupMap.forEach((dept, list) -> {
            System.out.println(dept + " : ");
            list.forEach(e -> System.out.println("\t" + e));
        });
    }
    private static void findAnyAbove35() {
        System.out.println("\n--- Any Employee Age > 35 ---");
        employees.stream()
                .filter(e -> e.getAge() > 35)
                .findAny()
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("No Employee Found!")
                );
    }
}