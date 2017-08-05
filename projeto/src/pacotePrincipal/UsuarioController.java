package pacotePrincipal;

import java.util.HashMap;
import java.util.Map;

/**
 * representação de um controlador de usuarios
 * 
 * 
 * Laboratório de Programação 2 - projeto
 * 
 * @author Diego Amancio - 116210716
 */
public class UsuarioController {
	private Map<String, Usuario> usuarios;

	/**
	 * constroi um controlador de usuarios
	 */
	public UsuarioController() {
		this.usuarios = new HashMap<String, Usuario>();
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

		Usuario usuario = new Usuario(nome, telefone, email);

		String identificacao = nome + telefone;

		if (usuarios.containsKey(identificacao)) {
			throw new IllegalArgumentException("Usuario ja cadastrado");
		} else {
			usuarios.put(identificacao, usuario);
		}

	}

	/**
	 * metodo que pega a informação do usuario e a exibe no console caso o
	 * usuario esteja cadastrado
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param atributo
	 *            atributo do usuario que sera mudado
	 * @throws @return
	 *             atributo do usuario
	 */
	public String getInfoUsuario(String nome, String telefone, String atributo) {
		if (usuarios.containsKey(nome + telefone)) {
			String identificacao = nome + telefone;
			switch (atributo) {
			case "Nome":
				return usuarios.get(identificacao).getNome();
			case "Telefone":
				return usuarios.get(identificacao).getTelefone();
			case "Email":
				return usuarios.get(identificacao).getEmail();
			default:
				throw new IllegalArgumentException("Atributo invalido");
			}
		} else {
			throw new NullPointerException("Usuario invalido");
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
		String identificacao = nome + telefone;

		if (usuarios.containsKey(identificacao)) {

			usuarios.remove(identificacao);
		} else {
			throw new NullPointerException("Usuario invalido");

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
		String identificacao = nome + telefone;

		if (usuarios.containsKey(identificacao)) {

			Usuario antigoUsuario = usuarios.get(identificacao);
			Usuario novoUsuario = new Usuario(nome, telefone, antigoUsuario.getEmail());

			if (atributo.equals("Nome")) {

				novoUsuario.setNome(valor);

			} else if (atributo.equals("Telefone")) {

				novoUsuario.setTelefone(valor);

			} else if (atributo.equals("Email")) {

				novoUsuario.setEmail(valor);

			} else {

				throw new IllegalArgumentException("atributo invalido");
			}

			removerUsuario(nome, telefone);
			cadastrarUsuario(novoUsuario.getNome(), novoUsuario.getTelefone(), novoUsuario.getEmail());
		} else {
			throw new NullPointerException("Usuario invalido");

		}
	}
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, int preco, String plataforma) {
		E
	}
}
