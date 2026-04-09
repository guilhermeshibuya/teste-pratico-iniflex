package io.github.guilhermeshibuya.testepraticoiniflex.models;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

import io.github.guilhermeshibuya.testepraticoiniflex.enums.Role;

public class Employee extends Person {
	private BigDecimal salary;
	private Role role;
	private static Locale ptBr = Locale.of("pt", "BR");
	private NumberFormat numberFormatter = NumberFormat.getCurrencyInstance(ptBr);
	
	
	public Employee(String name, LocalDate birthDate, BigDecimal salary, Role role) {
		super(name, birthDate);
		this.salary = salary;
		this.role = role;
	}
	
	@Override
	public String toString() {
		return this.getName() + " - " + this.role.getDescription() + "\n- Data de nascimento: " + this.getBirthDateFormatted() + "\n- Salário: " + numberFormatter.format(this.salary) ;
	}

	public BigDecimal getSalary() {
		return this.salary;
	}
	
	public void setSalary(BigDecimal newSalary) {
		this.salary = newSalary;
	}
	
	public Role getRole() {
		return this.role;
	}
	
	public void setRole(Role newRole) {
		this.role = newRole;
	}
}
