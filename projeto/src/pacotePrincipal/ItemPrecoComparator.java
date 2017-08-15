package pacotePrincipal;

import java.util.Comparator;

/**
 * 
 * @author Andre Azevedo - 116111248
 *
 */
public class ItemPrecoComparator implements Comparator<Item> {

	@Override
	public int compare(Item item1, Item item2) {
		return (int) (item2.getPreco() - item1.getPreco());
	}

}
