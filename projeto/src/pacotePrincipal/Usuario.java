package pacotePrincipal;


import java.util.HashMap;
import java.util.Map;

/**
 * representacao de um usuario
 * 
 * 
 * Laboratorio de Programacao 2 - projeto
 * 
 * @author Diego Amancio - 116210716
 */
public class Usuario {
	private String nome;
	private String telefone;
	private String email;
	private Map<String, Item> itens;
	
	/**
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param email
	 *            email do usuario
	 */
	public Usuario(String nome, String telefone, String email) {
		
		validaUsuarioAtributo(nome, "Nome");
		validaUsuarioAtributo(telefone, "Telefone");
		validaUsuarioAtributo(email, "Email");
		
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.itens = new HashMap<String, Item>();
	}
	public void validaUsuarioAtributo(String atributo,String qualAtributo){
		if(atributo == null){
			throw new NullPointerException(qualAtributo+"invalido,nulo");
		}
		if(atributo.trim().equals("")){
			throw new IllegalArgumentException(qualAtributo+"invalido,vazio");
		}
	}
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
	
	
	public void cadastrarEletronico(String nomeItem, double preco, String plataforma){
		Item novoEletronico = new Eletronico(nomeItem, preco, plataforma);		
		if(!(itens.containsKey(nomeItem))){
			if(preco > 0){
				itens.put(nomeItem, novoEletronico);
				
			}else{
				throw new IllegalArgumentException("Preco invalido");
			}
		}
	}

	public void cadastrarJogoTabuleiro(String nomeItem, double preco){
		Item novoTabuleiro = new JogoTabuleiro(nomeItem, preco);		
		if(!(itens.containsKey(nomeItem))){
			if(preco > 0){
				itens.put(nomeItem, novoTabuleiro);
			}else{
				throw new IllegalArgumentException("Preco invalido");
			}
		}
	}
	
	public void cadastrarBluRayFilme(String nomeItem, double preco, int duracao, String genero, String classificacao, int anoLancamento){
		Item novoBluRayFilme = new BluRayFilme(nomeItem, preco, duracao, classificacao, genero, anoLancamento);
		if(!(itens.containsKey(nomeItem))){
			itens.put(nomeItem, novoBluRayFilme);
			
		}
	}

	
	public void cadastrarBluRayShow(String nomeItem, double preco, int duracao, String classificacao, int numeroFaixas, String nomeArtista){
		Item novoBluRayShow = new BluRayShow(nomeItem, preco, duracao, classificacao, numeroFaixas, nomeArtista);
		if(!(itens.containsKey(nomeItem))){
			itens.put(nomeItem, novoBluRayShow);
		}
	}
	
	public void cadastrarBluRaySerie(String nomeItem, double preco, int duracao, String classificacao, String genero, int numeroDaTemporada){
		Item novoBluRaySerie = new BluRaySerie(nomeItem, preco, duracao, classificacao, genero, numeroDaTemporada);
		if(!(itens.containsKey(nomeItem))){
			itens.put(nomeItem, novoBluRaySerie);
		}
	}
	
	public void removerItem(String nomeItem){
		if(itens.containsKey(nomeItem)){
			itens.remove(nomeItem);
		}else{
			throw new NullPointerException("Item nao encontrado");			
		}
	} 
	
	//atualizarItem nome="Joao" telefone="98888-8888" nomeItem="Pokemon Emerald" atributo="Nome" valor="Pokemon Omega Ruby"
	//expect "Pokemon Omega Ruby" getInfoItem nome="Joao" telefone="98888-8888" nomeItem="Pokemon Omega Ruby" atributo="Nome"
	/**
	 * atualiza o preco do item
	 * @param nomeItem
	 * @param atributo
	 * @param valor
	 * @param preco
	 */
	public void atualizarItem(String nomeItem, String atributo, String valor){
		if(itens.containsKey(nomeItem)){
			switch (atributo.trim().toUpperCase()) {
			
			case "PRECO":
				double novoValor = Double.parseDouble(valor);
				itens.get(nomeItem).setPreco(novoValor);
				break;
			case "NOME": 
				Item item = itens.get(nomeItem);
				itens.remove(nomeItem);
				itens.put(valor, item);
				itens.get(valor).setNome(valor);
				break;
			default:
				throw new IllegalArgumentException();
			}
		}else{
			throw new NullPointerException("Item nao encontrado");
		}
	}
	/**
	 * Retorna o preco do item
	 * @param nomeItem
	 * @param atributo
	 * @return
	 */
	
		public String getInfoItem(String nomeItem, String atributo){
			if(itens.containsKey(nomeItem)){				
				switch (atributo.trim().toUpperCase()) {
				case "PRECO":
					return Double.toString(itens.get(nomeItem).getPreco());					
				case "NOME":
					return itens.get(nomeItem).getNome();
				default:
					throw new IllegalArgumentException();
				}
			}else{
				throw new IllegalArgumentException("Item nao encontrado");
			}
		}

	

	/**
	 * representacao de um usuario
	 */
	@Override
	public String toString() {
		return nome + " , " + telefone + " , " + email;
	}

	/**
	 * compara um usuario com este.
	 * 
	 * @param usuario
	 *            usuario a ser comparado
	 * @return se o usuario e igual ao dono deste metodo.
	 */
	public boolean equals(Usuario usuario) {
		boolean saida = false;
		if (usuario.getNome().equals(this.nome)) {
			if (usuario.getTelefone().equals(this.telefone)) {
				saida = true;
			}
		}
		return saida;
	}
	
	
	
}
