package emprestismo;

import java.util.Comparator;

public class EmprestimoComparator implements Comparator<Emprestimo>{

	@Override
	public int compare(Emprestimo o1, Emprestimo o2) {
		return o1.getItemEmprestado().compareTo(o2.getItemEmprestado());
	}

}
