package Enums;
/**
* representacao das plataformas para um jogo
* 
* 
* Laboratorio de Programacao 2 - projeto
* 
* @author Diego Amancio - 116210716
*/

public enum Plataformas {
	PC("PC"), MAC("MAC"), PS3("PS3"), PS4("PS4"), XBOX360("XBOX360"), XBOX_ONE("XBOX_ONE"), NINTENDO_3DS("NITENDO_3DS"), OUTRO("OUTRO");
	private String plataforma;

	private Plataformas(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getPlataforma() {
		return plataforma;
	}
	
}
