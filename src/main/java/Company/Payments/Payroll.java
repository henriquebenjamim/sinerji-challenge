package Company.Payments;

import Company.Entities.Employee;
import Company.Entities.Seller;

import java.util.List;

public class Payroll {

    public static double calculateTotalValuePaid(List<Employee> employees, int month, int year) {
        double totalValuePaid = 0.0;
        for (Employee employee : employees) {
            if (employee instanceof Seller) {
                Seller seller = (Seller) employee;
                totalValuePaid += seller.calculateTotalSalary(month, year);
            } else {
                totalValuePaid += employee.calculateTotalSalary(month, year);
            }
        }
        return totalValuePaid;
    }
}
