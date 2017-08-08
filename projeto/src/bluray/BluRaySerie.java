package bluray;

import java.util.ArrayList;
import java.util.List;

public class BluRaySerie extends BluRay{
	private String genero;
	private int numeroDaTemporada;
	private List<BluRay> temporada = new ArrayList<BluRay>();
	
	public BluRaySerie(String nome, int duracao, String classificacao) {
		super(nome, duracao, classificacao);
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
