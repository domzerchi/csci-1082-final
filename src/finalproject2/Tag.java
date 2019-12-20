/**
 * a Tag class with a name
 * @author Stephen Polson
 * @author Ayden Sinn
 */
package finalproject2;

import java.io.Serializable;
import java.util.Comparator;

public class Tag implements Serializable {

	private String name;

	public Tag() {
		super();
	}

	/**
	 * The value of the variable name is essentially the Tag
	 */
	public Tag(String name) {
		super();
		this.name = name;
	}

	/**
	 * @return Tag.name
	 */
	public String getTag() {
		return new String(name);
	}
	
	/**
	 * Actually sets Tag.name
	 * @param name
	 */
	public void setTag(String name) {
		this.name = name;
	}

	/**
	 * Because the Tag is essentially the value of the variable name, equals() should
	 * return true as long as name matches.
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
	
//  Commenting hashCode() out until I understand it. Ayden can restore this if 
//  she understands it
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		return result;
//	}
	
	public static Comparator<Tag> CompareByTag = new Comparator<Tag>() {
		@Override
		public int compare(Tag o1, Tag o2) {
			return o1.getTag().compareToIgnoreCase(o2.getTag());
		}
	};
}
