package finalproject;

public class Item {

	private String name;
	private String note;
	private String type;
	private Tag[] tags;
	private int numberOfTags;// that we currently have in our bag of tags
	// image array
	
	public Item(String name) {
		this.name = name;
		tags = new Tag[2];// TODO this is a pretty small default size, we would need to grow as needed
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
	public Tag[] getTags() {
		return tags;
	}
	public void setTags(Tag[] tags) {
		this.tags = tags;
	}
	public void addTag(Tag tag) {
		ensureTagsCapacity();
		tags[numberOfTags++] = tag;
	}

	/**
	 * Grow Tags[] capacity as needed
	 */
	private void ensureTagsCapacity() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		String info = "Item: " + name;
		if(type != null) {
			info += "\nType: " + type;
		}
		if(note != null) {
			info += "\nNotes: " + note;
		}
		info += "\nTags:";
		for(int i = 0; i < numberOfTags; i++) {
			if(tags[i] != null) {
				info += "\n" + tags[i].getValue();
			}
		}
	// image array
		return info;
	}
	
}
