package finalproject2;

import java.io.Serializable;
import java.util.ArrayList;

public class Collection implements Serializable {
	private String name;
	private ArrayList<Item> items;

	public Collection() {
		// TODO Auto-generated constructor stub
	}

	public Collection(String name) {
		super();
		this.name = name;
	}

	public Collection(String name, ArrayList<Item> items) {
		super();
		this.name = name;
		this.items = items;
	}

	public String getName() {
		return new String(name);
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Item> getItems() {
		ArrayList<Item> returnValue = new ArrayList<Item>();
		int size = items.size();
		for(int i = 0; i < size; i++) {
			returnValue.add(items.get(i));
		}
		return returnValue;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
	public boolean contains(Item itemToFind) {
		if(items.contains(itemToFind))
			return true;
		else
			return false;
	}
	
	public int deleteItem(Item itemToDelete) {
		//TODO
		return -1;
	}
	
	public boolean add(Item itemToAdd) {
		//TODO
		return false;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
