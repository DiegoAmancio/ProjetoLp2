package enums;

public enum CartaoFidelidade {
	NOOB("Noob"),
	CALOTEIRO("Caloteiro"),
	BOM_AMIGO("BomAmigo"),
	FREE_RIDER("FreeRyder");
	
	private String mensagem;

	private CartaoFidelidade(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
