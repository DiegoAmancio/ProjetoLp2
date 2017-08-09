package pacotePrincipal;

/**
 * Representa o BluRayShow.
 * 
 * @author Isaac Meneses. Mat.: 116.111.246
 *
 */
public class BluRayShow extends BluRay {
	private int numeroFaixas;
	private String nomeArtista;

	/**
	 * Construtor de BluRayShow. Atribui-se BRS para BluRayShow
	 * 
	 * @param nome
	 *            (nome do BRS)
	 * @param preco
	 *            (preco do BRS)
	 * @param duracao
	 *            (duracao do BRS)
	 * @param classificacao
	 *            (classificacao do BRS)
	 * @param numeroFaixas
	 *            (numero de faixas do BRS)
	 * @param nomeArtista
	 *            (nome do artista do BRS)
	 */
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
	public String getInfo(String atributo) {
		String info = super.getInfo(atributo);
		switch (atributo) {
		case "Artista":
			info += this.getNomeArtista();
			return info;
		case "Faixas":
			info += this.getNumeroFaixas();
			return info;
		default:
			throw new IllegalArgumentException();
		}
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
