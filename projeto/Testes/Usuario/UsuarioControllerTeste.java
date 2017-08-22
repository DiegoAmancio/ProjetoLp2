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
	 * testa se o programa lanÃ§a exceÃ§Ãµes caso o seja requisitado informaÃ§Ãµes de
	 * um usuario nÃ£o cadastrado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void usuariosInvalidosTest() {
		controlador.cadastrarUsuario("diego", "4002-8922", "diego.pereira@ccc.ufcg.edu.br");
		controlador.cadastrarUsuario("as", "4034-4922", "as@ccc.ufcg.edu.br");
		controlador.cadastrarUsuario("birl", "4034-4022", "bl@ccc.ufcg.edu.br");
		controlador.cadastrarUsuario("god", "7777-7777", "gd@ccc.ufcg.edu.br");

		assertEquals("Usuario invalido", controlador.getInfoUsuario("pirspapum", "4034-4922", "Email"));
		assertEquals("Usuario invalido", controlador.getInfoUsuario("wowwwwwwwwww", "4222-2222", "Nome"));

	}

	/**
	 * testa se o programa para quando tenta pegar infomaÃ§á¹�es de um usuario que
	 * antes tinha sido removido do sistema.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void removeUsuarioTest() {
		controlador.cadastrarUsuario("diego", "4002-8922", "diego.pereira@ccc.ufcg.edu.br");
		controlador.cadastrarUsuario("as", "4034-4922", "as@ccc.ufcg.edu.br");
		controlador.cadastrarUsuario("birl", "4034-4022", "bl@ccc.ufcg.edu.br");
		controlador.cadastrarUsuario("god", "7777-7777", "gd@ccc.ufcg.edu.br");

		controlador.removerUsuario("god", "7777-7777");
		assertEquals("Usuario invalido", controlador.getInfoUsuario("god", "7777-7777", "Nome"));
	}

	/**
	 * testa o metodo de atualizar o usuario quando a operaÃ§Ã£o e valida e quando
	 * nÃ£o Ã©.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void atualizaUsuario() {
		controlador.cadastrarUsuario("diego", "4002-8922", "diego.pereira@ccc.ufcg.edu.br");
		controlador.cadastrarUsuario("as", "4034-4922", "as@ccc.ufcg.edu.br");
		controlador.cadastrarUsuario("birl", "4034-4022", "bl@ccc.ufcg.edu.br");
		controlador.cadastrarUsuario("god", "7777-7777", "gd@ccc.ufcg.edu.br");

		controlador.atualizarUsuario("diego", "4002-8922", "Nome", "Ser trevoso");

		assertEquals("Usuario invalido", controlador.getInfoUsuario("diego", "4002-8922", "Nome"));
		assertEquals("Ser trevoso", controlador.getInfoUsuario("Ser trevoso", "4002-8922", "Nome"));

	}
	
//	public String registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente, 
	//String telefoneRequerente, String itemEmprestado, String dataEmprestimo, int periodo){
	@Test
	public void registraEmprestimo(){
		String nomeDono = "Isaac";
		String telefoneDono = "1234-1234";
		
		String nomeRequerente = "Jose";
		String telefoneRequerente = "3456-3456";
		
		String itemEmprestado = "Xuxa";
		String dataEmprestimo = "66/66/6666";
		int periodo = 3;
		
		controlador.cadastrarUsuario("Jose", "3456-3456", "jose.pereira@ccc.ufcg.edu.br");
		controlador.cadastrarUsuario("Isaac", "1234-1234", "isaac.pereira@ccc.ufcg.edu.br");
		controlador.cadastrarUsuario("Joao", "7890-7890", "joao.pereira@ccc.ufcg.edu.br");
		
		double preco = 15.50;
		int duracao = 60;
		int numeroFaixas = 10;
		String artista = "Xuxa Meneghel";
		String classificacao = "livre";
		// testa sucesso de emprestimo
		controlador.cadastrarBluRayShow(nomeDono, telefoneDono, itemEmprestado, preco, duracao, numeroFaixas, artista, classificacao);
		String msgRetornada = controlador.registrarEmprestimo(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, itemEmprestado, dataEmprestimo, periodo);
		
		assertEquals("Item emprestado com sucesso", msgRetornada);
		
		
		// teste item indisponivel para emprestimo
		String nomeRequerente2 = "Joao";
		String telefoneRequerente2 = "7890-7890";
		
		try {
			controlador.registrarEmprestimo(nomeDono, telefoneDono, nomeRequerente2, telefoneRequerente2, itemEmprestado, dataEmprestimo, periodo);
			fail("nao rodar essa linha");
		} catch (Exception e) {
			assertEquals("Item emprestado no momento", e.getMessage());
		}
		
		//expectError "Emprestimo nao encontrado" devolverItem nomeDono="Joao" telefoneDono="98888-8888" nomeRequerente="Vilmar" 
		//telefoneRequerente="55555-9999" nomeItem="War" dataEmprestimo="01/01/2018" dataDevolucao="06/01/2018"
		try {
			controlador.devolverItem(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, "War para meninas", dataEmprestimo, "06/01/2018");
			fail("nao passa essa linha");
		} catch (Exception e) {
			assertEquals("Emprestimo nao encontrado", e.getMessage());
		}
		
	}
	@Test
	public void desgraça(){
		controlador.cadastrarUsuario("Jericho","90510-2010","jericho@email.com");
		assertEquals("0.0", controlador.getInfoUsuario("Jericho","90510-2010","Reputacao"));
		
		controlador.cadastrarUsuario("Shauna","91005-2011","shauna@email.com");
		assertEquals("0.0", controlador.getInfoUsuario("Shauna","91005-2011","Reputacao"));
		
		controlador.cadastrarUsuario("Sarah","90809-2010","sarah@email.com");
		assertEquals("0.0", controlador.getInfoUsuario("Sarah","90809-2010","Reputacao"));
		
		controlador.cadastrarEletronico("Jericho","90510-2010","Age of Empires III",70.00,"PC");
		assertEquals("3.5", controlador.getInfoUsuario("Jericho","90510-2010","Reputacao"));
		
		controlador.cadastrarEletronico("Jericho","90510-2010","Age of Empires II",37.00,"PC");
		assertEquals("5.35", controlador.getInfoUsuario("Jericho","90510-2010","Reputacao"));

		controlador.cadastrarBluRayShow("Jericho","90510-2010","DJ Sona: Ultimate Concert",3250.00,13,3,"Sona","LIVRE");
		assertEquals("167.85",controlador.getInfoUsuario("Jericho","90510-2010","Reputacao"));
		assertEquals("3250.0",controlador.getInfoItem("Jericho", "90510-2010", "DJ Sona: Ultimate Concert", "Preco"));

		controlador.cadastrarJogoTabuleiro("Shauna","91005-2011","MECHS VS MINIONS",230.00);
		assertEquals("11.5",controlador.getInfoUsuario("Shauna","91005-2011","Reputacao"));

		controlador.cadastrarBluRaySerie("Shauna","91005-2011","A Lenda de Sleepy Hollow",115.00,"Ressurreicao, cavaleiros do apocalipse, bruxas...",42,"QUATORZE_ANOS","ACAO",2);
		assertEquals("17.25",controlador.getInfoUsuario("Shauna","91005-2011","Reputacao"));

		controlador.cadastrarBluRayFilme("Sarah","90809-2010","Piratas do Caribe: A Vingança de Salazar",60.00,129,"AVENTURA","DOZE_ANOS",2017);
		assertEquals("3.0" ,controlador.getInfoUsuario("Sarah","90809-2010","Reputacao"));

		controlador.cadastrarBluRayFilme("Sarah","90809-2010","Piratas do Caribe: A Maldição do Pérola Negra",20.00,136,"AVENTURA","QUATORZE_ANOS",2003);
		assertEquals("4.0",controlador.getInfoUsuario("Sarah","90809-2010","Reputacao"));

		controlador.registrarEmprestimo("Jericho","90510-2010","Sarah","90809-2010","DJ Sona: Ultimate Concert","03/05/2018",7);
		assertEquals("492.85", controlador.getInfoUsuario("Jericho","90510-2010","Reputacao"));
		assertEquals("4.0",controlador.getInfoUsuario("Sarah","90809-2010","Reputacao"));

		controlador.devolverItem("Jericho","90510-2010","Sarah","90809-2010","DJ Sona: Ultimate Concert","03/05/2018","12/05/2018");
		assertEquals("-61.0",controlador.getInfoUsuario("Sarah","90809-2010","Reputacao"));
		assertEquals("492.85",controlador.getInfoUsuario("Jericho","90510-2010","Reputacao"));		

		controlador.registrarEmprestimo("Sarah","90809-2010","Shauna","91005-2011","Piratas do Caribe: A Vingança de Salazar","05/05/2018",7);

		assertEquals("-55.0",controlador.getInfoUsuario("Sarah","90809-2010","Reputacao"));
		assertEquals("17.25",controlador.getInfoUsuario("Shauna","91005-2011","Reputacao"));
		
		controlador.devolverItem("Sarah","90809-2010","Shauna","91005-2011","Piratas do Caribe: A Vingança de Salazar","05/05/2018","12/05/2018");
//
//				# Reputcao de Shauna: 17.25 + 60 * 0.05 = 17.25 + 3.0 = 20.25
		assertEquals("20.25",controlador.getInfoUsuario("Shauna","91005-2011","Reputacao"));
		assertEquals("-55.0",controlador.getInfoUsuario("Sarah","90809-2010","Reputacao"));
//
//				fecharSistema

	}

	
}
