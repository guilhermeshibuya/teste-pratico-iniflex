package io.github.guilhermeshibuya.testepraticoiniflex.enums;

public enum Role {
	OPERADOR("Operador"),
	COORDENADOR("Coordenador"),
	DIRETOR("Diretor"),
	RECEPCIONISTA("Recepcionista"),
	CONTADOR("Contador"),
	GERENTE("Gerente"),
	ELETRICISTA("Eletricista");
	
	private String description;
	
	Role(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
