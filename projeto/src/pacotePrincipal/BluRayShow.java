package pacotePrincipal;

/**
 * Representa o BluRayShow.
 * 
 * @author Isaac Meneses. Mat.: 116.111.246
 *
 */
public class BluRayShow extends BluRay {
	private int numeroFaixas;
	private String artista;

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
	 * @param artista
	 *            (nome do artista do BRS)
	 */
	public BluRayShow(String nome, double preco, int duracao, String classificacao, int numeroFaixas, String artista) {
		super(nome, preco, duracao, classificacao);
		this.numeroFaixas = numeroFaixas;
		this.artista = artista;
	}

	public int getNumeroFaixas() {
		return numeroFaixas;
	}

	public void setNumeroFaixas(int numeroFaixas) {
		this.numeroFaixas = numeroFaixas;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String nomeArtista) {
		this.artista = nomeArtista;
	}
	
	@Override
	public String getInfo(String atributo) {
		String info = super.getInfo(atributo);
		switch (atributo) {
		case "Artista":
			info += this.getArtista();
			return info;
		case "Faixas":
			info += this.getNumeroFaixas();
			return info;
		default:
			if (info == "") {
				throw new IllegalArgumentException();
			}
			return info;
		}
	}
	
	@Override
	public String toString() {
		return "SHOW: " + super.toString() + ", " + artista + ", " + numeroFaixas + " faixas";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((artista == null) ? 0 : artista.hashCode());
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
		if (artista == null) {
			if (other.artista != null)
				return false;
		} else if (!artista.equals(other.artista))
			return false;
		if (numeroFaixas != other.numeroFaixas)
			return false;
		return true;
	}

}
