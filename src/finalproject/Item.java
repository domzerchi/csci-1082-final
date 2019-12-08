package finalproject;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;

public class Item {

	/**
		 * @author stephenpolson
		 *
		 */
	private String value;//value = name
	private String note;
	private String type;
	private ArrayList<Tag> tags;
	private BufferedImage img;
	
	/**
	 * We will sort tags before displaying, accessing, etc., but if tags is already sorted, we won't bother.
	 */
	private boolean isKnownToBeSorted = false;
	//TODO image array
	
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
		
		
		
	//TODO image array
		return info;
	}
	
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
