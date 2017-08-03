package pacotePrincipal;

import Enums.Classificacao;

public class BluRay {
	private int duracao;
	private Classificacao classificacao;
	
	public BluRay(int duracao, String classificacao){
		this.duracao = duracao;
		verificaClassificacao(classificacao);
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
