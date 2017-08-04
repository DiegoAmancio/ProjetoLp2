
package Enums;
/**
* representação das plataformas para um jogo
* 
* 
* Laboratório de Programação 2 - projeto
* 
* @author Diego Amancio - 116210716
*/

public enum Plataforma {
	PC("PC"), MAC("MAC"), PS3("PS3"), PS4("PS4"), XBOX360("XBOX360"), XBOX_ONE("XBOX_ONE"), NINTENDO_3DS("NITENDO_3DS"), OUTRO("OUTRO");
	private String valor;

	private Plataforma(String plataforma) {
		this.valor = plataforma;
	}

	public String getValor() {
		return valor;
	}
	