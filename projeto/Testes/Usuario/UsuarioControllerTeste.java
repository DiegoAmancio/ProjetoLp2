package Usuario;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * testa metodos da classe UsuarioController
 * 
 * @author diego
 *
 */
public class UsuarioControllerTeste {
	
	UsuarioController controlador;
	
	@Before
	public void setup() {
		controlador = new UsuarioController();
	}
		
	/**
	 * testa o cadastramento de usuarios no sistema
	 */
	@Test
	public void testCadastrarUsuario() {
		controlador.cadastrarUsuario("diego", "4002-8922", "diego.pereira@ccc.ufcg.edu.br");
		controlador.cadastrarUsuario("as", "4034-4922", "as@ccc.ufcg.edu.br");
		controlador.cadastrarUsuario("birl", "4034-4022", "bl@ccc.ufcg.edu.br");
		controlador.cadastrarUsuario("god", "7777-7777", "gd@ccc.ufcg.edu.br");

		assertEquals("diego.pereira@ccc.ufcg.edu.br", controlador.getInfoUsuario("diego", "4002-8922", "Email"));
		assertEquals("4002-8922", controlador.getInfoUsuario("diego", "4002-8922", "Telefone"));
		assertEquals("diego", controlador.getInfoUsuario("diego", "4002-8922", "Nome"));

		assertEquals("bl@ccc.ufcg.edu.br", controlador.getInfoUsuario("birl", "4034-4022", "Email"));
		assertEquals("4034-4022", controlador.getInfoUsuario("birl", "4034-4022", "Telefone"));
		assertEquals("birl", controlador.getInfoUsuario("birl", "4034-4022", "Nome"));

		assertEquals("as@ccc.ufcg.edu.br", controlador.getInfoUsuario("as", "4034-4922", "Email"));
		assertEquals("4034-4922", controlador.getInfoUsuario("as", "4034-4922", "Telefone"));
		assertEquals("as", controlador.getInfoUsuario("as", "4034-4922", "Nome"));

		assertEquals("gd@ccc.ufcg.edu.br", controlador.getInfoUsuario("god", "7777-7777", "Email"));
		assertEquals("7777-7777", controlador.getInfoUsuario("god", "7777-7777", "Telefone"));
		assertEquals("god", controlador.getInfoUsuario("god", "7777-7777", "Nome"));

	}

	/**
	 * testa se o programa lança exceções caso o seja requisitado informações de
	 * um usuario não cadastrado.
	 */
	@Test(expected = NullPointerException.class)
	public void usuariosInvalidosTest() {
		controlador.cadastrarUsuario("diego", "4002-8922", "diego.pereira@ccc.ufcg.edu.br");
		controlador.cadastrarUsuario("as", "4034-4922", "as@ccc.ufcg.edu.br");
		controlador.cadastrarUsuario("birl", "4034-4022", "bl@ccc.ufcg.edu.br");
		controlador.cadastrarUsuario("god", "7777-7777", "gd@ccc.ufcg.edu.br");

		assertEquals("Usuario invalido", controlador.getInfoUsuario("pirspapum", "4034-4922", "Email"));
		assertEquals("Usuario invalido", controlador.getInfoUsuario("wowwwwwwwwww", "4222-2222", "Nome"));

	}

	/**
	 * testa se o programa para quando tenta pegar infomaçṍes de um usuario que
	 * antes tinha sido removido do sistema.
	 */
	@Test(expected = NullPointerException.class)
	public void removeUsuarioTest() {
		controlador.cadastrarUsuario("diego", "4002-8922", "diego.pereira@ccc.ufcg.edu.br");
		controlador.cadastrarUsuario("as", "4034-4922", "as@ccc.ufcg.edu.br");
		controlador.cadastrarUsuario("birl", "4034-4022", "bl@ccc.ufcg.edu.br");
		controlador.cadastrarUsuario("god", "7777-7777", "gd@ccc.ufcg.edu.br");

		controlador.removerUsuario("god", "7777-7777");
		assertEquals("Usuario invalido", controlador.getInfoUsuario("god", "7777-7777", "Nome"));
	}

	/**
	 * testa o metodo de atualizar o usuario quando a operação e valida e quando
	 * não é.
	 */
	@Test(expected = NullPointerException.class)
	public void atualizaUsuario() {
		controlador.cadastrarUsuario("diego", "4002-8922", "diego.pereira@ccc.ufcg.edu.br");
		controlador.cadastrarUsuario("as", "4034-4922", "as@ccc.ufcg.edu.br");
		controlador.cadastrarUsuario("birl", "4034-4022", "bl@ccc.ufcg.edu.br");
		controlador.cadastrarUsuario("god", "7777-7777", "gd@ccc.ufcg.edu.br");

		controlador.atualizarUsuario("diego", "4002-8922", "Nome", "Ser trevoso");

		assertEquals("Usuario invalido", controlador.getInfoUsuario("diego", "4002-8922", "Nome"));
		assertEquals("Ser trevoso", controlador.getInfoUsuario("Ser trevoso", "4002-8922", "Nome"));

	}
}
