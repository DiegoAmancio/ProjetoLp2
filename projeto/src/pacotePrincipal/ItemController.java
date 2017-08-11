package pacotePrincipal;

import java.util.ArrayList;
import java.util.List;

public class ItemController {
	
	private List<Item> itens;
	
	public ItemController() {
		itens = new ArrayList<Item>();
	}
	
	public Item cadastrarEletronico(String nome, double preco, String plataforma) {
		Item item = new Eletronico(nome, preco, plataforma);
		itens.add(item);
		return item;
	}
	
	public Item cadastrarJogoTabuleiro(String nome, double preco) {
		Item item = new JogoTabuleiro(nome, preco);
		itens.add(item);
		return item;
	}
	
	public Item cadastrarBluRayFilme(String nome, double preco, int duracao, String genero, String classificacao, int anoLancamento) {
		Item item = new BluRayFilme(nome, preco, duracao, classificacao, genero, anoLancamento);
		itens.add(item);
		return item;
	}
	
	public Item cadastrarBluRayShow(String nome, double preco, int duracao, int numeroFaixas, String artista, String classificacao) {
		Item item = new BluRayShow(nome, preco, duracao, classificacao, numeroFaixas, artista);
		itens.add(item);
		return item;
	}
	
	public Item cadastrarBluRaySerie(String nome, double preco, String descricao, int duracao, String classificacao, String genero, int temporada) {
		Item item = new BluRaySerie(nome, preco, descricao, duracao, classificacao, genero, temporada);
		itens.add(item);
		return item;
	}
	
	public void adicionarPecaPerdida(Item item, String nomePeca) {
		if (item instanceof JogoTabuleiro) {
			JogoTabuleiro jogoTabuleiro = (JogoTabuleiro) item;
			jogoTabuleiro.adicionaPecaPerdida(nomePeca);
		} else {
			throw new IllegalArgumentException("Esse item nao se trata de um Jogo de Tabuleiro");
		}
	}
	
	public void adicionarBluRay(Item item, int duracao) {
		if (item instanceof BluRaySerie) {
			BluRaySerie bluRaySerie = (BluRaySerie) item;
			bluRaySerie.adicionaEpisodio(duracao);
		} else {
			throw new IllegalArgumentException("Esse item nao se trata de uma Serie");
		}
	}
	
	public String listarItensOrdenadosPorNome() {		
		itens.sort(new ItemNomeComparator());
		
		String mensagem = itens.get(0).toString();
		
		for (int i = 1; i < itens.size(); i++) {
			mensagem += itens.get(i).toString();
		}
		return mensagem+"|";
	}
	
	public String listarItensOrdenadosPorValor() {
		itens.sort(new ItemPrecoComparator());
		String mensagem = itens.get(0).toString();
		for (int i = 1; i < itens.size(); i++) {
			mensagem += itens.get(i).toString();
		}
		return mensagem+"|";
	}
	
}
