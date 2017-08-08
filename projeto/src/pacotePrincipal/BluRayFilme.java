package pacotePrincipal;

public class BluRayFilme extends BluRay{
	private String genero;
	private int anoLancamento;	
	
	public BluRayFilme(String nome, int preco, int duracao, String classificacao, String genero, int anoLancamento, String nomeArtista, int numeroFaixas) {
		super(nome, preco, duracao, classificacao);
		this.genero = genero;
		this.anoLancamento = anoLancamento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}
	
	
	
}
