package midias;

import Enums.Classificacao;
import pacotePrincipal.Item;

<<<<<<< HEAD:projeto/src/midias/BluRay.java
public class BluRay extends Item{
=======
public class BluRay extends Item {
>>>>>>> b23e0f50b49d1ec935f36db0117c41f15654a88e:projeto/src/pacotePrincipal/BluRay.java
	private int duracao;
	private Classificacao classificacao;
	
	
<<<<<<< HEAD:projeto/src/midias/BluRay.java
	public BluRay(String nome, int preco, int duracao, String classificacao) {
		super(nome, preco);		
=======
	
	public BluRay(String nome, double preco2, int duracao, String classificacao) {
		super(nome, preco2);
>>>>>>> b23e0f50b49d1ec935f36db0117c41f15654a88e:projeto/src/pacotePrincipal/BluRay.java
		this.duracao = duracao;
		verificaClassificacao(classificacao);;
	}
<<<<<<< HEAD:projeto/src/midias/BluRay.java
	
	
=======

	public int getDuracao() {
		return duracao;
	}

	public Classificacao getClassificacao() {
		return classificacao;
	}

>>>>>>> b23e0f50b49d1ec935f36db0117c41f15654a88e:projeto/src/pacotePrincipal/BluRay.java
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
