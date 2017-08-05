package pacoteTestes;

import static org.junit.Assert.*;

import org.junit.Test;

import pacotePrincipal.UsuarioController;

public class UsuarioControllerTest {

	@Test
	public void testCadastrarUsuario() {
		UsuarioController controlador = new UsuarioController();
		
		controlador.cadastrarUsuario("diego", "4002-8922", "diego.pereira@ccc.ufcg.edu.br");
		assertEquals("diego.pereira@ccc.ufcg.edu.br", controlador.getInfoUsuario("diego", "4002-8922", "Email"));
	}

}
