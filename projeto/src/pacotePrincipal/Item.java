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
	protected String nome;
	protected double preco;
	protected boolean emprestado;
	/**
	 * constroi um item
	 * @param nome nome do item
	 * @param preco2 valor de compra deste item
	 */
	public Item(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
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
	
	public String getInfo(String atributo) {
		String info = "";
		switch (atributo) {
		case "Nome":
			info += this.getNome();
			return info;
		case "Preco":
			info += this.getPreco();
			return info;
		default:
			return info;
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	

}
