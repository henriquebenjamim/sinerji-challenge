package Company.Entities;

import java.time.LocalDate;

public class Secretary extends Employee{
    private static final double baseSalary = 7000.0;
    private static final double bonusPercentage = 0.2;

    public Secretary(String name, LocalDate sinceDate) {
        super(name, Role.SECRETARY, sinceDate);
    }

    @Override
    public double calculateTotalSalary(int month, int year) {
        int yearsWorking = year - getSinceDate().getYear();
        double salary = baseSalary + (1000 * yearsWorking);
        double bonus = salary * bonusPercentage;
        return salary + bonus;
    }

    @Override
    public double baseSalary(int month, int year) {
        int yearsWorking = year - getSinceDate().getYear();
        double salary = baseSalary + (1000 * yearsWorking);
        return salary;
    }

    @Override
    public double calculateBonus(int month, int year) {
        int yearsWorking = year - getSinceDate().getYear();
        double salary = baseSalary + (1000 * yearsWorking);
        double bonus = salary * bonusPercentage;
        return bonus;
    }
}
