package pacotePrincipal;

import java.util.ArrayList;
import java.util.List;

public class ItemController {
	private List<Item> itens;
	private ArrayList<JogoTabuleiro> tabuleiros;
	private ArrayList<Eletronico> eletronicos;
	private ArrayList<BluRay> blurays;
	
	public ItemController(){
		this.itens = new ArrayList<Item>();
		this.tabuleiros = new ArrayList<JogoTabuleiro>();
		this.eletronicos = new ArrayList<Eletronico>();
		this.blurays = new ArrayList<BluRay>();
	}
	public void cadastraItem(String nomeItem,double preco,String plataforma){
		Eletronico novoEletronico = new Eletronico(nomeItem, preco, plataforma);
		boolean cadastra = true;
		
		for (Eletronico eletronico : eletronicos) {
			if(eletronico.equals(novoEletronico)){
				cadastra = false;
			}
		}
		if(cadastra){
			itens.add(novoEletronico);
			eletronicos.add(novoEletronico);
		}
	}
	public void cadastraJogoTabuleiro(String nomeItem,double preco){
		JogoTabuleiro novoTabuleiro = new JogoTabuleiro(nomeItem, preco);
		
		boolean cadastra = true;
		
		for (JogoTabuleiro tabuleiro : tabuleiros) {
			if(tabuleiro.equals(novoTabuleiro)){
				cadastra = false;
			}
		}
		if(cadastra){
			itens.add(novoTabuleiro);
			tabuleiros.add(novoTabuleiro);
		}
	}
	
}
