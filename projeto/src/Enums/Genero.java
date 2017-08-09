package Enums;

/**
 * 
 * @author Andre
 *
 */

public enum Genero {
	ACAO("ACAO"),
	ANIMACAO("ANIMACAO"),
	AVENTURA("AVENTURA"),
	COEMDIA("COEMDIA"),
	DOCUMENTARIO("DOCUMENTARIO"),
	DRAMA("DRAMA"),
	EROTICO("EROTICO"),
	FAROESTE("FAROESTE"),
	FICCAO("FICCAO"),
	MUSICAL("MUSICAL"),
	POLICIAL("POLICIAL"),
	ROMANCE("ROMANCE"),
	SUSPENSE("SUSPENSE"),
	TERROR("TERROR"),
	OUTRO("OUTRO");
	
	private String mensagem;
	
	Genero(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public String getMensagem() {
		return mensagem;
	}

}
