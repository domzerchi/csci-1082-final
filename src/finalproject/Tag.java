/**
 * a Tag class with a name
 * @author Stephen Polson
 * @author Ayden Sinn
 */
package finalproject;

import java.util.Comparator;

public class Tag {

	private String name;

	// constructor for a tag
	public Tag(String name) {
		super();
		this.name = name;
	}

	// accessor and mutator for tag
	public String getTag() {
		return name;
	}
	public void setTag(String name) {
		this.name = name;
	}

	/**
	 * equals() should return true as long as name matches.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj != null) {
			if (getClass() == obj.getClass()) {
				Tag other = (Tag) obj;	
				if (name.equals(other.name)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * returns the name of a tag
	 */
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
	}

