package com.example;
import java.util.*;
import java.util.stream.Collectors;

public class EmpStreamMenuCustom {
    private static final List<Employee> employees = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        initializeEmployees();
        int choice;
        do {
            System.out.println("\n========= EMPLOYEE STREAM MENU =========");
                    System.out.println("1. Display All Employees");
            System.out.println("2. Filter Employees by Custom Salary Range");
                    System.out.println("3. Filter Employees by Department");
            System.out.println("4. Filter Employees by Age > Given Value");
            System.out.println("5. Map - Show All Employee Names");
            System.out.println("6. Distinct - Remove Duplicate Employees");
            System.out.println("7. Sort - By Salary (Ascending)");
            System.out.println("8. Sort - By Name (Descending)");
            System.out.println("9. FlatMap - Show All Unique Skills");
            System.out.println("10. Group By Department");
            System.out.println("11. Average - Salary of All Employees");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = readInt();
            switch (choice) {
                case 1 -> displayAll();
                case 2 -> filterBySalaryRange();
                case 3 -> filterByDepartment();
                case 4 -> filterByAge();
                case 5 -> mapNames();
                case 6 -> distinctEmployees();
                case 7 -> sortBySalary();
                case 8 -> sortByNameDesc();
                case 9 -> flatMapSkills();
                case 10 -> groupByDept();
                case 11 -> averageSalary();
                case 0 -> System.out.println("Exiting... Thank you!");
                default -> System.out.println("Invalid Choice! Try again.");
            }
        } while (choice != 0);
    }

    // ---------- Initialization ----------
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

    // ---------- Menu Methods ----------
    private static void displayAll() {
        System.out.println("\n--- All Employees ---");
        employees.forEach(System.out::println);
    }
    private static void filterBySalaryRange() {
        System.out.print("Enter Minimum Salary: ");
        double min = readDouble();
        System.out.print("Enter Maximum Salary: ");
        double max = readDouble();
        System.out.println("\n--- Employees with Salary between " + min + " and " + max + " ---");
        employees.stream()
                .filter(e -> e.getSalary() >= min && e.getSalary() <= max)
                .forEach(System.out::println);
    }
    private static void filterByDepartment() {
        System.out.print("Enter Department Name: ");
        String dept = sc.nextLine().trim();
        System.out.println("\n--- Employees in Department: " + dept + " ---");
        employees.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase(dept))
                .forEach(System.out::println);
    }
    private static void filterByAge() {
        System.out.print("Enter Age Threshold: ");
        int age = readInt();
        System.out.println("\n--- Employees with Age > " + age + " ---");
        employees.stream()
                .filter(e -> e.getAge() > age)
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
    private static void groupByDept() {
        System.out.println("\n--- Employees Grouped by Department ---");
        Map<String, List<Employee>> groupMap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        groupMap.forEach((dept, list) -> {
            System.out.println(dept + " : ");
            list.forEach(e -> System.out.println("\t" + e));
        });
    }
    private static void averageSalary() {
        double avg = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
        System.out.println("\nAverage Salary of All Employees: " + avg);
    }
    // ---------- Utility Methods ----------
    private static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Please enter an integer: ");
            }
        }
    }
    private static double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine().trim());} catch (NumberFormatException e) {
                System.out.print("Invalid input! Please enter a number: ");
            }
        }
    }
}


