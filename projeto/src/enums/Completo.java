package enums;

public enum Completo {
	
	COMPLETO("COMPLETO"),
	NAO_COMPLETO("COM PECAS PERDIDAS");
	
	private String mensagem;
	private boolean valor;
	
	Completo(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public boolean getValor() {
		return valor;
	}

}