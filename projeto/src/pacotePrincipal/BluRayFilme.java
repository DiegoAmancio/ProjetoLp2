package pacotePrincipal;

import Enums.Genero;

public class BluRayFilme extends BluRay{
	private Genero genero;
	private int anoLancamento;	
	
	public BluRayFilme(String nome, int preco, int duracao, String classificacao, String genero, int anoLancamento, String nomeArtista, int numeroFaixas) {
		super(nome, preco, duracao, classificacao);
		verificaGenero(genero);
		this.anoLancamento = anoLancamento;
	}

	public String getGenero() {
		return genero.getMensagem();
	}

	public void verificaGenero(String genero) {
		switch (genero.toUpperCase().trim()) {
		case "ACAO":
			this.genero = Genero.ACAO;
			break;
		case "ANIMACAO":
			this.genero = Genero.ANIMACAO;
			break;
		case "AVENTURA":
			this.genero = Genero.AVENTURA;
			break;
		case "COEMDIA":
			this.genero = Genero.COEMDIA;
			break;
		case "DOCUMENTARIO":
			this.genero = Genero.DOCUMENTARIO;
			break;
		case "DRAMA":
			this.genero = Genero.DRAMA;
			break;
		case "EROTICO":
			this.genero = Genero.EROTICO;
			break;
		case "FAROESTE":
			this.genero = Genero.FAROESTE;
			break;
		case "FICCAO":
			this.genero = Genero.FICCAO;
			break;
		case "MUSICAL":
			this.genero = Genero.MUSICAL;
			break;
		case "POLICIAL":
			this.genero = Genero.POLICIAL;
			break;
		case "ROMANCE":
			this.genero = Genero.ROMANCE;
			break;
		case "SUSPENSE":
			this.genero = Genero.SUSPENSE;
			break;
		case "TERROR":
			this.genero = Genero.TERROR;
			break;
		case "OUTRO":
			this.genero = Genero.OUTRO;
			break;

		default:
			throw new IllegalArgumentException();
		}
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}
	
	
	
}
