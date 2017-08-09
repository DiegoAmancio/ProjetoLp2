package pacotePrincipal;

import java.util.ArrayList;
import java.util.List;

import Enums.Genero;

public class BluRaySerie extends BluRay{
	private Genero genero;
	private int numeroDaTemporada;
	private List<BluRay> temporada = new ArrayList<BluRay>();
	
	public BluRaySerie(String nome, int preco, int duracao, String classificacao, String genero, int numeroDaTemporada) {
		super(nome, preco, duracao, classificacao);
		verificaGenero(genero);
		this.numeroDaTemporada = numeroDaTemporada;
	}
	
	public int duracaoTotal(){
		int totalDuracao = 0;
		
		for(BluRay br : temporada){
			totalDuracao += br.getDuracao();
		}
		
		return totalDuracao;
	}	
		

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + numeroDaTemporada;
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
		if (numeroDaTemporada != other.numeroDaTemporada)
			return false;
		return true;
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

	public int getNumeroDaTemporada() {
		return numeroDaTemporada;
	}

	public void setNumeroDaTemporada(int numeroDaTemporada) {
		this.numeroDaTemporada = numeroDaTemporada;
	}

	public List<BluRay> getTemporada() {
		return temporada;
	}

	public void setTemporada(List<BluRay> temporada) {
		this.temporada = temporada;
	}
	
	@Override
	public String getInfo(String atributo) {
		String info = super.getInfo(atributo);
		switch (atributo) {
		case "Genero":
			info += this.getGenero();
			return info;
		case "Temporada":
			info += this.getNumeroDaTemporada();
			return info;
		default:
			throw new IllegalArgumentException();
		}
	}
	
}
