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

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import finalproject.Collection.ItemEnteredTwiceException;
import finalproject.Item.TagEnteredTwiceException;

/**
 * @author stephenpolson
 *
 */
public class Driver2 {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws TagEnteredTwiceException, ItemEnteredTwiceException, IOException, ClassNotFoundException {
		
			Item gso = new Item("Poecilotheria Metallica");
			gso.setNote("This Old World tarantula is the only known blue species of the Poecilotheria genus.");
			
			gso.setType("Tarantula");
			BufferedImage blueTarantulaImg;
			String fileName = "GootySapphireOrn.jpg";
			blueTarantulaImg = ImageIO.read(new File(fileName));
			
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
			
			bugsTest.saveCollection();
			
			String newCollectionName = "bugsSavedThenRetrieved";
			Collection bugsSavedThenRetrieved = bugsTest.readCollection("DatabaseFiles" + File.separator + "bugsTest");
			
			bugsSavedThenRetrieved.setName(newCollectionName);
			
			System.out.println(bugsSavedThenRetrieved);
			}

}
