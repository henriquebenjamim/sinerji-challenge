package org.example;

import Company.Entities.*;
import Company.Payments.Payroll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Manager juliana = new Manager("Juliana Alves", LocalDate.of(2017, 7, 1));
        Manager bento = new Manager("Bento Albino", LocalDate.of(2014, 3, 1));

        Seller joao = new Seller("João Mendes", LocalDate.of(2021, 12, 1));
        Seller ana = new Seller("Ana Silva", LocalDate.of(2021, 12, 1));

        Secretary maria = new Secretary("Maria Souza", LocalDate.of(2015, 12, 1));
        Secretary jorge = new Secretary("Jorge Carvalho", LocalDate.of(2018, 1, 1));


        ana.addSale(ana, LocalDate.of(2021, 12, 1), 5200.0);
        ana.addSale(ana, LocalDate.of(2022, 1, 1), 4000.0);
        ana.addSale(ana, LocalDate.of(2022, 2, 1), 4200.0);
        ana.addSale(ana, LocalDate.of(2022, 3, 1), 5850.0);
        ana.addSale(ana, LocalDate.of(2022, 4, 1), 7000.0);

        joao.addSale(joao, LocalDate.of(2021, 12, 1), 3400);
        joao.addSale(joao, LocalDate.of(2022, 1, 1), 7700);
        joao.addSale(joao, LocalDate.of(2022, 2, 1), 5000);
        joao.addSale(joao, LocalDate.of(2022, 3, 1), 5900);
        joao.addSale(joao, LocalDate.of(2022, 4, 1), 6500);


        List<Employee> employees = new ArrayList<>();
        employees.add(juliana);
        employees.add(bento);
        employees.add(joao);
        employees.add(ana);
        employees.add(maria);
        employees.add(jorge);

        int month = 2;
        int year = 2022;

        double totalValuePaid = Payroll.calculateTotalValuePaid(employees, month, year);
        System.out.println("Total pago no mês " + month + "/" + year + ": R$" + totalValuePaid);

        double totalSalaryPaid = Payroll.calculateTotalSalaryPaid(employees, month, year);
        System.out.println("Total pago somente em salários no mês " + month + "/" + year + ": R$" + totalSalaryPaid);

        double totalBenefitsPaid = Payroll.calculateTotalBenefitsPaid(employees, month, year);
        System.out.println("Total pago em benefícios no mês " + month + "/" + year + ": R$" + totalBenefitsPaid);

        Employee highestEarner = Payroll.findEmployeeWithHighestEarnings(employees, month, year);
        System.out.println("Funcionário que recebeu o valor mais alto no mês " + month + "/" + year + ": " + highestEarner.getName()
                + " -> R$ " + highestEarner.calculateTotalSalary(month, year));

        String highestBeneficiary = Payroll.findEmployeeWithHighestBenefits(employees, month, year);
        System.out.println("Nome do funcionário que recebeu o valor mais alto em benefícios no mês "
                + month + "/" + year + ": " + highestBeneficiary );

        Seller bestSeller = Payroll.findBestSeller(employees, month, year);
        System.out.println("Vendedor que mais vendeu no mês " + month + "/" + year + ": " + bestSeller.getName());
    }
}