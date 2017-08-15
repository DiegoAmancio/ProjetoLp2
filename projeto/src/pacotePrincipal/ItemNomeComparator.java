package pacotePrincipal;

import java.util.Comparator;

/**
 * 
 * @author Andre Azevedo - 116111248
 *
 */
public class ItemNomeComparator implements Comparator<Item> {

	@Override
	public int compare(Item item1, Item item2) {
		return item1.getNome().compareTo(item2.getNome());
	}

}