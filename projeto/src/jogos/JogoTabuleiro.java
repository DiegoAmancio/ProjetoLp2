package jogos;

import java.util.HashSet;

import pacotePrincipal.Item;

public class JogoTabuleiro extends Item{
	private boolean jogoCompleto;
	private HashSet<String> pecasPerdidas = new HashSet<String>();
	
	public JogoTabuleiro(String nome, int preco, boolean jogoCompleto) {
		super(nome, preco);	
		this.jogoCompleto = jogoCompleto;
	}

	public boolean isJogoCompleto() {
		return jogoCompleto;
	}

	public void setJogoCompleto(boolean jogoCompleto) {
		this.jogoCompleto = jogoCompleto;
	}

	public HashSet<String> getPecasPerdidas() {
		return pecasPerdidas;
	}

	public void setPecasPerdidas(HashSet<String> pecasPerdidas) {
		this.pecasPerdidas = pecasPerdidas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((pecasPerdidas == null) ? 0 : pecasPerdidas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		JogoTabuleiro other = (JogoTabuleiro) obj;
		if (pecasPerdidas == null) {
			if (other.pecasPerdidas != null)
				return false;
		} else if (!pecasPerdidas.equals(other.pecasPerdidas))
			return false;
		return true;
	}
	
	

}
