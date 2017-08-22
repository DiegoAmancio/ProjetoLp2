package jogos;

public class Peca {
	
	private String nome;
	
	public Peca(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return nome;
	}

}
