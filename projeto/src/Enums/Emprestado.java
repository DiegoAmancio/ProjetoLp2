package Enums;

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
