package pacotePrincipal;

public class BluRayShow extends BluRay{
	private int numeroFaixas;
	private String nomeArtista;
	
	public BluRayShow(String nome, int preco, int duracao, String classificacao, int numeroFaixas, String nomeArtista) {
		super(nome, preco, duracao, classificacao);
		this.numeroFaixas = numeroFaixas;
		this.nomeArtista = nomeArtista;
	}

	public int getNumeroFaixas() {
		return numeroFaixas;
	}

	public void setNumeroFaixas(int numeroFaixas) {
		this.numeroFaixas = numeroFaixas;
	}

	public String getNomeArtista() {
		return nomeArtista;
	}

	public void setNomeArtista(String nomeArtista) {
		this.nomeArtista = nomeArtista;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nomeArtista == null) ? 0 : nomeArtista.hashCode());
		result = prime * result + numeroFaixas;
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
		BluRayShow other = (BluRayShow) obj;
		if (nomeArtista == null) {
			if (other.nomeArtista != null)
				return false;
		} else if (!nomeArtista.equals(other.nomeArtista))
			return false;
		if (numeroFaixas != other.numeroFaixas)
			return false;
		return true;
	}
	
}
