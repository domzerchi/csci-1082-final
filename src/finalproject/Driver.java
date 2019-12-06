package finalproject;

import java.util.ArrayList;

import finalproject.Collection.ItemEnteredTwiceException;
import finalproject.Item.TagEnteredTwiceException;

public class Driver {
	public static void main(String[] args) throws TagEnteredTwiceException, ItemEnteredTwiceException {
	
		/**
		 * Launch the application.
		 */
//			EventQueue.invokeLater(new Runnable() {
//				public void run() {
//					try {
//						GuiSearch window = new GuiSearch();
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
//			});
		
		Item gso = new Item("Poecilotheria Metallica");
		gso.setNote("This Old World tarantula is the only known blue species of the Poecilotheria genus.");
		
		gso.setType("Tarantula");
		
		gso.addTag(new Tag("Old World"));
		gso.addTag(new Tag("Arachnid"));
		gso.addTag(new Tag("Ornamental"));
		gso.addTag(new Tag("Blue"));
		
		System.out.println(gso.toString());
		System.out.println("\n");
		
		Item another = new Item("Poecilotheria someOtherSpecies");
		another.setNote("I don't know anything about bugs");
		
		another.setType("Tarantula");
		
		Tag ornamental = new Tag("Ornamental");
		Tag blue = new Tag("Blue");
		
		Tag fake = new Tag("Ornamental");
		
		another.addTag(new Tag("Old World"));
		another.addTag(new Tag("Arachnid"));
		another.addTag(ornamental);
		another.addTag(blue);
		try {
			another.addTag(fake);
		}
		catch(TagEnteredTwiceException e) {
			System.out.println("\nTag" + fake.toString() + " has already been added!\n");
		}
		
		System.out.println(another.toString());
		System.out.println("\n");
		
		another.deleteTag(new Tag("Blue"));
		another.deleteTag(blue);
		
		System.out.println(another.toString());
		System.out.println("\n");
		
		another.setName("ActuallyIDon'tKnowGenus norDoIKnowSpecies");
		another.setNote("Just testing...");
		ArrayList<Tag> differentTags = new ArrayList<Tag>(2);
		differentTags.add(ornamental);
		differentTags.add(blue);
		
		another.setTags(differentTags);
		
		Collection bugs = new Collection("bugs");
		bugs.addItem(gso);
		bugs.addItem(another);
		
		System.out.println(bugs.toString());
		System.out.println("\n");
		
		if(bugs.deleteItem(new Item("Poecilotheria Metallica")) == false) System.out.println("Item not found!");
		else System.out.println(bugs.toString());
		
		
	}
}
