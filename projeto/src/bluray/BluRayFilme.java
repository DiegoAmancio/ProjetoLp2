package bluray;

public class BluRayFilme extends BluRay{
	private String genero;
	private int anoLancamento;
	private String nomeArtista;
	private int numeroFaixas;
	
	public BluRayFilme(String nome, int duracao, String classificacao, String genero, int anoLancamento, String nomeArtista, int numeroFaixas) {
		super(nome, duracao, classificacao);
		this.genero = genero;
		this.anoLancamento = anoLancamento;
		this.nomeArtista = nomeArtista;
		this.numeroFaixas = numeroFaixas;
	}
	
}
