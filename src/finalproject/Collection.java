/**
 * 
 */
package finalproject;

import java.util.Arrays;

/**
 * @author stephenpolson
 *
 */
public class Collection {
	Item[] contents;
	int numberOfItems;
	
	/**
	 * 
	 */
	public Collection() {
		super();
		contents = new Item[99];
		numberOfItems = 0;
	}
	
	public Collection(int maxNumberOfItems) {
		contents = new Item[maxNumberOfItems];
		numberOfItems = 0;
	}
	
	public Collection(Item[] initialSetOfItems) {
		contents = new Item[ 2*initialSetOfItems.length ];
		numberOfItems = 0;
		
		for(int i = 0; i < initialSetOfItems.length; i++) {
			if(initialSetOfItems[i] != null) {
				numberOfItems++;
				contents[i] = initialSetOfItems[i];
			}
		}
	}
	
	public void addItem(Item newItem) {
		ensureContentsCapacity();
		// TODO If name is the UID of the item, we probably want to keep contents sorted by name
		// otherwise we just add item to the end of the list 
		// [numberOfItems++] = newItem;
	}
	public void deleteItem(Item itemToDelete) {
		// TODO method Stub
	}

	@Override
	public String toString() {
		return "Collection [contents=" + Arrays.toString(contents) + ", numberOfItems=" + numberOfItems + "]";
	}

	/**
	 * Grow contents[] capacity as needed
	 */
	private void ensureContentsCapacity() {
		// TODO Auto-generated method stub
		
	}

}
