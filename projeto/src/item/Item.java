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
	protected double preco;
	protected boolean emprestado;
	/**
	 * constroi um item
	 * @param nome nome do item
	 * @param preco2 valor de compra deste item
	 */
	public Item(String nome, double preco2) {
		this.nome = nome;
		this.preco = preco2;
		this.emprestado = false;
	}
	public String getNome() {
		return nome;
	}
	
	public double getPreco() {
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
