package PacoteTestes;

import org.junit.Test;

import pacotePrincipal.Usuario;

/**
 * testa criaçao de usuarios.
 * 
 * @author diego
 *
 */
public class UsuarioTest {
	/**
	 * testa criaçao de usuarios invalidos
	 * 
	 * @author diego
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void usuariosInvalidosTest() {

		Usuario usuarioEmailVazio1 = new Usuario("diego", "4002-8922", "                    ");

		Usuario usuarioTelefoneVazio1 = new Usuario("as", "", "as@ccc.ufcg.edu.br");
		Usuario usuarioTelefoneVazio2 = new Usuario("birl", "                 ", "bl@ccc.ufcg.edu.br");

		Usuario usuarioNomeVazio1 = new Usuario("god", " ", "gd@ccc.ufcg.edu.br");
		Usuario usuarioNomeVazio2 = new Usuario("", "4002-8922", "diego.pereira@ccc.ufcg.edu.br");

	}
}
