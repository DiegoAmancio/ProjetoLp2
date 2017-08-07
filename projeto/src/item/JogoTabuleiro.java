package item;

import java.util.ArrayList;
import java.util.List;

public class JogoTabuleiro extends Item{

	private List<Peca> pecasPerdidas;
	
	public JogoTabuleiro(String nome, int preco) {
		super(nome, preco);
		pecasPerdidas = new ArrayList<>();
	}
	
	public List<Peca> getPecasPerdidas() {
		return pecasPerdidas;
	}

	public boolean estaCompleto() {
		if (pecasPerdidas.size() == 0) {
			return true;
		}
		return false;
	}
	
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			if (obj instanceof JogoTabuleiro) {
				if (((JogoTabuleiro) obj).getPecasPerdidas().equals(pecasPerdidas)) {
					return true;
				}
			}
		}
		return false;
	}

}
