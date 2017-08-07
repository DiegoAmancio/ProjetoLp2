<<<<<<< HEAD:projeto/src/item/Plataforma.java
package item;
=======
package Enums;

>>>>>>> master:projeto/src/Enums/Plataforma.java
/**
 * representação das plataformas para um jogo
 * 
 * 
 * Laboratório de Programação 2 - projeto
 * 
 * @author Diego Amancio - 116210716
 */

public enum Plataforma {
	PC("PC"), MAC("MAC"), PS3("PS3"), PS4("PS4"), XBOX360("XBOX360"), XBOX_ONE("XBOX_ONE"), NINTENDO_3DS(
			"NITENDO_3DS"), OUTRO("OUTRO");
	
	private String plataforma;
	/**
	 * 
	 * @param plataforma plataforma do jogo eletronico
	 *  
	 */
	private Plataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getValor() {
		return plataforma;
	}
}



