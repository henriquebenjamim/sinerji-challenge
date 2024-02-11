package Company.Entities;

import java.time.LocalDate;

public class Manager extends Employee{
    private static final double baseSalary = 20000.0;
    private static final double raisePerYear = 3000.0;

    public Manager(String name, LocalDate sinceDate) {
        super(name, Role.MANAGER, sinceDate);
    }

    @Override
    public double calculateTotalSalary(int month, int year) {
        int yearsWorking = year - getSinceDate().getYear();
        double salary = baseSalary + (raisePerYear * yearsWorking);
        return salary;
    }

    @Override
    public double baseSalary(int month, int year) {
        int yearsWorking = year - getSinceDate().getYear();
        double salary = baseSalary + (raisePerYear * yearsWorking);
        return salary;
    }


}
