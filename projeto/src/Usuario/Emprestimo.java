package Usuario;

public class Emprestimo {
	private String nomeDono;
	private String nomeRequerente;
	private String dataEmprestimo;
	private String itemEmprestado;
	private int periodo;
	private String dataDevolucao; 

	public Emprestimo(String nomeDono, String nomeRequerente, String itemEmprestado, String dataEmprestimo, int periodo) {
		this.nomeDono = nomeDono;
		this.nomeRequerente = nomeRequerente;
		this.itemEmprestado = itemEmprestado;
		this.periodo = periodo;
		this.dataEmprestimo = dataEmprestimo;
	}
	
	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public String getNomeDono() {
		return nomeDono;
	}

	public void setNomeDono(String nomeDono) {
		this.nomeDono = nomeDono;
	}

	public String getNomeRequerente() {
		return nomeRequerente;
	}

	public void setNomeRequerente(String nomeRequerente) {
		this.nomeRequerente = nomeRequerente;
	}

	public String getDataEmprestimo() {
		return dataEmprestimo.toString();
	}

	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public String getItemEmprestado() {
		return itemEmprestado;
	}

	public void setItemEmprestado(String itemEmprestado) {
		this.itemEmprestado = itemEmprestado;
	}

	public String toStringEmprestou(){
		return "EMPRESTIMO - De: " + this.nomeDono + ", " + " Para: " + this.nomeRequerente + ", " + this.itemEmprestado + ", " + this.dataEmprestimo + ", " + this.periodo + ", ENTREGA: " + this.dataDevolucao;
	}	
	
	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataEmprestimo == null) ? 0 : dataEmprestimo.hashCode());
		result = prime * result + ((itemEmprestado == null) ? 0 : itemEmprestado.hashCode());
		result = prime * result + ((nomeDono == null) ? 0 : nomeDono.hashCode());
		result = prime * result + ((nomeRequerente == null) ? 0 : nomeRequerente.hashCode());
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
		Emprestimo other = (Emprestimo) obj;
		if (dataEmprestimo == null) {
			if (other.dataEmprestimo != null)
				return false;
		} else if (!dataEmprestimo.equals(other.dataEmprestimo))
			return false;
		if (itemEmprestado == null) {
			if (other.itemEmprestado != null)
				return false;
		} else if (!itemEmprestado.equals(other.itemEmprestado))
			return false;
		if (nomeDono == null) {
			if (other.nomeDono != null)
				return false;
		} else if (!nomeDono.equals(other.nomeDono))
			return false;
		if (nomeRequerente == null) {
			if (other.nomeRequerente != null)
				return false;
		} else if (!nomeRequerente.equals(other.nomeRequerente))
			return false;
		return true;
	}

}
