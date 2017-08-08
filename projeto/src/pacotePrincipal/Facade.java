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
	
	public void getInfoItem(){
		
	}
	
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, int preco, String plataforma) {
		controllerUsuario.cadastrarEletronico(nome, telefone, nomeItem, preco, plataforma);
	}

	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, int preco) {
	}

	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {

	}

	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, int duracao, String genero,
			String classificacao, int anoLancamento) {

	}

	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, int duracao, int numeroFaixas,
			String artista, String classificacao) {

	}

	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, int preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) {

	}
	public void adicionarBluRay(String nome, String telefone, String nomeBlueRayTemporada, int duracao) {

	}
	public void removerItem(String nome, String telefone, String nomeItem) {

	}
	public void atualizarItem(String nome, String telefone,String nomeItem, String atributo, String valor) {

	}
	
}
