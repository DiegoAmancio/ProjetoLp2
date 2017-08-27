package usuario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import emprestismo.Emprestimo;
import enums.CartaoFidelidade;
import enums.Emprestado;
import item.Item;
import item.ItemController;
import item.ReputacaoComparatorInverso;

/**
 * representacao de um controlador de usuarios
 * 
 * 
 * Laboratorio de Programacao 2 - projeto
 * 
 * @author Diego Amancio - 116210716
 */
public class UsuarioController {
	private Map<String, Usuario> usuarios;
	private ItemController itemController;

	/**
	 * constroi um controlador de usuarios
	 */
	public UsuarioController() {
		this.usuarios = new HashMap<String, Usuario>();
		this.itemController = new ItemController();
	}

	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		String identificador = getToken(nome, telefone);
		if (usuarios.get(identificador) != null) {
			Item item = itemController.getItem(nomeItem);
			itemController.adicionarPecaPerdida(item, nomePeca);
		} else {
			throw new NullPointerException("Usuario invalido");
		}
	}

	/**
	 * procura saber se o usuario esta cadastrado no sistema
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @return o usuario
	 */
	private Usuario achandoUsuario(String nome, String telefone) {
		String identificador = getToken(nome, telefone);
		existeUsuario(identificador);
		return usuarios.get(identificador);
	}

	/**
	 * modifica atributo do usuario ,ou seja,sua informacoes.
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param atributo
	 *            atributo do usuario a ser modificado
	 * @param valor
	 *            nova informacao para o atributo do usuario
	 */
	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {

		Usuario usuario = achandoUsuario(nome, telefone);

		switch (atributo.trim().toUpperCase()) {

		case "NOME":
			cadastrarUsuario(valor, telefone, usuario.getEmail());
			removerUsuario(nome, telefone);
			break;
		case "TELEFONE":
			cadastrarUsuario(nome, valor, usuario.getEmail());
			removerUsuario(nome, telefone);
			break;

		case "EMAIL":
			usuario.setEmail(valor);
			break;

		default:
			throw new IllegalArgumentException("Atributo invalido");

		}

	}

	/**
	 * atualiza informações de um item
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param nomeItem
	 *            nome do item
	 * @param atributo
	 *            atributo do item
	 * @param valor
	 *            nova informação
	 */
	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		Usuario usuario = achandoUsuario(nome, telefone);
		usuario.atualizarItem(nomeItem, atributo, valor);

	}

	/**
	 * 
	 * cadastra um jogo Eletronico
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param nomeItem
	 *            nome do item
	 * @param preco
	 *            preço do item
	 * @param plataforma
	 *            plataforma do item
	 */
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		Usuario usuario = achandoUsuario(nome, telefone);
		Item eletronico = itemController.cadastrarEletronico(nome, nomeItem, preco, plataforma);
		usuario.adicionaItem(nomeItem, eletronico);

	}

	/**
	 * cadastra um usuario
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param email
	 *            email do usuario
	 */
	public void cadastrarUsuario(String nome, String telefone, String email) {
		String identificador = getToken(nome, telefone);
		Usuario usuario = new Usuario(nome, telefone, email);

		if (!(usuarios.containsKey(identificador))) {
			usuarios.put(identificador, usuario);
		} else {
			throw new IllegalArgumentException("Usuario ja cadastrado");
		}

	}

	/**
	 * Cadastra jogos de tabuleiro
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param nomeItem
	 *            nome do item
	 * @param preco
	 *            preço do item
	 */

	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		Usuario usuario = achandoUsuario(nome, telefone);
		Item jogoTabuleiro = itemController.cadastrarJogoTabuleiro(nome, nomeItem, preco);
		usuario.adicionaItem(nomeItem, jogoTabuleiro);

	}

	/**
	 * cadastra um filme
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param nomeItem
	 *            nome do item
	 * @param preco
	 *            preço do item
	 * @param duracao
	 *            duração do item
	 * @param classificacao
	 *            classificação do item
	 * @param genero
	 *            genero do item
	 * @param anoLancamento
	 *            ano de lançamento do item
	 */
	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) {
		Usuario usuario = achandoUsuario(nome, telefone);
		Item BluRayFilme = itemController.cadastrarBluRayFilme(nome, nomeItem, preco, duracao, genero, classificacao,
				anoLancamento);
		usuario.adicionaItem(nomeItem, BluRayFilme);

	}

	/**
	 * cadastra um show
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param nomeItem
	 *            nome do item
	 * @param preco
	 *            preço do item
	 * @param duracao
	 *            duração do item
	 * @param classificacao
	 *            classificação do item
	 * @param artista
	 *            nome do artista
	 * @param numeroFaixas
	 *            numero de faixas do show
	 */
	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao,
			int numeroFaixas, String artista, String classificacao) {
		Usuario usuario = achandoUsuario(nome, telefone);
		Item BluRayFilme = itemController.cadastrarBluRayShow(nome, nomeItem, preco, duracao, numeroFaixas, artista,
				classificacao);
		usuario.adicionaItem(nomeItem, BluRayFilme);

	}

	/**
	 * cadastra uma serie
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param nomeItem
	 *            nome do item
	 * @param preco
	 *            preço do item
	 * @param descricao
	 *            descrição do item
	 * @param duracao
	 *            duração do item
	 * @param classificacao
	 *            classificação do item
	 * @param genero
	 *            genero do item
	 * @param numeroDaTemporada
	 *            numero da temporada da serie
	 */
	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int numeroDaTemporada) {
		Usuario usuario = achandoUsuario(nome, telefone);
		Item BluRayFilme = itemController.cadastrarBluRaySerie(nome, nomeItem, preco, descricao, duracao, classificacao,
				genero, numeroDaTemporada);
		usuario.adicionaItem(nomeItem, BluRayFilme);

	}

	/**
	 * Devolve item e muda o status do item para NAO EMPRESTADO.
	 * 
	 * @param nomeDono
	 *            nome do dono do item
	 * @param telefoneDono
	 *            telefone do dono do item
	 * @param nomeRequerente
	 *            nome do usuario que esta devolvendo o item emprestado
	 * @param telefoneRequerente
	 *            telefone do usuario que esta devolvendo o item
	 * @param nomeItem
	 *            nome do item que foi emprestado
	 * @param dataEmprestimo
	 *            data em que o item foi emprestado.
	 * @param dataDevolucao
	 *            data de entrega do item
	 */
	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) {
		Usuario dono = achandoUsuario(nomeDono, telefoneDono);
		Usuario requerente = achandoUsuario(nomeRequerente, telefoneRequerente);

		Item itemDono = dono.getItem(nomeItem);
		Emprestimo ee = dono.existeEmprestimo(nomeItem, nomeRequerente);
		itemDono.setEmprestado(Emprestado.NAO_EMPRESTADO);

		dono.fechandoEmprestimo(dataDevolucao, ee);
		Emprestimo emprestimo = dono.existeEmprestimo(nomeItem, nomeRequerente);

		if (emprestimo.getAtrasou()) {
			requerente.abaixaReputacao(itemDono.getPreco(), emprestimo.getDevolveuDias());
		} else {
			requerente.sobeReputacao(itemDono.getPreco(), "");
		}
		if (emprestimo != null) {
			itemController.adicionarHistorico(emprestimo.getItemEmprestado(), emprestimo);
		}
	}

	public int determinarVencimento(CartaoFidelidade cartao) {

		if (cartao.equals(CartaoFidelidade.BOM_AMIGO)) {
			return 14;
		} else if (cartao.equals(CartaoFidelidade.NOOB)) {
			return 7;
		} else if (cartao.equals(CartaoFidelidade.FREE_RIDER)) {
			return 5;
		} else {
			throw new NullPointerException("Usuario nao pode pegar nenhum item emprestado");
		}
	}

	/**
	 * verifica se existe o usuario cadastrado no sistema
	 * 
	 * @param tokenUsuario
	 *            cheve do mapa de usuarios
	 * @throws exceção
	 *             dizendo que não ha esse usuario cadastrado
	 */
	public void existeUsuario(String tokenUsuario) {
		if (!usuarios.containsKey(tokenUsuario)) {
			throw new NullPointerException("Usuario invalido");
		}
	}

	/**
	 * pega a informação requisitada do item
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param atributo
	 *            atributo do item a ser visto
	 * @return a informação do usuario que no qual foi requisitada.
	 */
	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		Usuario usuario = achandoUsuario(nome, telefone);
		return usuario.getInfoItem(nomeItem, atributo);

	}

	/**
	 * pega a informação requisitada do usuario
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param atributo
	 *            atributo do usuario a ser visto
	 * @return a informação do usuario que no qual foi requisitada.
	 */
	public String getInfoUsuario(String nome, String telefone, String atributo) {
		Usuario usuario = achandoUsuario(nome, telefone);

		switch (atributo.trim().toUpperCase()) {
		case "CARTAO":
			return usuario.getCartaoTxt();
		case "REPUTACAO":
			return Double.toString(usuario.getReputacao());
		case "NOME":
			return usuario.getNome();
		case "TELEFONE":
			return usuario.getTelefone();

		case "EMAIL":
			return usuario.getEmail();

		default:
			throw new IllegalArgumentException("Atributo invalido");

		}

	}

	/**
	 * lista oos caloteiros.
	 * 
	 * @return uma lista cntendo os inadiplentes do sistema
	 */
	public String listarCaloteiros() {
		ArrayList<Usuario> top10 = new ArrayList<>();
		for (Entry<String, Usuario> usuario : usuarios.entrySet()) {
			if (usuario.getValue().getCartao().equals(CartaoFidelidade.CALOTEIRO)) {
				top10.add(usuario.getValue());
			}
		}
		String saida = "Lista de usuarios com reputacao negativa: ";
		for (int i = 0; i < top10.size(); i++) {
			if (i == 10) {
				break;
			}
			Usuario usuario = top10.get(i);
			if (usuario.getReputacao() >= 0) {
				break;
			}
			saida += usuario.toString() + "|";
		}

		return saida;
	}

	/**
	 * lista o top 10 dos usuarios com as piores reputações.
	 * 
	 * @return uma lista ordenada do usuario que tem a pior reputação ate o que
	 *         tem a maior reputação em um intervalo de 0 a 9 fechado.
	 */
	public String listarTop10PioresUsuarios() {
		ArrayList<Usuario> top10 = new ArrayList<>();
		for (Entry<String, Usuario> usuario : usuarios.entrySet()) {
			top10.add(usuario.getValue());
		}
		Collections.sort(top10, new ReputacaoComparatorInverso());
		String saida = "";
		for (int i = 0; i < top10.size(); i++) {
			if (i == 10) {
				break;
			}
			Usuario usuario = top10.get(i);
			saida += (i + 1) + ": " + usuario.getNome() + " - Reputacao: "
					+ String.format("%.2f", usuario.getReputacao()) + "|";
		}
		return saida;
	}

	/**
	 * lista os itens ordenados pelo nome
	 * 
	 * @return retorna uma lista de itens ordenados eusando como referencial o
	 *         nome do item;
	 */
	public String listarItensOrdenadosPorNome() {
		return itemController.listarItensOrdenadosPorNome();
	}

	/**
	 * lista os itens ordenados por valor
	 * 
	 * @return retorna uma lista de itens ordenados usando como referencial o
	 *         valor do item;
	 */
	public String listarItensOrdenadosPorValor() {
		return itemController.listarItensOrdenadosPorValor();
	}

	/**
	 * lista os itens que o usuario emprestou
	 * 
	 * @return a informação sobre os itens que o usuario em questao emprestou;
	 */
	public String listarEmprestimosUsuarioEmprestando(String nome, String telefone) {

		String identificadorDono = getToken(nome, telefone);
		existeUsuario(identificadorDono);
		return usuarios.get(identificadorDono).listarItensEmprestados();
	}

	/**
	 * lista os itens que o usuario pegou emprestado
	 * 
	 * @return a informação sobre os itens que o usuario em questao pegou
	 *         emprestado;
	 */
	public String listarEmprestimosUsuarioPegandoEmprestado(String nome, String telefone) {
		Usuario usuario = achandoUsuario(nome, telefone);
		return usuario.listarItensPegouEmprestado();
	}

	/**
	 * lista o historicos de emprestimos envolvidos com este item.
	 * 
	 * @return uma lista dos emprestimos associados a este item.
	 */
	public String listarEmprestimosItem(String nomeItem) {
		return itemController.historicoEmprestimosItem(nomeItem);
	}

	/**
	 * lista os itens não emprestados no sistema
	 * 
	 * @return lista os objetos não emprestados no sistema
	 */
	public String listarItensNaoEmprestados() {
		return itemController.listarItensNaoEmprestados();
	}

	/**
	 * lista os itens emprestados no sistema
	 * 
	 * @return lista os objetos emprestados no sistema
	 */

	public String listarItensEmprestados() {
		return itemController.listarItensEmprestados();
	}

	/**
	 * lista os itens mais emprestados no sistema
	 * 
	 * @return lista em ordem decrescente o item que foi mais emprestado ao que
	 *         foi menos intervalo [0,9].
	 */

	public String listarTop10Itens() {

		return itemController.top10();
	}

	/**
	 * pesquisa detalhes especificos de um item;
	 * 
	 * @param nome
	 *            nome do usuario dono do item
	 * @param telefone
	 *            telefone do usuario dono do item
	 * @param nomeItem
	 *            nome do item a ser pesquisado
	 * @return retorna informações sobre o item procurado
	 */
	public String pesquisarDetalhesItem(String nome, String telefone, String nomeItem) {
		Usuario usuario = achandoUsuario(nome, telefone);
		return usuario.getDetalhes(nomeItem);

	}

	/**
	 * serve pra gerar uma String que e equivalente a uma chave no mapa de
	 * usuarios
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @return retorna a chave de identificação do usuario
	 */
	public String getToken(String nome, String telefone) {
		return nome + telefone;
	}

	/**
	 * Registra emprestimos, passos: Primeiro, checa se o usuario tem
	 * determinado item para emprestar, se sim, verifica o status do item (se
	 * esta emprestado ou nao), se nao estiver emprestado, realiza emprestimo.
	 * 
	 * @param nomeDono
	 *            nome do dono do item a ser emprestado
	 * @param telefoneDono
	 *            telefone do dono do item a ser emprestado
	 * @param nomeRequerente
	 *            nome do usuario que esta requisitando o item
	 * @param telefoneRequerente
	 *            telefone do usuario que esta requisitando o item
	 * @param itemEmprestado
	 *            nome do item a ser emprestado
	 * @param dataEmprestimo
	 *            inicio do emprestimo
	 * @param periodo
	 *            periodo limite que o usuario pode ficar com o item
	 */
	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String itemEmprestado, String dataEmprestimo, int periodo) {
		Usuario dono = achandoUsuario(nomeDono, telefoneDono);
		Usuario requerente = achandoUsuario(nomeRequerente, telefoneRequerente);
		dono.existeItem(itemEmprestado);

		if ((dono.getItem(itemEmprestado).getEmprestado() == Emprestado.NAO_EMPRESTADO)) {
			int vencimento = determinarVencimento(requerente.getCartao());
			if (vencimento < periodo) {
				throw new IllegalArgumentException("Usuario impossiblitado de pegar emprestado por esse periodo");
			}
			Emprestimo novoEmprestimo = new Emprestimo(nomeDono, nomeRequerente, itemEmprestado, dataEmprestimo,
					periodo, vencimento);
			dono.empresta(novoEmprestimo, itemEmprestado);
			requerente.pegaEmprestado(novoEmprestimo, itemEmprestado);
			itemController.adicionarHistorico(itemEmprestado, novoEmprestimo);
		} else {
			throw new IllegalArgumentException("Item emprestado no momento");
		}
	}

	/**
	 * remove um usuario cadastrado
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 */
	public void removerUsuario(String nome, String telefone) {
		String identificador = getToken(nome, telefone);
		if (usuarios.containsKey(identificador)) {
			usuarios.remove(identificador);
		} else {
			throw new IllegalArgumentException("Usuario invalido");
		}
	}

	/**
	 * remove um item do sistema e do usuario
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param nomeItem
	 *            nome od item a ser removido
	 */
	public void removerItem(String nome, String telefone, String nomeItem) {
		Usuario usuario = achandoUsuario(nome, telefone);
		usuario.removerItem(nomeItem);
		itemController.removeItem(nomeItem);
	}

	/**
	 * lista o top 10 dos usuarios com melhores reputações.
	 * 
	 * @return uma lista ordenada do usuario que tem melhor reputação ate o que
	 *         tem a menor reputação em um intervalo de 0 a 9 fechado.
	 */
	public String top10MelhoresUsuarios() {

		ArrayList<Usuario> top10 = new ArrayList<>();
		for (Entry<String, Usuario> usuario : usuarios.entrySet()) {
			top10.add(usuario.getValue());
		}
		Collections.sort(top10, new UsuarioReputacaoComparator());
		String saida = "";

		for (int i = 0; i < top10.size(); i++) {
			if (i == 10) {
				break;
			}
			Usuario usuario = top10.get(i);

			saida += (i + 1) + ": " + usuario.getNome() + " - Reputacao: "
					+ String.format("%.2f", usuario.getReputacao()) + "|";
		}
		return saida;
	}

}