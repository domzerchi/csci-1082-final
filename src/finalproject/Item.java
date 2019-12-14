package finalproject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Item implements Serializable {

	/**
	 * @author stephenpolson
	 * @author ayden sinn
	 */
	
	private String name;
	private String note;
	private String type;
	private ArrayList<Tag> tags;
//	// We will sort tags before displaying, accessing, etc., but if tags is already sorted, we won't bother.
//	private boolean isSorted = false;

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
	 * @return tags
	 */ // create deep copy?
	public ArrayList<Tag> getTags() {
		return tags;
	}
//	public void setTag (int index, String name) { // is this necessary at all?
//		Tag tag = new Tag(name);
//		tags.set(index, tag);
//		Collections.sort(tags, Tag.CompareByTag);
//	}
	public boolean addTag(String name) {
		Tag tag = new Tag(name);
		if (!tags.contains(tag)) {
			if (tags.add(tag)) {
				Collections.sort(tags, Tag.CompareByTag);
				return true;
			}
		}
		return false;
	}
	public boolean removeTag(String name) {
		Tag tag = new Tag(name);
		if (tags.remove(tag)) {
			Collections.sort(tags, Tag.CompareByTag);
			return true;
		} else {
			return false;
		}
	}
	public ArrayList<Tag> findTags (ArrayList<Tag> tagsToFind) {
		ArrayList<Tag> found = new ArrayList<Tag>();
		for(Tag element : tagsToFind) {
			if(tags.contains(element)) {
				found.add(element);
			}
		}
		Collections.sort(found, Tag.CompareByTag);
		return found;
	}

	@Override
	public String toString() {
		String info = "Item: " + getName();
		if(type != null) {
			info += "\nType: " + getType();
		}
		if(note != null) {
			info += "\nNotes: " + getNote();
		}
		info += "\nTags:";
		for(int i = 0; i < tags.size(); i++) {
			info += "\n" + tags.get(i).toString();
		}
		return info;
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Item other = (Item) obj;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		return true;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	public static Comparator<Item> CompareByName = new Comparator<Item>() {
		@Override
		public int compare(Item o1, Item o2) {
			return o1.getName().compareToIgnoreCase(o2.getName());
		}
	};

	public static Comparator<Item> CompareByType = new Comparator<Item>() {
		@Override
		public int compare(Item o1, Item o2) {
			return o1.getType().compareToIgnoreCase(o2.getType());
		}
	};
	
	public class TagEnteredTwiceException extends Exception {
		private static final long serialVersionUID = 1L;
		public TagEnteredTwiceException() {
			super("That Tag has already been added!");
		}
		public TagEnteredTwiceException(String message) {
			super(message);
		}
	}	
}
