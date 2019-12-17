/**
 * 
 */
package finalproject;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import finalproject.Collection.ItemEnteredTwiceException;
import finalproject.Item.TagEnteredTwiceException;

/**
 * @author stephenpolson
 *
 */
public class Driver2 {
	public static void main(String[] args) throws TagEnteredTwiceException, ItemEnteredTwiceException, IOException, ClassNotFoundException {
		
			Item gso = new Item("Poecilotheria Metallica");
			gso.setNote("This Old World tarantula is the only known blue species of the Poecilotheria genus.");
			
			gso.setType("Tarantula");
			gso.addTag(new Tag("Old World"));
			gso.addTag(new Tag("Arachnid"));
			gso.addTag(new Tag("Ornamental"));
			gso.addTag(new Tag("Blue"));
			
			Item another = new Item("Poecilotheria someOtherSpecies");
			another.setNote("I don't know anything about bugs");
			
			another.setType("Tarantuloid");
			
			Tag ornamental = new Tag("Anything but Ornamental");
			Tag notBlue = new Tag("Not Blue");
			
			another.addTag(new Tag("New World"));
			another.addTag(new Tag("Pseudo-Arachnid"));
			another.addTag(ornamental);
			another.addTag(notBlue);
			
			Collection bugsTest = new Collection("bugsTest");
			bugsTest.addItem(gso);
			bugsTest.addItem(another);
			
			System.out.println(bugsTest.toString());
			System.out.println("\n");
			
			
			//This should return the item gso since it has the same name as the item we are
			//looking for
			Item shouldBeFound = bugsTest.find(new Item("Poecilotheria Metallica"));
			if(shouldBeFound != null) 
				System.out.println("found: " + shouldBeFound.toString() + "\n");
			else 
				System.out.println("not found" + "\n");
			
			Item shouldNotBeFound = bugsTest.find(new Item("Poeci;ttped"));
			if(shouldNotBeFound != null)
				System.out.println("found: " + shouldNotBeFound.toString() + "\n");
			else
				System.out.println("not found" + "\n");
			
			ArrayList<Tag>tagsToFind = new ArrayList<Tag>();
			tagsToFind.add(new Tag("Ornamental"));
			tagsToFind.add(new Tag("Blue"));
			tagsToFind.add(new Tag("Old World"));
			tagsToFind.add(new Tag("New World"));
			tagsToFind.add(new Tag("Anything But Ornamental"));
			tagsToFind.add(new Tag("Not Blue"));
			tagsToFind.add(new Tag("huh"));
			tagsToFind.add(new Tag("Bee"));
			ArrayList<Tag>foundTags = new ArrayList<Tag>();
			foundTags = bugsTest.containsTags(tagsToFind);
			
			System.out.println("Tags found: " + foundTags + "\n");
			
			
			bugsTest.saveCollection();
			
			String newCollectionName = "bugsSavedThenRetrieved";
			Collection bugsSavedThenRetrieved = bugsTest.readCollection("database" + File.separator + "bugsTest");
			
			bugsSavedThenRetrieved.setName(newCollectionName);
			
			System.out.println(bugsSavedThenRetrieved);
			}

}
