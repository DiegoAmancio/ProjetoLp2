package pacotePrincipal;

import Enums.Classificacao;

public class BluRay extends Item {
	private int duracao;
	private Classificacao classificacao;
	
	
	
	public BluRay(String nome, double preco2, int duracao, String classificacao) {
		super(nome, preco2);
		this.duracao = duracao;
		verificaClassificacao(classificacao);;
	}

	public int getDuracao() {
		return duracao;
	}

	public Classificacao getClassificacao() {
		return classificacao;
	}

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
	
}