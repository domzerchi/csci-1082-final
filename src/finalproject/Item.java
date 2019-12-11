package finalproject;

//All classes within Collection need to be serializable in order for reading/writing of databases to work
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Item implements Serializable {

	/**
	 * @author stephenpolson
	 */
	private String name;
	private String note;
	private String type;
	private ArrayList<Tag> tags;
	// We will sort tags before displaying, accessing, etc., but if tags is already sorted, we won't bother.
	private boolean isKnownToBeSorted = false;


	public String getValue() {
		return name;
	}

	/**
	 * constructor for an item.
	 * Items will only ever be created with just a name,
	 * so there's only one constructor.
	 * @param name the name of the item
	 */
	public Item(String name) {
		this.name = name;
		tags = new ArrayList<Tag>();
	}

	// accessors and mutators
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * accessor for tags
	 * @return the tags
	 */
	//TODO probably make a deep copy
	public ArrayList<Tag> getTags() {
		if(!isKnownToBeSorted) {
			Collections.sort(tags, Tag.CompareByValue);
			isKnownToBeSorted = true;
		}
		return tags;
	}

	/**
	 * mutator for tags
	 * @param tags the tags to set
	 */
	public void setTags(ArrayList<Tag> tags) {
		this.tags = tags;
		Collections.sort(tags, Tag.CompareByValue);
		isKnownToBeSorted = true;
	}

	/**
	 * @param newTag the tag to add to tags
	 * @throws TagEnteredTwiceException 
	 * if tags already contains newTag, do nothing and throw exception
	 */
	public void addTag(Tag newTag) throws TagEnteredTwiceException {
		if(tags.contains(newTag)) {
			throw new TagEnteredTwiceException();
		}else {
			tags.add(newTag);
			isKnownToBeSorted=false;
		}
	}

	/**
	 * attempt to delete a tag then return the results.
	 * @param tag the potential tag to be deleted
	 * @return whether or not the tag was successfully removed
	 */
	public boolean deleteTag(Tag tag) {
		return tags.remove(tag);
	}

	public ArrayList<Tag> find(ArrayList<Tag> tagsToFind) {
		ArrayList<Tag> found = new ArrayList<Tag>();
		for(Tag element : tagsToFind) {
			if(tags.contains(element)) {
				found.add(element);
			}
		}
		return found;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	// returns an item's list of variables in a string
	@Override
	public String toString() {
		String info = "Item: " + getName();
		if(type != null) {
			info += "\nType: " + getType();
		}
		if(note != null) {
			info += "\nNotes: " + getNote();
		}
		if(!isKnownToBeSorted) {
			Collections.sort(tags, Tag.CompareByValue);
			isKnownToBeSorted = true;
		}
		info += "\nTags:";
		for(int i = 0; i < tags.size(); i++) {

			info += "\n" + tags.get(i).toString();
		}
		return info;
	}

	// tests that two item's names are the same
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public static Comparator<Item> CompareByValue = new Comparator<Item>() {
		@Override
		public int compare(Item o1, Item o2) {
			return o1.getValue().compareTo(o2.getValue());
		}
	};
	
	public class TagEnteredTwiceException extends Exception {

		private static final long serialVersionUID = 1L;

		public TagEnteredTwiceException() {
			super("That Tag has already been added!");
		}

		/**
		 * @param message
		 */
		public TagEnteredTwiceException(String message) {
			super(message);
		}
	}	

}
