package Usuario;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Enums.Emprestado;
import Item.Item;

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
	private List<Emprestimo> emprestimos; // lista de emprestimos que realizou de itens de outros usuarios
	
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
		emprestimos = new ArrayList<Emprestimo>();
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
		
	public Map<String, Item> getItens() {
		return itens;
	}
	
	public boolean existeItem(String nomeItem){
		if(itens.get(nomeItem) != null){
			return true;
		}else{
			return false;
		}			
	}
	
	public void setItens(Map<String, Item> itens) {
		this.itens = itens;
	}
	
	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}
	//TODO requerente nao tem item
	public String registraEmprestimo(Emprestimo novoEmprestimo, String nomeItem) {
		
		try {
			emprestimos.add(novoEmprestimo);
			itens.get(nomeItem).setEmprestado(Emprestado.EMPRESTADO);
			return "Emprestimo cadastrado com sucesso";
		} catch (Exception e) {
			return "Erro ao cadastrar emprestimo";
		}
	}
	
	public void adicionaItem(String nomeItem, Item item) {
		if (!(itens.containsKey(nomeItem))) {
			itens.put(nomeItem, item);
		}		
	}
	
	public void removerItem(String nomeItem){
		if(itens.containsKey(nomeItem)){
			itens.remove(nomeItem);
		}else{
			throw new NullPointerException("Item nao encontrado");			
		}
	}	
	
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

	public String getDetalhes(String nomeItem){
		if(itens.containsKey(nomeItem)){
			return itens.get(nomeItem).toString();
		}
		throw new NullPointerException("Item nao encontrado");
	}

	/**
	 * representacao de um usuario
	 */
	@Override
	public String toString() {
		return nome + ", " + telefone + ", " + email;
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
	
	public Item getItem(String itemEmprestado) {
		return itens.get(itemEmprestado);		
	}
	
	
	
}
