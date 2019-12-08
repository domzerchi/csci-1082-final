package finalproject;

import java.util.ArrayList;

import javax.imageio.ImageIO;

import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import finalproject.Collection.ItemEnteredTwiceException;
import finalproject.Item.TagEnteredTwiceException;

public class Driver {
	public static void main(String[] args) throws TagEnteredTwiceException, ItemEnteredTwiceException, IOException {
	
		/**
		 * Launch the application.
		 */
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GuiSearch window = new GuiSearch();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		
			Item gso = new Item("Poecilotheria Metallica");
			gso.setNote("This Old World tarantula is the only known blue species of the Poecilotheria genus.");
			
			gso.setType("Tarantula");
			BufferedImage blueTarantulaImg;
			blueTarantulaImg = ImageIO.read(new File("/Users/stephenpolson/git/csci-1082-final/GootySapphireOrn.jpg"));
			gso.setImg(blueTarantulaImg);
			
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
			
			Collection bugs = new Collection("bugs");
			bugs.addItem(gso);
			bugs.addItem(another);
			
			System.out.println(bugs.toString());
			System.out.println("\n");
	}
}
