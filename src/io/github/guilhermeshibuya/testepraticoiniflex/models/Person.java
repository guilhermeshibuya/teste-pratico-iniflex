package io.github.guilhermeshibuya.testepraticoiniflex.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person {
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private String name;
	private LocalDate birthDate;
	
	public Person(String name, LocalDate birthDate) {
		this.name = name;
		this.birthDate = birthDate;
	}
	
	public String getBirthDateFormatted() {
		return this.birthDate.format(formatter);
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public LocalDate getBirthDate() {
		return this.birthDate;
	}
	
	
	public void setBirthDate(LocalDate newDate) {
		this.birthDate = newDate;
	}
	
	public int getAge() {
		LocalDate now =  LocalDate.now();
		int age = now.getYear() - this.birthDate.getYear();
		
		return age;
	}
}
