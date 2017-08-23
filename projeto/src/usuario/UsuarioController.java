package usuario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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
	private List<Usuario> usuariosReputacaoNegativa;
	private ItemController itemController;

	/**
	 * constroi um controlador de usuarios
	 */
	public UsuarioController() {
		this.usuarios = new HashMap<String, Usuario>();
		this.itemController = new ItemController();
		this.usuariosReputacaoNegativa = new ArrayList<Usuario>();
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

		String identificador = getToken(nome, telefone);

		if (usuarios.containsKey(identificador)) {
			Usuario usuario = usuarios.get(identificador);

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
		} else {
			throw new IllegalArgumentException("Usuario invalido");

		}
	}

	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		String identificador = getToken(nome, telefone);
		if (usuarios.get(identificador) != null) {
			usuarios.get(identificador).atualizarItem(nomeItem, atributo, valor);
		} else {
			throw new NullPointerException("Usuario invalido");
		}
	}

	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		String identificador = getToken(nome, telefone);
		if (usuarios.get(identificador) != null) {
			Item eletronico = itemController.cadastrarEletronico(nome, nomeItem, preco, plataforma);
			usuarios.get(identificador).adicionaItem(nomeItem, eletronico);
		} else {
			throw new NullPointerException("Usuario invalido no eletronico");
		}

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
	 * @param telefone
	 * @param nomeItem
	 * @param preco
	 * @param plataforma
	 */

	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		String identificador = getToken(nome, telefone);
		if (usuarios.get(identificador) != null) {
			Item jogoTabuleiro = itemController.cadastrarJogoTabuleiro(nome, nomeItem, preco);
			usuarios.get(identificador).adicionaItem(nomeItem, jogoTabuleiro);
		} else {
			throw new NullPointerException("Usuario invalido");
		}
	}

	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int anoLancamento) {
		String identificador = getToken(nome, telefone);
		if (usuarios.get(identificador) != null) {
			Item BluRayFilme = itemController.cadastrarBluRayFilme(nome, nomeItem, preco, duracao, genero,
					classificacao, anoLancamento);
			usuarios.get(identificador).adicionaItem(nomeItem, BluRayFilme);
		} else {
			throw new NullPointerException("Usuario invalido");
		}
	}

	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao,
			int numeroFaixas, String artista, String classificacao) {
		String identificador = getToken(nome, telefone);
		if (usuarios.get(identificador) != null) {
			Item BluRayFilme = itemController.cadastrarBluRayShow(nome, nomeItem, preco, duracao, numeroFaixas, artista,
					classificacao);
			usuarios.get(identificador).adicionaItem(nomeItem, BluRayFilme);
		} else {
			throw new NullPointerException("Usuario invalido");
		}
	}

	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int numeroDaTemporada) {
		String identificador = getToken(nome, telefone);
		if (usuarios.get(identificador) != null) {
			Item BluRayFilme = itemController.cadastrarBluRaySerie(nome, nomeItem, preco, descricao, duracao,
					classificacao, genero, numeroDaTemporada);
			usuarios.get(identificador).adicionaItem(nomeItem, BluRayFilme);
		} else {
			throw new NullPointerException("Usuario invalido");
		}
	}

	/**
	 * Devolve item e muda o status do item para NAO EMPRESTADO.
	 * 
	 * @param nomeDono
	 * @param telefoneDono
	 * @param nomeRequerente
	 * @param telefoneRequerente
	 * @param nomeItem
	 * @param dataEmprestimo
	 * @param dataDevolucao
	 * @return
	 */
	public String devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) {
		String identificadorDono = getToken(nomeDono, telefoneDono);
		String requerente = getToken(nomeRequerente, telefoneRequerente);

		Usuario dono = usuarios.get(identificadorDono);
		Usuario caraPedindo = usuarios.get(requerente);
		Item itemDono = dono.getItem(nomeItem);
		Emprestimo ee = dono.existeEmprestimo(nomeItem, nomeRequerente);
		itemDono.setEmprestado(Emprestado.NAO_EMPRESTADO);

		dono.fechandoEmprestimo(dataDevolucao, ee);
		Emprestimo emprestimo = dono.existeEmprestimo(nomeItem, nomeRequerente);

		if (emprestimo.getAtrasou()) {
			caraPedindo.abaixaReputacao(itemDono.getPreco(), emprestimo.getDevolveuDias());
		} else {
			caraPedindo.sobeReputacao(itemDono.getPreco(), "");
		}
		if (emprestimo != null) {
			itemController.adicionarHistorico(emprestimo.getItemEmprestado(), emprestimo);
		}
		return "Item devolvido com sucesso";
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

	public void existeUsuario(String tokenUsuario) {
		if (!usuarios.containsKey(tokenUsuario)) {
			throw new NullPointerException("Usuario invalido");
		}
	}

	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		String identificador = getToken(nome, telefone);
		Usuario usuario = usuarios.get(identificador);
		return usuario.getInfoItem(nomeItem, atributo);

	}

	public String getInfoUsuario(String nome, String telefone, String atributo) {
		String identificador = getToken(nome, telefone);
		if (usuarios.containsKey(identificador)) {
			Usuario usuario = usuarios.get(identificador);

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
		} else {
			throw new IllegalArgumentException("Usuario invalido");
		}

	}

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

	public String listarItensOrdenadosPorNome() {
		return itemController.listarItensOrdenadosPorNome();
	}

	public String listarItensOrdenadosPorValor() {
		return itemController.listarItensOrdenadosPorValor();
	}

	public String listarEmprestimosUsuarioEmprestando(String nome, String telefone) {

		String identificadorDono = getToken(nome, telefone);
		existeUsuario(identificadorDono);
		return usuarios.get(identificadorDono).listarItensEmprestados();
	}

	public String listarEmprestimosUsuarioPegandoEmprestado(String nome, String telefone) {
		String identificadorDono = getToken(nome, telefone);
		existeUsuario(identificadorDono);
		return usuarios.get(identificadorDono).listarItensPegouEmprestado();
	}

	public String listarEmprestimosItem(String nomeItem) {
		return itemController.historicoEmprestimosItem(nomeItem);
	}

	public String listarItensNaoEmprestados() {
		return itemController.listarItensNaoEmprestados();
	}

	public String listarItensEmprestados() {
		return itemController.listarItensEmprestados();
	}

	public String listarTop10Itens() {

		return itemController.top10();
	}

	public String pesquisarDetalhesItem(String nome, String telefone, String nomeItem) {
		String identificador = getToken(nome, telefone);

		if (usuarios.containsKey(identificador)) {
			return usuarios.get(identificador).getDetalhes(nomeItem);
		}
		throw new NullPointerException("Usuario invalido");

	}

	/**
	 * Registra emprestimos, passos: Primeiro, checa se o usuario tem determinado
	 * item para emprestar, se sim, verifica o status do item (se esta emprestado ou
	 * nao), se nao estiver emprestado, realiza emprestimo.
	 * 
	 * @param nomeDono
	 * @param telefoneDono
	 * @param nomeRequerente
	 * @param telefoneRequerente
	 * @param itemEmprestado
	 * @param dataEmprestimo
	 * @param periodo
	 * @return
	 */
	public String registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String itemEmprestado, String dataEmprestimo, int periodo) {

		String identificadorDono = getToken(nomeDono, telefoneDono);
		String identificadorRequerente = getToken(nomeRequerente, telefoneRequerente);
		existeUsuario(identificadorDono);
		existeUsuario(identificadorRequerente);
		Usuario dono = usuarios.get(identificadorDono);
		Usuario requerente = usuarios.get(identificadorRequerente);
		usuarios.get(identificadorDono).existeItem(itemEmprestado);

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
			return "Item emprestado com sucesso";
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

	public void removerItem(String nome, String telefone, String nomeItem) {
		String identificador = getToken(nome, telefone);
		if (usuarios.containsKey(identificador)) {
			usuarios.get(identificador).removerItem(nomeItem);
			itemController.removeItem(nomeItem);
		} else {
			throw new IllegalArgumentException("Usuario invalido");
		}
	}

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

	public String getToken(String nome, String telefone) {
		return nome + telefone;
	}

}