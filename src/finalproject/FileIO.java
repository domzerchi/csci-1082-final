/**
 * 
 */
package finalproject;

/**
 * @author stephenpolson
 * code for choosing a file or directory
 *
 */
import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileIO extends JPanel {
	
	private JFileChooser chooser;
	private Component frame;
	ArrayList<Item> list = new ArrayList<>();
	
	/**
	 * baseDirectory will be the current working directory (where the program is)
	 * This could be changed for example: just "user.dir" to put it at a level higher than
	 * the directory folder
	 */
	public static final String BASE_DIRECTORY = System.getProperty("user.dir") + File.separator + "database";
	

	/**
	 * choose a file to open.
	 * @return 
	 */
	public ArrayList<Item> browse() {
	    chooser = new JFileChooser(BASE_DIRECTORY);
	    FileNameExtensionFilter filter = new FileNameExtensionFilter("Takes text files", "txt");
	    chooser.setFileFilter(filter);
	    int returnVal = chooser.showOpenDialog(frame);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	    	readFrom(chooser.getSelectedFile().getName());
	    }
	    return list;
	}
	
	public ArrayList<Item> readFrom(String fName) {
		Scanner myFile = null;
		try {
			myFile = new Scanner(new FileInputStream(fName));
			while(myFile.hasNextLine()) {
				String line = myFile.nextLine();
				String[] tokens = line.split("#%");
				
				Item item = new Item(tokens[0]);
				String type;
				String note;
				if (tokens.length > 1) {
					type = tokens[1];	
					item.setType(type);
				}
				if (tokens.length > 2) {
					note = tokens[2].replace("&%", "\n");
					item.setNote(note);
				}
				if (tokens.length > 3) {
					for (int i = 3; i < tokens.length; i++) {
						item.addTag(tokens[i]);
					}
				}
				list.add(item);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(myFile != null) 
				myFile.close();
		}
		return list;
	}
	
//	System.out.println(test.replaceAll(System.lineSeparator(),","));
	
	public void writeTo(String name, ArrayList<Item> clxn) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileOutputStream(name + ".txt"));
			for(Item i: clxn) {
				String str = i.getName() + "#%"
						+ i.getType() + "#%";
				// get note
				String temp = i.getNote();
				temp = temp.replace("\n", "&%");
				str += temp;
				for (Tag t: i.getTags()) {
					str += t.getTag();
					str += "#%";
				}
				pw.println(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		pw.close();
	}
}
