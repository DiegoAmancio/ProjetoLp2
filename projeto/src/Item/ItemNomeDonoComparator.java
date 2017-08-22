package Item;

import java.util.Comparator;

public class ItemNomeDonoComparator implements Comparator<Item>{

	@Override
	public int compare(Item o1, Item o2) {
		return o1.getDonoItem().compareTo(o2.getDonoItem());
	}

}
