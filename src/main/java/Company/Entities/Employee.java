package Company.Entities;

import java.time.LocalDate;

public abstract class Employee {
    private String name;
    private Role role;
    private LocalDate sinceDate;

    public Employee(String name, Role role, LocalDate sinceDate) {
        this.name = name;
        this.role = role;
        this.sinceDate = sinceDate;
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public LocalDate getSinceDate() {
        return sinceDate;
    }

    public abstract double calculateTotalSalary(int month, int year);
    public abstract double baseSalary(int month, int year);

    public abstract double calculateBonus(int month, int year);
}
