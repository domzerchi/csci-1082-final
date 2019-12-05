package finalproject;

import java.util.ArrayList;

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
	}

	/**
	 * @param tag the tag to add to tags
	 */
	public void addTag(Tag newTag) {
		tags.add(newTag);
	}
	
	public void deleteTag(Tag tag) {
		for(int i = 0; i < tags.size(); i++) {
			
			if(tags.get(i).equals(tag)) {
				tags.remove(i);
			}
			
		}
	}

	@Override
	public String toString() {
		String indentStr = "";
		String info = "Item: " + name;
		if(type != null) {
			info += "\nType: " + type;
		}
		if(note != null) {
			info += "\nNotes: " + note;
		}
		info += "\nTags:";
		for(int i = 0; i < tags.size(); i++) {
			
				info += "\n" + tags.get(i).getValue();
			
		}
	// image array
		return info;
	}
	
	
	
}
