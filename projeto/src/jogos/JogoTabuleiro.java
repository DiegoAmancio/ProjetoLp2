package jogos;

import java.util.ArrayList;
import java.util.List;

import enums.Completo;
import item.Item;

public class JogoTabuleiro extends Item {
	private Completo jogoCompleto;
	private List<Peca> pecasPerdidas;

	public JogoTabuleiro(String donoItem, String nome, double preco) {
		super(donoItem, nome, preco);
		pecasPerdidas = new ArrayList<>();
		this.jogoCompleto = Completo.COMPLETO;
	}

	public void adicionaPecaPerdida(String nomePeca) {
		pecasPerdidas.add(new Peca(nomePeca));
		this.jogoCompleto = Completo.NAO_COMPLETO;
	}

	public boolean isJogoCompleto() {
		return jogoCompleto.getValor();
	}

	public List<Peca> getPecasPerdidas() {
		return pecasPerdidas;
	}

	public void setPecasPerdidas(List<Peca> pecasPerdidas) {
		this.pecasPerdidas = pecasPerdidas;
	}

	@Override
	public String getInfoItem(String atributo) {
		String info = super.getInfoItem(atributo);
		if (info.equals("")) {
			throw new IllegalArgumentException();
		}
		return info;
	}

	@Override
	public String toString() {
		return "JOGO DE TABULEIRO: " + super.toString() + ", " + jogoCompleto.getMensagem();
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
