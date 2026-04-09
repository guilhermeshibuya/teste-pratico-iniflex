package io.github.guilhermeshibuya.testepraticoiniflex.main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import io.github.guilhermeshibuya.testepraticoiniflex.enums.Role;
import io.github.guilhermeshibuya.testepraticoiniflex.models.Employee;
import io.github.guilhermeshibuya.testepraticoiniflex.utils.EmployeesMock;

public class Main {

	public static void main(String[] args) {
		Locale ptBr = Locale.of("pt", "BR");
		NumberFormat formatter = NumberFormat.getCurrencyInstance(ptBr);
		
		List<Employee> employees = EmployeesMock.generateData();
		
		// 3.2 Remover funcionário "João" da lista
		employees.removeIf(employee -> employee.getName().equals("João"));
		
		// 3.3 Imprimir todos os funcionários
		System.out.println("\nTodos os funcionários:");
		employees.forEach(employee -> System.out.println("\n" + employee));
		
		// 3.4 Os funcionários receberam 10% de aumento no salário
		BigDecimal increaseSalaryFactor = new BigDecimal("1.1");
		employees.forEach(employee -> employee.setSalary(employee.getSalary().multiply(increaseSalaryFactor)));
		
		
		// 3.5 Agrupar funcionários por cargo
		Map<Role, List<Employee>> employeesByRole = new HashMap<Role, List<Employee>>();
		
		for (Employee employee : employees) {
			List<Employee> list = employeesByRole.get(employee.getRole());
			if (list == null) {
				list = new ArrayList<Employee>();
				employeesByRole.put(employee.getRole(), list);
			}
			list.add(employee);
		}
		
		
		// 3.6 Imprimir funcionários agrupados por cargo
		System.out.println("\nFuncionários agrupados por cargo:");
		employeesByRole.forEach((role, list) -> {
			System.out.println("\nCargo: " + role);
			list.forEach(employee -> System.out.println(" - " + employee.getName()));
		});
		
		
		// 3.8 Imprimir funcionários que fazem aniversário no mês 10 e 12
		System.out.println("\nFuncionários que fazem aniversário no mês 10 e 12:");
		employees.forEach(employee -> {
			int month = employee.getBirthDate().getMonth().getValue();
			if (month == 10 || month == 12) {
				System.out.println("\n" + employee);
			}
		});

		// 3.9 Imprimir funcionário com maior idade
		Employee older = employees.stream()
				.min(Comparator.comparing(Employee::getBirthDate))
				.orElse(null);
		System.out.println("\nFuncionário mais velho: \n\n" + older.getName() + ", " + older.getAge() + " anos");
		
		// 3.10 Imprimir funcionários por ordem alfabética
		System.out.println("\nFuncionários por ordem alfabética: \n");
		employees.sort(Comparator.comparing(Employee::getName));
		employees.forEach(employee -> System.out.println("- " + employee.getName()));
		
		// 3.11 Imprimir o total dos salários dos funcionários
		BigDecimal employeesSalarySum = employees.stream()
				.map(Employee::getSalary)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		System.out.println("\nTotal dos salários dos funcionários: \n" + formatter.format(employeesSalarySum));
		
		// 3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00
		BigDecimal mininumSalary = new BigDecimal("1212.00");
		employees.forEach(employee -> {
			BigDecimal minimumSalaries = employee.getSalary().divide(mininumSalary, 2, RoundingMode.HALF_UP);
			System.out.println("\nFuncionário: " + employee.getName() + "\nSalários mínimos recebido: " + minimumSalaries);
		});
	}

}
