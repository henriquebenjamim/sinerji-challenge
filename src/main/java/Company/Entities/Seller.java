package Company.Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Seller extends Employee{
    private static final double baseSalary = 12000.0;
    private static final double raisePerYear = 1800.0;
    private static final double bonusPercentageBySale = 0.3;
    private List<Sale> sales;

    public Seller(String name, LocalDate sinceDate) {
        super(name, Role.SELLER, sinceDate);
        this.sales = new ArrayList<>();
    }

    public void addSale(Seller seller, LocalDate saleDate, double value) {
        Sale sale = new Sale(this, saleDate, value);
        sales.add(sale);
    }

    @Override
    public double calculateTotalSalary(int month, int year) {
        int yearsWorking = year - getSinceDate().getYear();
        double salary = baseSalary + (raisePerYear * yearsWorking);
        double totalSalesInMonth = calculateTotalSalesInMonth(month, year);
        double bonus = totalSalesInMonth * bonusPercentageBySale;
        return salary + bonus;
    }

    @Override
    public double baseSalary(int month, int year) {
        int yearsWorking = year - getSinceDate().getYear();
        double salary = baseSalary + (raisePerYear * yearsWorking);
        return salary;
    }

    private double calculateTotalSalesInMonth(int month, int year) {
        return sales.stream()
                .filter(sale -> sale.getDate().getYear() == year && sale.getDate().getMonthValue() == month)
                .mapToDouble(Sale::getValue)
                .sum();
    }


}
