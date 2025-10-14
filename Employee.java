package com.example;

import java.util.List;
import java.util.Objects;

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;
    private int age;
    private List<String> skills; // For flatMap demonstration

    public Employee(int id, String name, String department, double salary, int age, List<String> skills) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
        this.skills = skills;
    }
    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public int getAge() { return age; }
    public List<String> getSkills() { return skills; }
    // toString for easy display
    @Override
    public String toString() {
        return String.format("Employee{id=%d, name='%s', dept='%s', salary=%.2f, age=%d, skills=%s}", id, name, department, salary, age, skills);
    }
    // equals & hashCode for distinct()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee e = (Employee) o;
        return id == e.id && name.equals(e.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}