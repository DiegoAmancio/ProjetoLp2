package pacotePrincipal;

public class Facade {
	UsuarioController controllerUsuario;
	
	public Facade() {
		controllerUsuario = new UsuarioController();
	}
	public void iniciarSistema(){
		
	}
	public void fecharSistema(){
		
	}
	public void cadastrarUsuario(String nome, String telefone, String email) {
		controllerUsuario.cadastrarUsuario(nome, telefone, email);
	}
	public String getInfoUsuario(String nome,String telefone,String atributo){
		return controllerUsuario.getInfoUsuario(nome, telefone, atributo);
	}

	public void removerUsuario(String nome, String telefone) {
		controllerUsuario.removerUsuario(nome, telefone);
	}

	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {
		controllerUsuario.atualizarUsuario(nome, telefone, atributo, valor);
	}
	
	public void getInfoItem(String nome, String telefone, String nomeItem, String atributo){
		controllerUsuario.getInfoItem(nome, telefone, nomeItem, atributo);
	}
	
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		controllerUsuario.cadastrarEletronico(nome, telefone, nomeItem, preco, plataforma);
	}

	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		controllerUsuario.cadastrarJogoTabuleiro(nome, telefone, nomeItem, preco);
	}

	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		controllerUsuario.adicionarPecaPerdida(nome, telefone, nomeItem, nomePeca);
	}

	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao, String genero, String classificacao, int anoLancamento) {
		controllerUsuario.cadastrarBluRayFilme(nome, telefone, nomeItem, preco, duracao, genero, classificacao, anoLancamento);
	}

	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao, int numeroFaixas, String artista, String classificacao) {
		controllerUsuario.cadastrarBluRayShow(nome, telefone, nomeItem, preco, duracao, numeroFaixas, artista, classificacao);
	}

	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao, int duracao, String classificacao, String genero, int temporada) {
		controllerUsuario.cadastrarBluRaySerie(nome, telefone, nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
	}
	
	public void adicionarBluRay(String nome, String telefone, String nomeItem, int duracao) {
		controllerUsuario.adicionarBluRay(nome, telefone, nomeItem, duracao);
	}
	
	public void removerItem(String nome, String telefone, String nomeItem) {
		
	}
	
	public void atualizarItem(String nome, String telefone,String nomeItem, String atributo, String valor) {
		
	}
	
	public String pesquisarDetalhesItem(String nome, String telefone, String nomeItem) {
		return controllerUsuario.pesquisarDetalhesItem(nome, telefone, nomeItem);
	}
	
	public String listarItensOrdenadosPorNome() {
		return controllerUsuario.listarItensOrdenadosPorNome();
	}
	
	public String listarItensOrdenadosPorValor() {
		return controllerUsuario.listarItensOrdenadosPorValor();
	}
	
}
