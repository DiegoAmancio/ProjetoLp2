package pacotePrincipal;
/**
 * representacao de um item
 * 
 * 
 * Laboratorio de Programacao 2 - projeto
 * 
 * @author Diego Amancio - 116210716
 */
public abstract class Item {
	private String nome;
	private int preco;
	private boolean emprestado;
	/**
	 * constroi um item
	 * @param nome nome do item
	 * @param preco valor de compra deste item
	 */
	public Item(String nome, int preco) {
		this.nome = nome;
		this.preco = preco;
		this.emprestado = false;
	}
	public String getNome() {
		return nome;
	}
	
	public int getPreco() {
		return preco;
	}
	
	public boolean isEmprestado() {
		return emprestado;
	}
	public void setEmprestado(boolean emprestado) {
		this.emprestado = emprestado;
	}
	
	

}
