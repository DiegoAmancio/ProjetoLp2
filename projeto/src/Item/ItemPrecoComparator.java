package Item;

import java.util.Comparator;

public class ItemPrecoComparator implements Comparator<Item> {

	public int compare(Item item1, Item item2) {
		return item1.compareToPreco(item2);
    
	}

}
