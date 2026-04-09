package io.github.guilhermeshibuya.testepraticoiniflex.utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import io.github.guilhermeshibuya.testepraticoiniflex.enums.Role;
import io.github.guilhermeshibuya.testepraticoiniflex.models.Employee;

public class EmployeesMock {
	public static List<Employee> generateData() {
		// 3.1 Inserir todos os funcionários, na mesma ordem e informações da tabela
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), Role.OPERADOR));
		employees.add(new Employee("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), Role.OPERADOR));
		employees.add(new Employee("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), Role.COORDENADOR));
		employees.add(new Employee("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), Role.DIRETOR));
		employees.add(new Employee("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), Role.RECEPCIONISTA));
		employees.add(new Employee("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), Role.OPERADOR));
		employees.add(new Employee("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), Role.CONTADOR));
		employees.add(new Employee("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), Role.GERENTE));
		employees.add(new Employee("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), Role.ELETRICISTA));
		employees.add(new Employee("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), Role.GERENTE));
		
		return employees;
	}
}
