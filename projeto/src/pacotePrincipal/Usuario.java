package pacotePrincipal;

import java.util.ArrayList;
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
	private ArrayList<Item> itens;
	/**
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param email
	 *            email do usuario
	 */
	public Usuario(String nome, String telefone, String email ) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.itens = new ArrayList<Item>();
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
	
	public ArrayList<Item> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}

	/**
	 * representacao de um usuario
	 */
	@Override
	public String toString() {
		return nome + " , " + telefone + " , "+email;
	}
	/**
	 * compara um usuario com este.
	 * @param usuario usuario a ser comparado
	 * @return se o usuario e igual ao dono deste metodo.
	 */
	public boolean equals(Usuario usuario){
		boolean saida = false;
		if(usuario.getNome().equals(this.nome)){
			if(usuario.getTelefone().equals(this.telefone)){
			 saida = true;
			}
		}
		return saida;
	}
	
}
