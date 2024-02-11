package Company.Payments;

import Company.Entities.Employee;
import Company.Entities.Role;
import Company.Entities.Seller;

import java.util.List;

public class Payroll {

    // Um método que receba uma lista de funcionários, mês e ano e retorne
    // o valor total pago (salário e benefício) a esses funcionários no mês.
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

    //Um método que receba uma lista somente com os funcionários que recebem benefícios, mês e ano
    // e retorne o total pago em benefícios no mês.
    public static double calculateTotalBenefitsPaid(List<Employee> employees, int month, int year) {
        double totalBenefitsPaid = 0.0;
        for (Employee employee : employees) {
            if (employee.getRole() != Role.MANAGER) {
                totalBenefitsPaid += employee.calculateBonus(month, year);
            }
        }
        return totalBenefitsPaid;
    }

    //Um método que receba uma lista de funcionários, mês e ano e retorne o que
    //recebeu o valor mais alto no mês.
    public static Employee findEmployeeWithHighestEarnings(List<Employee> employees, int month, int year) {
        Employee highestEarner = null;
        double maxEarnings = 0.0;
        for (Employee employee : employees) {
            double earnings = employee.calculateTotalSalary(month, year);
            if (earnings > maxEarnings) {
                maxEarnings = earnings;
                highestEarner = employee;
            }
        }
        return highestEarner;
    }

    /* Um método que receba uma lista somente com os funcionários que recebem
    benefícios, mês e ano e retorne o nome do funcionário que recebeu o valor mais
    alto em benefícios no mês. */

    public static String findEmployeeWithHighestBenefits(List<Employee> employees, int month, int year) {
        Employee highestBeneficiary = null;
        double maxBenefits = 0.0;
        for (Employee employee : employees) {
            if (employee.getRole() != Role.MANAGER) {
                double benefits = employee.calculateBonus(month, year);
                if (benefits > maxBenefits) {
                    maxBenefits = benefits;
                    highestBeneficiary = employee;
                }
            }
        }
        return highestBeneficiary != null ? highestBeneficiary.getName() : "";
    }
}
