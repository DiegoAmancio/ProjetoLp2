package item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import enums.Emprestado;
import bluRay.BluRayFilme;
import bluRay.BluRaySerie;
import bluRay.BluRayShow;
import emprestismo.Emprestimo;
import jogos.JogoEletronico;
import jogos.JogoTabuleiro;

/**
 * Controlador de objetos tipo Item.
 * 
 * @author Andre Azevedo - 116111248
 * @author Diego Amancio - 116210716
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
	 * Adicona um Episodio a lista de episodios de um determinado BluRaySerie.
	 * 
	 * @param item
	 *            Item que recebe o Episodio caso seja um BluRaySerie.
	 * @param duracao
	 *            duracao do objeto Episodio.
	 */
	public void adicionarBluRay(String nomeItem, int duracao) {
		Item item = getItem(nomeItem);
		if (item instanceof BluRaySerie) {
			BluRaySerie bluRaySerie = (BluRaySerie) item;
			bluRaySerie.adicionaEpisodio(duracao);
		} else {
			throw new IllegalArgumentException("Esse item nao se trata de uma Serie");
		}
	}

	/**
	 * Adiciona uma Peca a lista de pecas perdidas de um determinado
	 * JogoTabuleiro.
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
	 * adiciona no historico do item a transção entre os usuarios usando o item
	 * me questão.
	 * 
	 * @param itemEmprestado
	 *            nome do item
	 * @param novoEmprestimo
	 *            emprestimo associado o item
	 */
	public void adicionarHistorico(String itemEmprestado, Emprestimo novoEmprestimo) {
		for (int i = 0; i < itens.size(); i++) {
			if (itens.get(i).getNome().equals(itemEmprestado)) {
				itens.get(i).adicionarHistorico(novoEmprestimo);
			}
		}

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
	 * @return retorna o objeto Eletronico que foi cadastrado.
	 */
	public Item cadastrarEletronico(String nome, String nomeItem, double preco, String plataforma) {
		Item item = new JogoEletronico(nome, nomeItem, preco, plataforma);
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
	 * @return retorna o objeto JogoTabuleiro que foi cadastrado.
	 */
	public Item cadastrarJogoTabuleiro(String nome, String nomeItem, double preco) {
		Item item = new JogoTabuleiro(nome, nomeItem, preco);
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
	 * @return retorna o objeto BluRayFilme que foi cadastrado.
	 */
	public Item cadastrarBluRayFilme(String dono, String nome, double preco, int duracao, String genero,
			String classificacao, int anoLancamento) {
		Item item = new BluRayFilme(dono, nome, preco, duracao, classificacao, genero, anoLancamento);
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
	 * @return retorna o objeto BluRayShow que foi cadastrado.
	 */
	public Item cadastrarBluRayShow(String dono, String nome, double preco, int duracao, int numeroFaixas,
			String artista, String classificacao) {
		Item item = new BluRayShow(dono, nome, preco, duracao, classificacao, numeroFaixas, artista);
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
	 * @return retorna o objeto BluRaySerie que foi cadastrado.
	 */
	public Item cadastrarBluRaySerie(String dono, String nome, double preco, String descricao, int duracao,
			String classificacao, String genero, int numeroDaTemporada) {
		Item item = new BluRaySerie(dono, nome, preco, duracao, classificacao, genero, numeroDaTemporada);
		itens.add(item);
		return item;
	}

	

	/**
	 * lista o historicos de emprestimos envolvidos com este item.
	 * 
	 * @return uma lista dos emprestimos associados a este item.
	 */
	public String historicoEmprestimosItem(String nomeItem) {
		return getItem(nomeItem).emprestimos();

	}

	/**
	 * Ordena a lista de objetos Item e concatena os componentes em uma so
	 * String.
	 * 
	 * @return Representacao em String de todos os objetos Item cadastrados, em
	 *         ordem alfanumerica.
	 */
	public String listarItensOrdenadosPorNome() {
		Collections.sort(itens, new ItemNomeComparator());
		String mensagem = "";
		for (int i = 0; i < itens.size(); i++) {
			mensagem += itens.get(i).toString() + "|";
		}
		return mensagem;
	}

	/**
	 * Ordena a lista de objetos Item e concatena os componentes em uma so
	 * String.
	 * 
	 * @return Representacao em String de todos os objetos Item cadastrados,
	 *         ordenados pelo preco.
	 */
	public String listarItensOrdenadosPorValor() {
		itens.sort(new ItemPrecoComparator());
		String mensagem = "";
		for (int i = 0; i < itens.size(); i++) {
			mensagem += itens.get(i).toString() + "|";
		}
		return mensagem;
	}

	/**
	 * lista os itens não emprestados no sistema
	 * 
	 * @return lista os objetos não emprestados no sistema
	 */
	public String listarItensNaoEmprestados() {
		Collections.sort(itens, new ItemNomeComparator());
		String saida = "";
		for (int i = 0; i < itens.size(); i++) {
			if (itens.get(i).getEmprestado().equals(Emprestado.NAO_EMPRESTADO)) {
				saida += itens.get(i).toString() + "|";
			}
		}
		return saida;
	}

	/**
	 * lista os itens emprestados no sistema
	 * 
	 * @return lista os objetos emprestados no sistema
	 */
	public String listarItensEmprestados() {
		ArrayList<Item> itensEmprestados = retornarArray();
		Collections.sort(itensEmprestados, new ItemNomeDonoComparator());
		String saida = "";

		for (int i = 0; i < itensEmprestados.size(); i++) {
			if (itensEmprestados.get(i).getEmprestado().equals(Emprestado.EMPRESTADO)) {
				saida += "Dono do item: " + itensEmprestados.get(i).getDonoItem() + ", Nome do item emprestado: "
						+ itensEmprestados.get(i).getNome() + "|";
			}
		}
		return saida;
	}

	public ArrayList<Item> ordenarPorEmprestimos() {

		ArrayList<Item> itensTop10 = new ArrayList<>();
		Collections.sort(itens, new ItemNumeroEmprestimosComparator());

		for (int i = 0; i < itens.size(); i++) {
			if (itens.get(i).numeroEmprestimos() > 0) {
				itensTop10.add(itens.get(i));
			}
		}

		return itensTop10;
	}

	/**
	 * remove um item do sistema e do usuario
	 * 
	 * @param nomeItem
	 *            nome do item a ser removido
	 */
	public void removeItem(String nomeItem) {
		Item item = getItem(nomeItem);
		itens.remove(item);
	}

	private ArrayList<Item> retornarArray() {
		ArrayList<Item> itensEmprestados = new ArrayList<>();
		for (int i = itens.size() - 1; i >= 1; i--) {
			if (itens.get(i).getEmprestado().equals(Emprestado.EMPRESTADO)) {
				itensEmprestados.add(itens.get(i));
			}
		}
		return itensEmprestados;

	}

	/**
	 * lista os itens mais emprestados no sistema
	 * 
	 * @return lista em ordem decrescente o item que foi mais emprestado ao que
	 *         foi menos intervalo [0,9].
	 */
	public String top10() {
		String saida = "";
		ArrayList<Item> itens = ordenarPorEmprestimos();
		for (int i = 0; i < itens.size(); i++) {
			Item item = itens.get(i);
			saida += (i + 1) + ") " + item.numeroEmprestimos() + " emprestimos - " + item.toString() + "|";
		}
		return saida;

	}

	/**
	 * pega o item
	 * 
	 * @param nomeItem
	 *            nome do item
	 * @throws exceção
	 *             anuciando que o item não esta cadastrado
	 * @return o objeto do item cadastrado
	 */
	public Item getItem(String nomeItem) {
		for (int i = 0; i < itens.size(); i++) {
			Item item = itens.get(i);
			if (item.getNome().equals(nomeItem)) {
				return itens.get(i);
			}

		}
		throw new NullPointerException("Item nao encontrado");
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	

}