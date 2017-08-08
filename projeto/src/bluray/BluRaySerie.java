package bluray;

import java.util.ArrayList;
import java.util.List;

public class BluRaySerie extends BluRay{
	private String nome;
	private String genero;
	private int anoLancamentoç;
	private int numeroDaTemporada;
	private List<BluRay> temporada = new ArrayList<BluRay>();
	
	public BluRaySerie(int duracao, String classificacao, String nome) {
		super(duracao, classificacao);
		this.nome = nome;
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
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + numeroDaTemporada;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BluRaySerie other = (BluRaySerie) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numeroDaTemporada != other.numeroDaTemporada)
			return false;
		return true;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getAnoLancamentoç() {
		return anoLancamentoç;
	}

	public void setAnoLancamentoç(int anoLancamentoç) {
		this.anoLancamentoç = anoLancamentoç;
	}

	public int getNumeroDaTemporada() {
		return numeroDaTemporada;
	}

	public void setNumeroDaTemporada(int numeroDaTemporada) {
		this.numeroDaTemporada = numeroDaTemporada;
	}	

}
