package pacotePrincipal;

import Enums.Classificacao;

public class BluRay {
	private int duracao;
	private Classificacao classificacao;
	
	public BluRay(int duracao, String classificacao){
		this.duracao = duracao;
		verificClassificacao(classificacao);
	}
	
	private void verificClassificacao(String classificacao){
		
		if(classificacao.toUpperCase().trim().equals("LIVRE")){
			this.classificacao = Classificacao.LIVRE;
		}
		if(classificacao.toUpperCase().trim().equals("DEZ ANOS")){
			this.classificacao = Classificacao.DEZ_ANOS;
		}
		if(classificacao.toUpperCase().trim().equals("DOZE ANOS")){
			this.classificacao = Classificacao.DOZE_ANOS;
		}
		if(classificacao.toUpperCase().trim().equals("QUATORZE ANOS")){
			this.classificacao = Classificacao.QUATORZE_ANOS;
		}
		if(classificacao.toUpperCase().trim().equals("DEZESSEIS ANOS")){
			this.classificacao = Classificacao.DEZESSEIS_ANOS;
		}
		if(classificacao.toUpperCase().trim().equals("DEZOITO ANOS")){
			this.classificacao = Classificacao.DEZOITO_ANOS;
		}
		
	}
	
}
