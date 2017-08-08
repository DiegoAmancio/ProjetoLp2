package pacotePrincipal;

import java.util.ArrayList;
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
		String identificacao = nome + telefone;
		Usuario usuario = new Usuario(nome, telefone, email);

		if (!(usuarios.containsKey(identificacao))) {
			usuarios.put(identificacao, usuario);
		} else {
			throw new IllegalArgumentException("Usuario ja cadastrado");
		}

	}

	public String getInfoUsuario(String nome, String telefone, String atributo) {
		String identificacao = nome + telefone;
		if (usuarios.containsKey(identificacao)) {
			Usuario usuario = usuarios.get(identificacao);

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
		
		String identificacao = nome + telefone;
		
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

}
