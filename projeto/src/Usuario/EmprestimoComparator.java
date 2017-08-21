package Usuario;

import java.util.Comparator;

public class EmprestimoComparator implements Comparator<Emprestimo> {
		
	public int compare(Emprestimo emprestimo1, Emprestimo emprestimo2) {
		return emprestimo1.getItemEmprestado().compareTo(emprestimo2.getItemEmprestado());
	}	
	
}