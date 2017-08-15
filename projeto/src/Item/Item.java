package Item;
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
<<<<<<< HEAD:projeto/src/pacotePrincipal/Item.java
	protected Emprestado emprestado;

=======
	protected boolean emprestado;
>>>>>>> d8406d058d52bf34bb0414e96702793ada5c1675:projeto/src/Item/Item.java
	/**
	 * constroi um item
	 * 
	 * @param nome
	 *            nome do item
	 * @param preco2
	 *            valor de compra deste item
	 */
	public Item(String nome, double preco) {
		verificaPreco(preco);
		this.nome = nome;
		this.preco = preco;
		this.emprestado = false;
	}

	public String getNome() {
		return nome;
	}
<<<<<<< HEAD:projeto/src/pacotePrincipal/Item.java

	public double getPreco() {
		return preco;
	}

=======
		
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
>>>>>>> d8406d058d52bf34bb0414e96702793ada5c1675:projeto/src/Item/Item.java
	public boolean isEmprestado() {
		return emprestado;
	}

	public void setEmprestado(boolean emprestado) {
		this.emprestado = emprestado;
	}
<<<<<<< HEAD:projeto/src/pacotePrincipal/Item.java

	public void verificaPreco(double preco) {
		if (preco < 0) {
			throw new IllegalArgumentException("Preco invalido");
		}
	}

	public String getInfo(String atributo) {
		String info = "";
=======
	
	public String getInfoItem(String atributo) {
>>>>>>> d8406d058d52bf34bb0414e96702793ada5c1675:projeto/src/Item/Item.java
		switch (atributo) {
		case "Nome":
			return this.getNome();
		case "Preco":
			return Double.toString(this.getPreco());			
		default:
			throw new IllegalArgumentException();
		}
	}

	@Override
<<<<<<< HEAD:projeto/src/pacotePrincipal/Item.java
	public String toString() {

		return nome + ", R$ " + Double.toString(preco) + ", " + emprestado.getMensagem();
	}

	@Override
=======
>>>>>>> d8406d058d52bf34bb0414e96702793ada5c1675:projeto/src/Item/Item.java
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
