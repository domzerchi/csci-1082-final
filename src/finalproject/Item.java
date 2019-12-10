package finalproject;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Item implements Serializable {

	/**
		 * @author stephenpolson
		 *
		 */
	private String value;//value = name
	private String note;
	private String type;
	private ArrayList<Tag> tags;
	private transient BufferedImage img;
	
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * We will sort tags before displaying, accessing, etc., but if tags is already sorted, we won't bother.
	 */
	private boolean isKnownToBeSorted = false;
	
	/**
	 * 
	 */
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item(String name) {
		this.value = name;
		tags = new ArrayList<Tag>();
	}
	
	public Item(String name, int initialSize) {
		this.value = name;
		tags = new ArrayList<Tag>(initialSize);
	}
	
	public String getName() {
		return value;
	}
	public void setName(String name) {
		this.value = name;
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
	
	public boolean deleteTag(Tag tag) {
		return tags.remove(tag);
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
	
public static Comparator<Item> CompareByValue = new Comparator<Item>() {
		
		@Override
		public int compare(Item o1, Item o2) {
			return o1.getValue().compareTo(o2.getValue());
		}
	};
	
@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

/**
	 * @return the img
	 */
	public BufferedImage getImg() {
		return img;
	}

	/**
	 * @param img the img to set
	 */
	public void setImg(BufferedImage img) {
		this.img = img;
	}

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
