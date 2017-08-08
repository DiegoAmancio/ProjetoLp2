package bluray;

public class BluRayFilme extends BluRay{
	private String genero;
	private int anoLancamento;	
	
	public BluRayFilme(String nome, int duracao, String classificacao, String genero, int anoLancamento, String nomeArtista, int numeroFaixas) {
		super(nome, duracao, classificacao);
		this.genero = genero;
		this.anoLancamento = anoLancamento;
	}
	
}
