package Item;

import Enums.Emprestado;

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

	protected Emprestado emprestado;
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
		this.emprestado = Emprestado.NAO_EMPRESTADO;
	}

	public String getNome() {
		return nome;
	}
		
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getPreco() {
		return preco;
	}
	
<<<<<<< HEAD:projeto/src/pacotePrincipal/Item.java
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public boolean isEmprestado() {
		return emprestado.getValor();
	}
	
	public void setEmprestado(boolean emprestado) {
		this.emprestado = Emprestado.EMPRESTADO;
=======
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public String isEmprestado() {
		return emprestado.getEmprestado();
>>>>>>> 034fe3d7e89fadd62e0dd84884b6827079394950:projeto/src/Item/Item.java
	}


	public void verificaPreco(double preco) {
		if (preco < 0) {
			throw new IllegalArgumentException("Preco invalido");
		}
	}

	
	public String getInfoItem(String atributo) {
		switch (atributo) {
		case "Nome":
			return this.getNome();
		case "Preco":
<<<<<<< HEAD:projeto/src/pacotePrincipal/Item.java
			info += this.getPreco();
			return info;
=======
			return Double.toString(this.getPreco());			
>>>>>>> 034fe3d7e89fadd62e0dd84884b6827079394950:projeto/src/Item/Item.java
		default:
			throw new IllegalArgumentException();
		}
	}

	@Override
	public String toString() {
		return this.nome + ", R$ " + Double.toString(preco) + ", " + emprestado.getEmprestado();
	}
	
	public int compareToPreco(Item item) {
	       if (this.preco < item.getPreco()) {
	           return -1;
	       }
	       if (this.preco > item.getPreco()) {
	           return 1;
	       }
	       return 0;
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
