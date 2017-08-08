package midias;

public class BluRayFilme extends BluRay{
	private String genero;
	private int anoLancamento;	
	
	public BluRayFilme(String nome, int preco, int duracao, String classificacao, String genero, int anoLancamento, String nomeArtista, int numeroFaixas) {
		super(nome, preco, duracao, classificacao);
		this.genero = genero;
		this.anoLancamento = anoLancamento;
	}
	
}
