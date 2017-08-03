package Enums;
/**
 * representação das classificações para um bluRay
 * 
 * 
 * Laboratório de Programação 2 - projeto
 * 
 * @author Diego Amancio - 116210716
 */
public enum Classificacao {
	LIVRE("LIVRE"),
	DEZ_ANOS("DEZ_ANOS"),
	DOZE_ANOS("DOZE_ANOS"),
	QUATORZE_ANOS("QUATORZE_ANOS"),
	DEZESSEIS_ANOS("DEZESSEIS_ANOS"),
	DEZOITO_ANOS("DEZOITO_ANOS");

	private String mensagem;
	/**
	 * constroi uma Classificacao;
	 * @param mensagem parametro que diz a classificaçao;
	 */
	private Classificacao(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}
	
	
}
