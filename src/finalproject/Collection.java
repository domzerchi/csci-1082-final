package finalproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

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
		}
	}
	
	public boolean deleteItem(Item itemToRemove) {
		return getContents().remove(itemToRemove);
	}
	
	public void saveCollection() throws IOException {
		String fileName=name+".ser";
		FileOutputStream fout = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(this);
		oos.close();
	}
	
	public Collection readCollection(String databaseToRead) throws FileNotFoundException, IOException, ClassNotFoundException {
		String fileName=databaseToRead+".ser";
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
		String info = "Collection " + name + "[contents=\n\n";
		for(int i = 0; i < getContents().size(); i++) {
			
			info += "\n\n" + getContents().get(i).toString();
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
