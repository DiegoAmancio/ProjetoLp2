package enums;

/**
 * representa os tipos de emrpestimos
 * 
 * @author Diego Amancio = 116210716
 *
 */
public enum Emprestado {
	EMPRESTADO("Emprestado"), NAO_EMPRESTADO("Nao emprestado");

	private String emprestado;

	private Emprestado(String emprestado) {
		this.emprestado = emprestado;
	}

	public String getEmprestado() {
		return emprestado;
	}

}
