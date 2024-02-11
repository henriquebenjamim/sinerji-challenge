import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import Company.Entities.Employee;
import Company.Payments.Payroll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PayrollTest {

    private List<Employee> employees;
    private Payroll payroll;

    @BeforeEach
    public void setUp() {
        employees = new ArrayList<>();
        payroll = new Payroll();
    }

    @Test
    public void testCalculateTotalValuePaid() {
        Employee employee1 = mock(Employee.class);
        Employee employee2 = mock(Employee.class);

        when(employee1.calculateTotalSalary(1, 2022)).thenReturn(3000.0);
        when(employee2.calculateTotalSalary(1, 2022)).thenReturn(5000.0);

        employees.add(employee1);
        employees.add(employee2);

        double totalPaid = payroll.calculateTotalValuePaid(employees, 1, 2022);

        assertEquals(8000.0, totalPaid);
    }

    @Test
    public void testCalculateTotalBenefit() {
        // Mock de um funcionário
        Employee employee = mock(Employee.class);

        // Configuração do valor de benefício para o funcionário
        when(employee.calculateBonus(2, 2022)).thenReturn(500.0);

        // Adiciona o funcionário à lista
        employees.add(employee);

        // Testa o método calculateTotalBenefit
        double totalBenefit = payroll.calculateTotalBenefitsPaid(employees, 2, 2022);

        // Verifica se o valor retornado é o esperado
        assertEquals(500.0, totalBenefit);
    }
}
