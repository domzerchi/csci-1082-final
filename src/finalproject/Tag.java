package finalproject;

import java.io.Serializable;
import java.util.Comparator;

public class Tag implements Serializable {
	// in order for saving and opening collections to work, not only does Collection have to be serializable
	// but so do the classes in Collection
	private String name;

	// constructor for a tag
	public Tag(String name) {
		super();
		this.name = name;
	}

	public String getTag() {
		return name;
	}
	public void setTag(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Tag))
			return false;
		Tag tag = (Tag) obj;
		boolean isEqual = this.getTag().equals(tag.getTag());
		return isEqual;
	}

	@Override
	public String toString() {
		return getTag();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	public static Comparator<Tag> CompareByTag = new Comparator<Tag>() {
		@Override
		public int compare(Tag o1, Tag o2) {
			return o1.getTag().compareToIgnoreCase(o2.getTag());
		}
	};

}
