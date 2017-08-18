package Item;

import Enums.Emprestado;
import Usuario.Emprestimo;

import java.util.List;

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
	private double preco;
	private List<Emprestimo> historicoDeEmprestimos;
	
	private Emprestado emprestado;
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
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public String isEmprestado() {
		return emprestado.getEmprestado();
	}
	
	public Emprestado getEmprestado() {
		return emprestado;
	}

	/**
	 * Set status de emprestimo, se o parametro de entrada for true, o item ser� emprestado, se n�o, o item estar� livre
	 * para ser emprestado
	 * @param estaEmprestado
	 */
	public void setEmprestado(Emprestado estaEmprestado) {
		if (this.emprestado != estaEmprestado) {
			this.emprestado = estaEmprestado;		
		}
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
			return Double.toString(this.getPreco());			
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

	public List<Emprestimo> getHistoricoDeEmprestimos() {
		return historicoDeEmprestimos;
	}

	public void setHistoricoDeEmprestimos(List<Emprestimo> historicoDeEmprestimos) {
		this.historicoDeEmprestimos = historicoDeEmprestimos;
	}	

}
