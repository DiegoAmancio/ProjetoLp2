package pacotePrincipal;

import java.util.ArrayList;

/**
 * representação de um controlador de usuarios
 * 
 * 
 * Laboratorio de Programacao 2 - projeto
 * 
 * @author Diego Amancio - 116210716
 */
public class UsuarioController {
	private ArrayList<Usuario> usuarios;

	/**
	 * constroi um controlador de usuarios
	 */
	public UsuarioController() {
		this.usuarios = new ArrayList<Usuario>();
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

		if (getUsuario(nome, telefone) != null) {
			usuarios.add(usuario);
		} else {
			throw new IllegalArgumentException("Usuario ja cadastrado");
		}

	}

	/**
	 * verifica se o usuario ja esta cadastrado
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @return retorna usuario caso esteja cadastrado
	 */
	public Usuario getUsuario(String nome, String telefone) {
		Usuario usuario = new Usuario(nome, telefone, "");
		Usuario acheiUsuario = null;
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.equals(usuario)) {
				acheiUsuario = usuarios.get(i);
				break;
			}
		}
		return acheiUsuario;
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
		Usuario usuario = getUsuario(nome, telefone);
		if (usuario != null) {
			usuarios.remove(usuario);
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
		Usuario usuario = getUsuario(nome, telefone);
		if (usuario != null) {
			if (atributo.equals("Nome")) {
				usuario.setNome(valor);
			} else if (atributo.equals("Telefone")) {
				usuario.setTelefone(valor);
			} else if (atributo.equals("Email")) {
				usuario.setEmail(valor);
			} else {
				throw new IllegalArgumentException("atributo invalido");
			}
		} else {
			throw new IllegalArgumentException("Usuario invalido");

		}
	}	
	
}
