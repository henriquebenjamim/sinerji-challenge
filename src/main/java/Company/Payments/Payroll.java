package Company.Payments;

import Company.Entities.Employee;
import Company.Entities.Role;
import Company.Entities.Seller;

import java.util.List;

public class Payroll {

    // Um método que receba uma lista de funcionários, mês e ano e retorne o valor total pago (salário e benefício) a esses funcionários no mês.
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

    //Um método que receba uma lista de funcionários, mês e ano e retorne o total pago somente em salários no mês.
    public static double calculateTotalSalaryPaid(List<Employee> employees, int month, int year) {
        double totalSalaryPaid = 0.0;
        for (Employee employee : employees) {
            totalSalaryPaid += employee.baseSalary(month, year);
        }
        return totalSalaryPaid;
    }

    //Um método que receba uma lista somente com os funcionários que recebem benefícios, mês e ano e retorne o total pago em benefícios no mês.
    public static double calculateTotalBenefitsPaid(List<Employee> employees, int month, int year) {
        double totalBenefitsPaid = 0.0;
        for (Employee employee : employees) {
            if (employee.getRole() != Role.MANAGER) {
                totalBenefitsPaid += employee.calculateBonus(month, year);
            }
        }
        return totalBenefitsPaid;
    }
}
