package Enums;

/**
 * Representacao do estado de completude de um JogoTabuleiro.
 * 
 * @author Andre Azevedo - 116111248
 */
public enum Completo {
	
	COMPLETO("COMPLETO", true),
	NAO_COMPLETO("COM PECAS FALTANDO", false);
	
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
