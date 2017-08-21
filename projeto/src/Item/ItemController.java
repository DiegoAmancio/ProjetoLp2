package Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import BluRay.BluRayFilme;
import BluRay.BluRaySerie;
import BluRay.BluRayShow;
import Enums.Emprestado;
import Jogos.JogoEletronico;
import Jogos.JogoTabuleiro;
import emprestismo.Emprestimo;

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
	 * @param nomeItem 
	 * @param preco
	 *            preco do Eletronico a ser cadastrado.
	 * @param plataforma
	 *            plataforma do Eletronico a ser cadastrado.
	 * @return
	 *            retorna o objeto Eletronico que foi cadastrado.
	 */
	public Item cadastrarEletronico(String nome, String nomeItem, double preco, String plataforma) {
		Item item = new JogoEletronico(nome,nomeItem, preco, plataforma);
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
	public Item cadastrarJogoTabuleiro(String nome,String nomeItem, double preco) {
		Item item = new JogoTabuleiro(nome,nomeItem, preco);
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
	public Item cadastrarBluRayFilme(String dono,String nome, double preco, int duracao, String genero, String classificacao, int anoLancamento) {
		Item item = new BluRayFilme(dono,nome, preco, duracao, classificacao, genero, anoLancamento);
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
	public Item cadastrarBluRayShow(String dono,String nome, double preco, int duracao, int numeroFaixas, String artista, String classificacao) {
		Item item = new BluRayShow(dono,nome, preco, duracao, classificacao, numeroFaixas, artista);
		itens.add(item);
		return item;
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
	public Item cadastrarBluRaySerie(String dono,String nome, double preco, String descricao, int duracao, String classificacao, String genero, int numeroDaTemporada) {
		Item item = new BluRaySerie(dono,nome, preco, duracao, classificacao, genero, numeroDaTemporada);
		itens.add(item);
		return item;
	}
	
	public Item getItem(String nomeItem){
		for (int i = 0; i < itens.size(); i++) {
			if(itens.get(i).getNome().equals(nomeItem)){
				return itens.get(i);
			}
			
		}
		throw new NullPointerException("Item nao encontrado");
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
	
	public void removeItem(String nomeItem) {
		Item item = getItem(nomeItem);
		itens.remove(item);
	}
	
	/**
	 * Ordena a lista de objetos Item e concatena os componentes em uma so String.
	 * 
	 * @return
	 *            Representacao em String de todos os objetos Item cadastrados, em ordem alfanumerica.
	 */
	public String listarItensOrdenadosPorNome() {		
		Collections.sort(itens,new ItemNomeComparator());
		String mensagem = "";
		for (int i = 0; i < itens.size(); i++) {
			mensagem += itens.get(i).toString() + "|";
		}
		return mensagem;
	}
	
	/**
	 * Ordena a lista de objetos Item e concatena os componentes em uma so String.
	 * 
	 * @return
	 *            Representacao em String de todos os objetos Item cadastrados, ordenados pelo preco.
	 */
	public String listarItensOrdenadosPorValor() {
		itens.sort(new ItemPrecoComparator());
		String mensagem = "";
		for (int i = 0; i < itens.size(); i++) {
			mensagem += itens.get(i).toString() + "|";
		}
		return mensagem;
	}

	public void adicionarHistorico(String itemEmprestado, Emprestimo novoEmprestimo) {
		for (int i = 0; i < itens.size(); i++) {
			if(itens.get(i).getNome().equals(itemEmprestado)){
				itens.get(i).adicionarHistorico(novoEmprestimo);
			}
		}
		
	}
	public String historicoEmprestimosItem(String nomeItem){
		return getItem(nomeItem).emprestimos();
		
	}
	public String listarItensNaoEmprestados(){
		Collections.sort(itens,new ItemNomeComparator());
		String saida = "";
		for (int i = 0; i < itens.size(); i++) {
			if(itens.get(i).getEmprestado().equals(Emprestado.NAO_EMPRESTADO)){
				saida += itens.get(i).toString()+"|";
			}
		}
		return saida;
	}
	public String listarItensEmprestados(){
		ArrayList<Item> itensEmprestados = retornarArray();
		String saida = "";
		
		for (int i = 0; i < itensEmprestados.size(); i++) {
			if(itensEmprestados.get(i).getEmprestado().equals(Emprestado.EMPRESTADO)){
				saida += "Dono do item: "+itensEmprestados.get(i).getDonoItem()+", Nome do item emprestado: "+itensEmprestados.get(i).getNome()+"|";
			}
		}
		return saida;
	}

	private ArrayList<Item> retornarArray() {
		ArrayList<Item> itensEmprestados = new ArrayList<>();
		Collections.sort(itens,new ItemNomeComparator());
		for (int i = 0; i < itens.size(); i++) {
			if(itens.get(i).getEmprestado().equals(Emprestado.EMPRESTADO)){
				itensEmprestados.add(itens.get(i));
			}
		}
		return itensEmprestados;
		
	}
	public String top10() {
		String saida = "";
		ArrayList<Item> itens = ordenarPorEmprestimos();
		for (int i = 0; i < this.itens.size(); i++) {
			Item item = this.itens.get(i);
			saida += (i+1) + ") " + item.numeroEmprestimos() + " emprestimos" + item.toString() + "|";
		}
		return saida;
		
	}
	public ArrayList<Item> ordenarPorEmprestimos(){
		ArrayList<Item> itens = new ArrayList<>();
		
		for (int i = 0; i <this.itens.size(); i++) {
			if(this.itens.get(i).numeroEmprestimos() == 0) {
				break;
			}
			itens.add(this.itens.get(i));
		}
		Collections.sort(itens,new ItemCompararNumeroEmprestimos());
		return itens;
	}
	
	
}