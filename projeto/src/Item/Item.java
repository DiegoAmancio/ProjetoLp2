package Item;

import Enums.Emprestado;
import emprestismo.Emprestimo;
import emprestismo.EmprestimoComparator;

import java.util.ArrayList;
import java.util.Collections;
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
	private String donoItem;
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
	public Item(String donoItem, String nome, double preco) {
		verificaPreco(preco);
		this.donoItem = donoItem;
		this.nome = nome;
		this.preco = preco;
		this.emprestado = Emprestado.NAO_EMPRESTADO;
		this.historicoDeEmprestimos = new ArrayList<Emprestimo>();
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
	public int numeroEmprestimos() {
		return historicoDeEmprestimos.size();
	}
	/**
	 * Set status de emprestimo, se o parametro de entrada for true, o item ser�
	 * emprestado, se n�o, o item estar� livre para ser emprestado
	 * 
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
	public int compareToNumeroEmprestimos(Item item) {
		return this.numeroEmprestimos() - item.numeroEmprestimos();
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

	public void adicionarHistorico(Emprestimo novoEmprestimo) {
		
		boolean temEmprestimo = false;
		for (int i = 0; i < historicoDeEmprestimos.size(); i++) {
			if (historicoDeEmprestimos.get(i).equals(novoEmprestimo)) {
				temEmprestimo = true;

			}

		}
		if (!(temEmprestimo)) {
			historicoDeEmprestimos.add(novoEmprestimo);
		}
	}

	public void atualizandoEmprestimo(Emprestimo emprestimo, String dataDevolucao) {
		if (historicoDeEmprestimos.contains(emprestimo)) {
			for (int i = 0; i < historicoDeEmprestimos.size(); i++) {
				if (historicoDeEmprestimos.get(i).equals(emprestimo)) {
					historicoDeEmprestimos.get(i).devolveu(dataDevolucao);
					
				}
			}
		}
	}

	public String emprestimos() {
		String saida = "Emprestimos associados ao item: ";
		Collections.sort(historicoDeEmprestimos, new EmprestimoComparator());

		if (historicoDeEmprestimos.size() > 0) {

			for (int i = 0; i < historicoDeEmprestimos.size(); i++) {
				saida += historicoDeEmprestimos.get(i).toString();
			}
			return saida;
		} else {
			return ("Nenhum emprestimos associados ao item");
		}
	}

	public String getDonoItem() {
		return donoItem;
	}

	public void setDonoItem(String donoItem) {
		this.donoItem = donoItem;
	}
}
