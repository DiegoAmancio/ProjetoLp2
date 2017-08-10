package pacotePrincipal;

import java.util.ArrayList;
import java.util.List;

import Enums.Genero;


/**
 * Representa o BluRaySerie. Atribui-se BRS para BluRaySerie
 * 
 * @author Isaac Meneses Mat.: 116.111.246
 *
 */
public class BluRaySerie extends BluRay {
	private String descricao;
	private Genero genero;
	private int temporada;	
	private List<Episodio> episodios = new ArrayList<Episodio>();

	/**
	 * Construtor de BRS.
	 * 
	 * @param nome
	 *            (nome do BRS)
	 * @param preco
	 *            (preco do BRS)
	 * @param duracao
	 *            (duracao do BRS)
	 * @param classificacao
	 *            (classificacao do BRS)
	 * @param genero
	 *            (genero do BRS)
	 * @param temporada
	 *            (numero da temporada do BRS)
	 */
	public BluRaySerie(String nome, double preco, String descricao, int duracao, String classificacao, String genero, int temporada) {
		super(nome, preco, duracao, classificacao);
		this.descricao = descricao;
		verificaGenero(genero);
		this.temporada = temporada;
	}

	/**
	 * Retorna a duracao total dos episodios da temporada
	 * 
	 * @return totalDuracao
	 */
	public int duracaoTotal() {
		int totalDuracao = 0;

		for (Episodio ep : episodios) {
			totalDuracao += ep.getDuracao();
		}

		return totalDuracao;
	}

	/**
	 * Adiciona o episodio se a duracao de episodios da temporada + a duracao do
	 * episodio for menor do que o limite da duracao do BluRaySerie
	 * 
	 * @param duracaoDoEpisodio
	 * @return status da operacao
	 */
	public boolean adicionaEpisodio(int duracaoDoEpisodio) {
		Episodio episodio = new Episodio(duracaoDoEpisodio);
		if (duracaoTotal() + duracaoDoEpisodio < super.getDuracao()) {
			episodios.add(episodio);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + temporada;
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
		BluRaySerie other = (BluRaySerie) obj;
		if (temporada != other.temporada)
			return false;
		return true;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public int getTemporada() {
		return temporada;
	}

	public void setTemporada(int numeroDaTemporada) {
		this.temporada = numeroDaTemporada;
	}

	public List<Episodio> getEpisodios() {
		return episodios;
	}

	public void setEpisodios(List<Episodio> episodios) {
		this.episodios = episodios;
	}
	
	@Override
	public String toString() {
		return "SERIE: " + super.toString() + ", " + genero.getMensagem() + ", Temporada" + temporada;
	}
	
	@Override
	public String getInfo(String atributo) {
		String info = super.getInfo(atributo);
		switch (atributo) {
		case "Genero":
			info += this.getGenero();
			return info;
		case "Temporada":
			info += this.getTemporada();
			return info;
		default:
			throw new IllegalArgumentException();
		}
	}
	
}
