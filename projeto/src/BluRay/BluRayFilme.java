package BluRay;

import Enums.Genero;

/**
 * Representa o BluRayFilme. Atribui-se BRF para BluRayFilme
 * 
 * @author Isaac Meneses Mat.: 116.111.246
 *
 */
public class BluRayFilme extends BluRay {
	private Genero genero;
	private int anoLancamento;

	/**
	 * Construtor de BRF
	 * 
	 * @param nome
	 *            (nome do BRF)
	 * @param preco
	 *            (preco do BRF)
	 * @param duracao
	 *            (duracao do BRF)
	 * @param classificacao
	 *            (classificacao do BRF)
	 * @param genero
	 *            (genero do BRF)
	 * @param anoLancamento
	 *            (ano de lancamento do BRF)
	 * 
	 */
	public BluRayFilme(String nome, double preco, int duracao, String classificacao, String genero, int anoLancamento) {
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
	
	@Override
	public String getInfoItem(String atributo) {
		String info = super.getInfoItem(atributo);
		switch (atributo) {
		case "Genero":
			info += this.getGenero();
			return info;
		case "Ano de Lancamento":
			info += this.getAnoLancamento();
			return info;
		default:
			throw new IllegalArgumentException();
		}
	}
	@Override
	public String toString() {
		return "FILME: " + super.toString() + this.genero.getMensagem()+", "+ this.anoLancamento ;
	}
	
}

