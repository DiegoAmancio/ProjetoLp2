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
	
	

	/**
	 * cadastra o jogo eletronico
	 * 
	 * @param nomeItem
	 *            nome do item
	 * @param preco
	 *            preco do item
	 * @param plataforma
	 *            plataforma do item
	 */
	public void cadastrarEletronico(String nomeItem, double preco, String plataforma) {
		Item eletronico = new Eletronico(nomeItem, preco, plataforma);
		if(!(itens.containsKey(nomeItem))){
			itens.put(nomeItem, eletronico);
		}
		
	}
	public void cadastrarJogoTabuleiro(String nomeItem, double preco){
		Item novoTabuleiro = new JogoTabuleiro(nomeItem, preco);
		
		if(!(itens.containsKey(nomeItem))){
			itens.put(nomeItem, novoTabuleiro);
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
				return String.format("%.2f", itens.get(nomeItem).getPreco());
			}else{
				throw new NullPointerException("Item invalido");
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
