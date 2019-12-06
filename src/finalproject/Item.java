package finalproject;

import java.util.ArrayList;
import java.util.Collections;

public class Item {

	/**
		 * @author stephenpolson
		 *
		 */
	private String name;
	private String note;
	private String type;
	private ArrayList<Tag> tags;
	
	/**
	 * We will sort tags before displaying, accessing, etc., but if tags is already sorted, we won't bother.
	 */
	private boolean tagsIsKnownToBeSorted = false;
	//TODO image array
	
	public Item(String name) {
		this.name = name;
		tags = new ArrayList<Tag>(10);
	}
	
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
	 * @return the tags
	 */
	//TODO probably make a deep copy
	public ArrayList<Tag> getTags() {
		if(!tagsIsKnownToBeSorted) {
			Collections.sort(tags, Tag.CompareByValue);
			tagsIsKnownToBeSorted = true;
		}
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(ArrayList<Tag> tags) {
		this.tags = tags;
		Collections.sort(tags, Tag.CompareByValue);
		tagsIsKnownToBeSorted = true;
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
		
		if(!tagsIsKnownToBeSorted) {
			Collections.sort(tags, Tag.CompareByValue);
			tagsIsKnownToBeSorted = true;
		}
		info += "\nTags:";
		for(int i = 0; i < tags.size(); i++) {
			
				info += "\n" + tags.get(i).toString();
			
		}
		
		
		
	//TODO image array
		return info;
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
