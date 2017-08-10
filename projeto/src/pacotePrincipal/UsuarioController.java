package pacotePrincipal;

import java.util.HashMap;
import java.util.Map;

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

	/**
	 * constroi um controlador de usuarios
	 */
	public UsuarioController() {
		this.usuarios = new HashMap<String, Usuario>();
	}

	public String getToken(String nome, String telefone){
		return nome + telefone;
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

	public String getInfoUsuario(String nome, String telefone, String atributo) {
		String identificador = getToken(nome, telefone);
		if (usuarios.containsKey(identificador)) {
			Usuario usuario = usuarios.get(identificador);

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
	
	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo){
		String identificador = getToken(nome, telefone);
		Usuario usuario = usuarios.get(identificador);
		return usuario.getInfoItem(nomeItem, atributo);		
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
	
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma){
		String identificador = getToken(nome, telefone);
		usuarios.get(identificador).cadastrarEletronico(nomeItem, preco, plataforma);
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
	
	
}
