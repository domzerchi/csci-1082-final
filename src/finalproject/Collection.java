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
		contents[numberOfItems++] = newItem;
	}
	public void deleteItem(Item itemToDelete) {
		// TODO method Stub
	}

	@Override
	public String toString() {
		String info = "Collection [contents=\n\n";
		for(int i = 0; i < numberOfItems; i++) {
			
			if(contents[i] != null) {
				info += contents[i].toString() + "\n";
			}
		}
		info += "\nnumberOfItems=" + numberOfItems + "]"; 
		return info;
	}

	/**
	 * Grow contents[] capacity as needed
	 */
	private void ensureContentsCapacity() {

		if(numberOfItems >= contents.length) {
			Item temp[] = new Item[1 + 2*numberOfItems]; 
			for(int i = 0; i < contents.length; i++) {
				temp[i] = contents[i];
			}
			contents = temp;
		}
		
	}

}
