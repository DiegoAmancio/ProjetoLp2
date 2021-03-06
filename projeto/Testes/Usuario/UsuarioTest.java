package Usuario;

import org.junit.Before;
import org.junit.Test;

import usuario.Usuario;

/**
 * testa criaçao de usuarios.
 * 
 * @author andre
 *
 */
public class UsuarioTest {
	
	Usuario usuarioInvalido;
	
	@Before
	public void setup() {
		usuarioInvalido = new Usuario(null, null, null);
	}
	
	/**
	 * testa criaçao de usuarios invalidos
	 * 
	 * @author andre
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void usuariosEmailVazioTest() {
		usuarioInvalido = new Usuario("diego", "4002-8922", "");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void usuariosEmailEspacosTest() {
		usuarioInvalido = new Usuario("diego", "4002-8922", "               ");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void usuarioTelefoneVazioTest() {
		usuarioInvalido = new Usuario("as", "", "as@ccc.ufcg.edu.br");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void usuarioTelefoneEspacosTest() {
		usuarioInvalido = new Usuario("as", "               ", "as@ccc.ufcg.edu.br");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void usuarioNomeVazioTest() {
		usuarioInvalido = new Usuario("", "4002-8922", "diego.pereira@ccc.ufcg.edu.br");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void usuarioNomeEspacosTest() {
		usuarioInvalido = new Usuario("               ", "4002-8922", "diego.pereira@ccc.ufcg.edu.br");
	}
}
