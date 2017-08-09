package pacotePrincipal;

import Enums.Classificacao;

/**	representa a classe BluRay. Esta classe é subclasse de Item
 * 
 * @author Isaac Meneses - Mat.: 116.111.246
 *
 */
public class BluRay extends Item {

	private int duracao;
	private Classificacao classificacao;
	
	
	/**
	 * Representa o construtor do BluRay.
	 * @param nome (nome do BluRay)
	 * @param preco (preco do BluRay)
	 * @param duracao (duracao do Bluray)
	 * @param classificacao (classificacao do BluRay)
	 */
	public BluRay(String nome, int preco, int duracao, String classificacao) {
		super(nome, preco);
		verificaClassificacao(classificacao);
		this.duracao = duracao;
	}
	
	/**
	 * Verifica a entrada da classificacao para atribuir o toString do ENUM Classificacao
	 * @param classificacao (classificacao do BluRay)
	 */
	private void verificaClassificacao(String classificacao){
		
		switch(classificacao.toUpperCase().trim()){
			case "LIVRE":
				this.classificacao = Classificacao.LIVRE;
				break;
			case "DEZ ANOS":
				this.classificacao = Classificacao.DEZ_ANOS;
				break;
			case "DOZE ANOS":
				this.classificacao = Classificacao.DOZE_ANOS;
				break;
			case "QUATORZE ANOS":
				this.classificacao = Classificacao.QUATORZE_ANOS;
				break;
			case "DEZESSEIS ANOS":
				this.classificacao = Classificacao.DEZESSEIS_ANOS;
				break;
			case "DEZOITO ANOS":
				this.classificacao = Classificacao.DEZOITO_ANOS;
				break;
			default:
				throw new IllegalArgumentException();				
		}		
				
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public Classificacao getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(Classificacao classificacao) {
		this.classificacao = classificacao;
	}

	
}
