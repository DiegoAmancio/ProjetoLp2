package item;
/**
 * representação de um item
 * 
 * 
 * Laboratório de Programação 2 - projeto
 * 
 * @author Diego Amancio - 116210716
 */
public abstract class Item {
	protected String nome;
	protected int preco;
	protected boolean emprestado;
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
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Item) {
			if (((Item) obj).getNome().equals(nome)) {
				return true;
			}
		}
		return false;
	}

}
