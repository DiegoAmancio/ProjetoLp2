package Enums;

/**
 * Representacao do estado de emprestimo de um Item.
 * 
 * @author Andre Azevedo - 116111248
 */
public enum Emprestado {
	
	EMPRESTADO("Emprestado", true),
	NAO_EMPRESTADO("Nao emprestado", false);
	
	private String mensagem;
	private boolean valor;
	
	Emprestado(String mensagem, boolean valor) {
		this.mensagem = mensagem;
		this.valor = valor;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public boolean getValor() {
		return valor;
	}
	
}
