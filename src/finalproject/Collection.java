package finalproject;

import java.util.ArrayList;

import finalproject.Item.TagEnteredTwiceException;

public class Collection {
	private String name;
	private ArrayList<Item> contents;
	private boolean isKnownToBeSorted = false;
	

/**
	 * @param name
	 * @param contents
	 */
	public Collection(String name, ArrayList<Item> contents) {
		super();
		this.name = name;
		this.setContents(contents);
	}
	
/**
	 * @param name
	 * @param initialSize
	 */
	public Collection(String name, int initialSize) {
		super();
		this.name = name;
		setContents(new ArrayList<Item>(initialSize));
	}

	/**
	 * @param name
	 */
	public Collection(String name) {
		super();
		this.name = name;
		setContents(new ArrayList<Item>());
	}
	
	/**
	 * @param newItem the Item to add to contents
	 * @throws ItemEnteredTwiceException 
	 * if contents already contains newItem, do nothing and throw exception
	 */
	public void addItem(Item newItem) throws ItemEnteredTwiceException {
		if(getContents().contains(newItem)) {
			throw new ItemEnteredTwiceException();
		}else {
			getContents().add(newItem);
		}
	}
	
	public boolean deleteItem(Item itemToRemove) {
		return getContents().remove(itemToRemove);
	}
	

	@Override
	public String toString() {
		String info = "Collection [contents=\n\n";
		for(int i = 0; i < getContents().size(); i++) {
			
			info += "\n" + getContents().get(i).toString();
		}
		info += "\nnumberOfItems=" + getContents().size() + "]"; 
		return info;
	}
	
	/**
	 * @return the contents
	 */
	public ArrayList<Item> getContents() {
		return contents;
	}

	/**
	 * @param contents the contents to set
	 */
	public void setContents(ArrayList<Item> contents) {
		this.contents = contents;
	}

	public class ItemEnteredTwiceException extends Exception {

		private static final long serialVersionUID = 1L;

		public ItemEnteredTwiceException() {
			super("That Item has already been added!");
		}

		/**
		 * @param message
		 */
		public ItemEnteredTwiceException(String message) {
			super(message);
		}
		}	

}
