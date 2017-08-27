package enums;

/**
 * representação das classificações para um cartão fidelidade
 * 
 * 
 * Laboratório de Programação 2 - projeto
 * 
 * @author Diego Amancio - 116210716
 */
public enum CartaoFidelidade {
	NOOB("Noob"),
	CALOTEIRO("Caloteiro"),
	BOM_AMIGO("BomAmigo"),
	FREE_RIDER("FreeRyder");
	
	private String mensagem;
	/**
	 **
	 * constroi uma cartão;
	 * @param mensagem parametro que diz o tipo do cartãp;
	 */
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
