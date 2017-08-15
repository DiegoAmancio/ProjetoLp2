package Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import BluRay.BluRayFilme;
import BluRay.BluRaySerie;
import BluRay.BluRayShow;
import Jogos.JogoEletronico;
import Jogos.JogoTabuleiro;

/**
 * Controlador de objetos tipo Item.
 * 
 * @author Andre Azevedo - 116111248
 *
 */

public class ItemController {
	
	private List<Item> itens;
	
	/**
	 * Construtor de ItemController.
	 */
	public ItemController() {
		itens = new ArrayList<Item>();
	}
	
	/**
	 * Cadastra um Item de subtipo Eletronico.
	 * 
	 * @param nome
	 *            nome do Eletronico a ser cadastrado.
	 * @param preco
	 *            preco do Eletronico a ser cadastrado.
	 * @param plataforma
	 *            plataforma do Eletronico a ser cadastrado.
	 * @return
	 *            retorna o objeto Eletronico que foi cadastrado.
	 */
	public Item cadastrarEletronico(String nome, double preco, String plataforma) {
		Item item = new JogoEletronico(nome, preco, plataforma);
		itens.add(item);
		return item;
	}
	
	/**
	 * Cadastra um Item de subtipo JogoTabuleiro.
	 * 
	 * @param nome
	 *            nome do JogoTabuleiro a ser cadastrado.
	 * @param preco
	 *            preco do JogoTabuleiro a ser cadastrado.
	 * @return
	 *            retorna o objeto JogoTabuleiro que foi cadastrado.
	 */
	public Item cadastrarJogoTabuleiro(String nome, double preco) {
		Item item = new JogoTabuleiro(nome, preco);
		itens.add(item);
		return item;
	}
	
	/**
	 * Cadastra um Item de subtipo BluRayFilme.
	 * 	
	 * @param nome
	 *            nome do BluRayFilme a ser cadastrado.
	 * @param preco
	 *            preco do BluRayFilme a ser cadastrado.
	 * @param duracao
	 *            duracao do BluRayFilme a ser cadastrado.
	 * @param genero
	 *            genero do BluRayFilme a ser cadastrado.
	 * @param classificacao
	 *            classificacao indicativa do BluRayFilme a ser cadastrado.
	 * @param anoLancamento
	 *            ano de lancamento do BluRayFilme a ser cadastrado.
	 * @return
	 *            retorna o objeto BluRayFilme que foi cadastrado.
	 */
	public Item cadastrarBluRayFilme(String nome, double preco, int duracao, String genero, String classificacao, int anoLancamento) {
		Item item = new BluRayFilme(nome, preco, duracao, classificacao, genero, anoLancamento);
		itens.add(item);
		return item;
	}
	
	/**
	 * Cadastra um Item de subtipo BluRayShow.
	 * 
	 * @param nome
	 *            nome do BluRayShow a ser cadastrado.
	 * @param preco
	 *            preco do BluRayShow a ser cadastrado.
	 * @param duracao
	 *            duracao do BluRayShow a ser cadastrado.
	 * @param numeroFaixas
	 *            numero de faixas do BluRayShow a ser cadastrado.
	 * @param artista
	 *            nome do artista do BluRayShow a ser cadastrado.
	 * @param classificacao
	 *            classificacao indicativa do BluRayShow a ser cadastrado.
	 * @return
	 *            retorna o objeto BluRayShow que foi cadastrado.
	 */
	public Item cadastrarBluRayShow(String nome, double preco, int duracao, int numeroFaixas, String artista, String classificacao) {
		Item item = new BluRayShow(nome, preco, duracao, classificacao, numeroFaixas, artista);
		itens.add(item);
		return item;
	}
	
	/**
	 * Cadastra um Item de subtipo BluRaySerie.
	 * 
	 * @param nome
	 *            nome do BluRaySerie a ser cadastrado.
	 * @param preco
	 *            preco do BluRaySerie a ser cadastrado.
	 * @param descricao
	 *            descricao do BluRaySerie a ser cadastrado.
	 * @param duracao
	 *            duracao do BluRaySerie a ser cadastrado.
	 * @param classificacao
	 *            classificaco indicativa do BluRaySerie a ser cadastrado.
	 * @param genero
	 *            genero do BluRaySerie a ser cadastrado.
	 * @param temporada
	 *            numero da temporada do BluRaySerie a ser cadastrado.
	 * @return
	 *            retorna o objeto BluRaySerie que foi cadastrado.
	 */
	public Item cadastrarBluRaySerie(String nome, double preco, String descricao, int duracao, String classificacao, String genero, int numeroDaTemporada) {
		Item item = new BluRaySerie(nome, preco, duracao, classificacao, genero, numeroDaTemporada);
		itens.add(item);
		return item;
	}
	
	/**
	 * Adiciona uma Peca a lista de pecas perdidas de um determinado JogoTabuleiro.
	 * 
	 * @param item
	 *            Item que perdeu a peca caso seja um JogoTabuleiro.
	 * @param nomePeca
	 *            nome do objeto Peca que foi perdido.
	 */
	public void adicionarPecaPerdida(Item item, String nomePeca) {
		if (item instanceof JogoTabuleiro) {
			JogoTabuleiro jogoTabuleiro = (JogoTabuleiro) item;
			jogoTabuleiro.adicionaPecaPerdida(nomePeca);
		} else {
			throw new IllegalArgumentException("Esse item nao se trata de um Jogo de Tabuleiro");
		}
	}
	
	/**
	 * Adicona um Episodio a lista de episodios de um determinado BluRaySerie.
	 * 
	 * @param item
	 *            Item que recebe o Episodio caso seja um BluRaySerie.
	 * @param duracao
	 *            duracao do objeto Episodio.
	 */
	public void adicionarBluRay(Item item, int duracao) {
		if (item instanceof BluRaySerie) {
			BluRaySerie bluRaySerie = (BluRaySerie) item;
			bluRaySerie.adicionaEpisodio(duracao);
		} else {
			throw new IllegalArgumentException("Esse item nao se trata de uma Serie");
		}
	}
	
	/**
	 * Ordena a lista de objetos Item e concatena os componentes em uma so String.
	 * 
	 * @return
	 *            Representacao em String de todos os objetos Item cadastrados, em ordem alfanumerica.
	 */
	public String listarItensOrdenadosPorNome() {		
<<<<<<< HEAD:projeto/src/pacotePrincipal/ItemController.java
		itens.sort(new ItemNomeComparator());
		
=======
		itens.sort(new ItemNomeComparator());		
>>>>>>> d8406d058d52bf34bb0414e96702793ada5c1675:projeto/src/Item/ItemController.java
		String mensagem = itens.get(0).toString();
		
		for (int i = 1; i < itens.size(); i++) {
			mensagem += "|" + itens.get(i).toString();
		}
		return mensagem+"|";
	}
	
	/**
	 * Ordena a lista de objetos Item e concatena os componentes em uma so String.
	 * 
	 * @return
	 *            Representacao em String de todos os objetos Item cadastrados, ordenados pelo preco.
	 */
	public String listarItensOrdenadosPorValor() {
		itens.sort(new ItemPrecoComparator());
		String mensagem = itens.get(0).toString();
		for (int i = 1; i < itens.size(); i++) {
			mensagem += "|" + itens.get(i).toString();
		}
		return mensagem+"|";
	}
	
}