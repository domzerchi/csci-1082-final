package finalproject;

import java.util.Comparator;

public class Tag {

	private String value;

	// constructor for a tag
	public Tag(String value) {
		super();
		this.value = value;
	}

	// accessor for value
	public String getValue() {
		return value;
	}
	// mutator for value
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	// tests whether or not two values are the same
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Tag other = (Tag) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	// returns value with a hash in front of it
	@Override
	public String toString() {
		return " #" + value;
	}

	public static Comparator<Tag> CompareByValue = new Comparator<Tag>() {

		@Override
		public int compare(Tag o1, Tag o2) {
			return o1.getValue().compareTo(o2.getValue());
		}
	};

}
