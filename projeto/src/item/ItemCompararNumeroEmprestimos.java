package item;

import java.util.Comparator;

public class ItemCompararNumeroEmprestimos implements Comparator<Item> {

	@Override
	public int compare(Item o1, Item o2) {
		int item1 = o1.numeroEmprestimos();
		int item2 = o2.numeroEmprestimos();		
		if (item1 < item2) {
			return -1;
		}else if (item1 > item2) {
			return 1;
		}
		return 0;
	}

}
