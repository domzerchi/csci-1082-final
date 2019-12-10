package finalproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import finalproject.Collection.ItemEnteredTwiceException;
import finalproject.Item.TagEnteredTwiceException;

/**
 * @author stephenpolson aydensinn
 * 
 * A Collection object essentially organizes all the objects in a database.
 *
 */

public class Collection implements Serializable {
	/**
	 * 
	 */
	public Collection() {
		super();
		// TODO Auto-generated constructor stub
	}

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
			isKnownToBeSorted = false;
		}
	}
	
	public boolean deleteItem(Item itemToRemove) {
		return getContents().remove(itemToRemove);
	}
	
	public void saveCollection() throws IOException {
		String fileName="DatabaseFiles" + File.separator + name;
		FileOutputStream fout = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(this);
		oos.close();
	}
	
	public Collection readCollection(String databaseToRead) throws FileNotFoundException, IOException, ClassNotFoundException {
		String fileName="DatabaseFiles" + File.separator + databaseToRead;
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
		Collection database;
		database = (Collection)ois.readObject();
		ois.close();
		return database;
		
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		if(!isKnownToBeSorted) {
			Collections.sort(contents, Item.CompareByValue);
			isKnownToBeSorted = true;
		}
		String info = "Collection " + name + "[contents=\n";
		for(int i = 0; i < getContents().size(); i++) {
			
			info += "\n\n" + getContents().get(i).toString();
		}
		info += "\nnumberOfItems=" + getContents().size() + "]"; 
		return info;
	}
	
	/**
	 * @return the items that make up the database
	 */
	public ArrayList<Item> getContents() {
		if(!isKnownToBeSorted) {
			Collections.sort(contents, Item.CompareByValue);
			isKnownToBeSorted = true;
		}
		return contents;
	}

	/**
	 * @param contents the items to be set as the contents of the database
	 */
	public void setContents(ArrayList<Item> contents) {
		this.contents = contents;
		if(!isKnownToBeSorted) {
			Collections.sort(contents, Item.CompareByValue);
			isKnownToBeSorted = true;
		}
	}
	
	//search for 1 item
	public Collection find(ArrayList<Item> itemsToFind) {
		Collection found = new Collection();
		for(Item element : itemsToFind) {
			if(contents.contains(element)) {
				try {
					found.addItem(element);
				} catch (ItemEnteredTwiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return found;
	}

	//return a list of tags
	public Collection containsTags(ArrayList<Tag> tagsToFind) {
		Collection found = new Collection();
		for(Item eachItem : contents) {
			for(Tag eachTag : tagsToFind) {
				if(eachItem.getTags().contains(eachTag)) {
					try {
						found.addItem(new Item(eachItem.getValue(), eachItem.find(tagsToFind)));
						break;
					} catch (ItemEnteredTwiceException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return found;
	}
	
	public ArrayList<Tag> findTag(ArrayList<Tag> tagsToFind){
		ArrayList<Tag> found = new ArrayList<Tag>();
		for(Tag eachTag : tagsToFind) {
			for(Item eachItem : contents) {
				if(eachItem.getTags().contains(eachTag)) {
					found.add(eachTag);
					break;
				}
			}
		}
		return found;
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
