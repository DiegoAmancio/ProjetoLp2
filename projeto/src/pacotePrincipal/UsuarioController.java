package pacotePrincipal;

import java.util.HashMap;
import java.util.Map;

/**
 * representação de um controlador de usuarios
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
		itemController = new ItemController();
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
		String identificacao = nome + " " + telefone;
		Usuario usuario = new Usuario(nome, telefone, email);

		if (!(usuarios.containsKey(identificacao))) {
			usuarios.put(identificacao, usuario);
		} else {
			throw new IllegalArgumentException("Usuario ja cadastrado");
		}

	}
	
	public Usuario getUsuario(String nome,String telefone) {
		String identificacao = nome + " " + telefone;
		if (usuarios.containsKey(identificacao)) {
			return usuarios.get(identificacao);
		} else {
			throw new NullPointerException("Usuario invalido");
		}
	}

	public String getInfoUsuario(String nome, String telefone, String atributo) {
		Usuario usuario = getUsuario(nome, telefone);
			switch (atributo.trim().toUpperCase()) {

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
	 * remove um usuario cadastrado
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 */
	public void removerUsuario(String nome, String telefone) {
		String identificacao = nome + " " + telefone;
		if (usuarios.containsKey(identificacao)) {
			usuarios.remove(identificacao);
		} else {
			throw new IllegalArgumentException("Usuario invalido");
		}
	}

	/**
	 * modifica atributo do usuario ,ou seja,sua informações.
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param atributo
	 *            atributo do usuario a ser modificado
	 * @param valor
	 *            nova informaçao para o atributo do usuario
	 */
	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {
		
		String identificacao = nome + " " + telefone;
		
		if (usuarios.containsKey(identificacao)) {
			Usuario usuario = usuarios.get(identificacao);
			
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
	
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		Usuario usuario = getUsuario(nome, telefone);
		Item item = itemController.cadastrarEletronico(nomeItem, preco, plataforma);
		usuario.adicionaItem(nomeItem, item);
	}
	
	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		Usuario usuario = getUsuario(nome, telefone);
		Item item = itemController.cadastrarJogoTabuleiro(nomeItem, preco);
		usuario.adicionaItem(nomeItem, item);
	}
	
	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		Usuario usuario = getUsuario(nome, telefone);
		Item item = usuario.getItem(nomeItem);
		itemController.adicionarPecaPerdida(item, nomePeca);
	}
	
	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao, String genero, String classificacao, int anoLancamento) {
		Usuario usuario = getUsuario(nome, telefone);
		Item item = itemController.cadastrarBluRayFilme(nomeItem, preco, duracao, genero, classificacao, anoLancamento);
		usuario.adicionaItem(nomeItem, item);
	}
	
	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao, int numeroFaixas, String artista, String classificacao) {
		Usuario usuario = getUsuario(nome, telefone);
		Item item = itemController.cadastrarBluRayShow(nomeItem, preco, duracao, numeroFaixas, artista, classificacao);
		usuario.adicionaItem(nomeItem, item);
	}
	
	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao, int duracao, String classificacao, String genero, int temporada) {
		Usuario usuario = getUsuario(nome, telefone);
		Item item = itemController.cadastrarBluRaySerie(nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
		usuario.adicionaItem(nomeItem, item);
	}
	
	public void adicionarBluRay(String nome, String telefone, String nomeItem, int duracao) {
		Usuario usuario = getUsuario(nome, telefone);
		Item item = usuario.getItem(nomeItem);
		itemController.adicionarBluRay(item, duracao);
	}
	
	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		Usuario usuario = getUsuario(nome, telefone);
		Item item = usuario.getItem(nomeItem);
		return item.getInfo(atributo);
	}
	
	public String pesquisarDetalhesItem(String nome, String telefone, String nomeItem) {
		Usuario usuario = getUsuario(nome, telefone);
		Item item = usuario.getItem(nomeItem);
		return item.toString();
	}
	
	public String listarItensOrdenadosPorNome() {
		return itemController.listarItensOrdenadosPorNome();
	}
	
	public String listarItensOrdenadosPorValor() {
		return itemController.listarItensOrdenadosPorValor();
	}

}
