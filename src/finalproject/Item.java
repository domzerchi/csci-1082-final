package finalproject;

import java.util.ArrayList;
import java.util.Collections;

public class Item {

	private String name;
	private String note;
	private String type;
	private ArrayList<Tag> tags;
	// image array
	
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
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(ArrayList<Tag> tags) {
		this.tags = tags;
		Collections.sort(tags, Tag.CompareByValue);
	}

	/**
	 * @param newTag the tag to add to tags
	 * if tags already contains newTag, do nothing
	 */
	public void addTag(Tag newTag) {
		if(!tags.contains(newTag)) {
			tags.add(newTag);
			Collections.sort(tags, Tag.CompareByValue);
		}
	}
	
	public void deleteTag(Tag tag) {
		tags.remove(tag);
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
			
				info += "\n" + tags.get(i).getValue();
			
		}
	// image array
		return info;
	}
	
	
	
}
