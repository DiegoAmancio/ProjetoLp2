package Enums;

public enum Emprestado {
	EMPRESTADO("Emprestado"),
	NAO_EMPRESTADO("Nao emprestado");
	
	private String emprestado;

	private Emprestado(String emprestado) {
		this.emprestado = emprestado;
	}

	public String getEmprestado() {
		return emprestado;
	}

	
}
