package pacotePrincipal;

import java.util.ArrayList;
import java.util.List;

public class BluRaySerie extends BluRay{
	private String genero;
	private int numeroDaTemporada;
	private List<BluRay> temporada = new ArrayList<BluRay>();
	
	public BluRaySerie(String nome, int preco, int duracao, String classificacao, String genero, int numeroDaTemporada) {
		super(nome, preco, duracao, classificacao);
		this.genero = genero;
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
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
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
	
}
