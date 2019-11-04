package finalproject;

public class Item {

	private String name;
	private String note;
	private String type;
	private Tag[] tags;
	// image array
	
	public Item(String name) {
		this.name = name;
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
	
	@Override
	public String toString() {
		String info = "Item: " + name;
		if(type != null) {
			info += "\nType: " + type;
		}
		if(note != null) {
			info += "\nNotes: " + note;
		}
		// doesn't work correctly if there are no tags
		// (or at all since tags aren't set up right now)
//		info += "\nTags:";
//		for(int i = 0; i < tags.length; i++) {
//			if(tags[i] != null) {
//				info += "\n" + tags[i];
//			}
//		}
		return info;
	}
	
}
