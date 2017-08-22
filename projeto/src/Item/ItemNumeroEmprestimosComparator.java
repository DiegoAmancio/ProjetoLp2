package Item;

import java.util.Comparator;

public class ItemNumeroEmprestimosComparator implements Comparator<Item> {

	@Override
	public int compare(Item o1, Item o2) {
		return o1.compareToNumeroEmprestimos(o2)*(-1);
	}

}
