package finalproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//Collection and all classes within it need to be serializable in order for reading/writing of databases to work
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import finalproject.Collection.ItemEnteredTwiceException;
import finalproject.Item.TagEnteredTwiceException;

/**
 * @author stephen polson
 * @author ayden sinn
 * 
 * A Collection object essentially organizes all the objects in a database.
 *
 */

public class Collection implements Serializable {

	private String name;
	private ArrayList<Item> contents;
	private boolean isKnownToBeSorted = false;


	/**
	 * Constructor for a collection that takes no parameters
	 */
	public Collection() {
		super();
	}

	/**
	 * Constructor for a collection that takes a name
	 * @param name What the collection will be named
	 */
	public Collection(String name) {
		super();
		this.name = name;
		setContents(new ArrayList<Item>());
	}
	
	/**
	 * Constructor for a collection that takes a name and an initial size
	 * @param name what the collection will be named
	 * @param initialSize
	 */
	public Collection(String name, int initialSize) {
		super();
		this.name = name;
		setContents(new ArrayList<Item>(initialSize));
	}
	
	/**
	 * Constructor for a collection that takes a name and an array list
	 * @param name what the collection will be named
	 * @param contents an array list of content that is added to the collection
	 */
	public Collection(String name, ArrayList<Item> contents) {
		super();
		this.name = name;
		this.setContents(contents);
	}

	// accessor for name
	public String getName() {
		return name;
	}

	// mutator for name
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * getter for array list content
	 * @return the items that make up the database
	 */
	public ArrayList<Item> getContents() { // fix thisssss
		if(!isKnownToBeSorted) {
			Collections.sort(contents, Item.CompareByValue);
			isKnownToBeSorted = true;
		}
		return contents;
	}

	/**
	 * setter for array list content
	 * @param contents the items to be set as the contents of the database
	 */
	public void setContents(ArrayList<Item> contents) {
		this.contents = contents;
		if(!isKnownToBeSorted) {
			Collections.sort(contents, Item.CompareByValue);
			isKnownToBeSorted = true;
		}
	}
	
	/**
	 * if contents already contains newItem, do nothing and throw exception
	 * @param newItem the Item to add to contents
	 * @throws ItemEnteredTwiceException 
	 */
	public void addItem(Item newItem) throws ItemEnteredTwiceException {
		if(getContents().contains(newItem)) {
			throw new ItemEnteredTwiceException();
		}else {
			getContents().add(newItem);
			isKnownToBeSorted = false;
		}
	}

	/**
	 * removes item from a collection
	 * @param itemToRemove the item trying to be removed
	 * @return whether or not the item was removed successfully
	 */
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
	
	/**
	 * @param relabiveFilePath currently means relative to user working directory
	 * @throws IOException
	 */
	public void saveCollection(String relabiveFilePath) throws IOException {
		String fileName="DatabaseFiles" + File.separator + name;
		FileOutputStream fout = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(this);
		oos.close();
	}

	public Collection readCollection(String databaseToRead) throws FileNotFoundException, IOException, ClassNotFoundException {
		String fileName=databaseToRead;
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
		Collection database;
		database = (Collection)ois.readObject();
		ois.close();
		return database;

	}




	/**
	 * searches contents for a certain item
	 * @param itemsToFind the single(1) item to find and return
	 * @return found a collection with the found item
	 */
	public Collection find(ArrayList<Item> itemsToFind) {	//search for 1 item
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

	/**
	 * (should) find all items that include all the tags in a given arraylist
	 * @param tagsToFind the potential multiple tags to find and return
	 * @return found a collection with all items that have the tags
	 */
	public Collection containsTags(ArrayList<Tag> tagsToFind) {	//return a list of tags
		Collection found = new Collection();
		for(Item eachItem : contents) {
			for(Tag eachTag : tagsToFind) {
				if(eachItem.getTags().contains(eachTag)) {
					try {
						found.addItem(new Item(eachItem.getValue()));
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

	/**
	 * creates an array of items that have certain tags and returns the array
	 * @param tagsToFind an array list with the tags to find
	 * @return an array with all the items
	 */
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

	// converts collection to a string
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
