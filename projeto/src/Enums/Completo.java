package Enums;

public enum Completo {
	
	COMPLETO("COMPLETO", true),
	NAO_COMPLETO("COM PECAS PERDIDAS", false);
	
	private String mensagem;
	private boolean valor;
	
	Completo(String mensagem, boolean valor) {
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