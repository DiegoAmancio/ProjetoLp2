package Item;

import java.util.Comparator;

public class ItemNomeComparator implements Comparable<Item>{
	
	
	public int compare(Item item1, Item item2) {
		return item1.getNome().compareTo(item2.getNome());
	}	
	
}