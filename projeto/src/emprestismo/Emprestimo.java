package emprestismo;

import java.util.*;

import java.text.*;

public class Emprestimo {
	private String nomeDono;
	private String nomeRequerente;
	private String dataEmprestimo;
	private String dataEntrega;
	private Date vencimento;
	private String itemEmprestado;
	private int periodo;
	private int devolveuDias;
	private boolean atrasou;

	public Emprestimo(String nomeDono, String nomeRequerente, String itemEmprestado, String dataEmprestimo, int periodo,
			int vencimento) {
		this.nomeDono = nomeDono;
		this.nomeRequerente = nomeRequerente;
		this.itemEmprestado = itemEmprestado;
		this.dataEmprestimo = dataEmprestimo;
		this.periodo = periodo;
		this.devolveuDias = 0;
		this.atrasou = false;
		this.dataEntrega = "Emprestimo em andamento";
		try {
			fazendoVencimento(dataEmprestimo, vencimento);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public void fazendoVencimento(String dataEmprestimo, int vencimento) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date data1 = formato.parse(dataEmprestimo);
		data1.setDate(data1.getDate() + vencimento);
		this.vencimento = data1;

	}

	public void fechandoEmprestimo(String dataEntrega) {
		this.dataEntrega = dataEntrega;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date data1 = null;
		try {
			data1 = formato.parse(dataEntrega);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (data1.after(this.vencimento)) {
			atrasou = true;
		}
		long diferencaDias = (data1.getTime() - this.vencimento.getTime()) / (1000 * 60 * 60 * 24);

		this.devolveuDias = (int) diferencaDias;

	}

	public void devolveu(String dataDevolucao) {
		this.dataEntrega = dataDevolucao;
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

	public boolean getAtrasou() {
		return atrasou;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public int getDevolveuDias() {
		return devolveuDias;
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

	public String getDataEmprestimo() {
		return dataEmprestimo;
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

	public String getNomeRequerente() {
		return nomeRequerente;
	}

	public void setNomeRequerente(String nomeRequerente) {
		this.nomeRequerente = nomeRequerente;
	}

	@Override
	public String toString() {

		return "EMPRESTIMO - De: " + nomeDono + ", Para: " + nomeRequerente + ", " + itemEmprestado + ", "
				+ dataEmprestimo + ", " + periodo + " dias, ENTREGA: " + dataEntrega + "|";
	}

}