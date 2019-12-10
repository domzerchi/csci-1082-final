/**
 * 
 */
package finalproject;

/**
 * @author stephenpolson
 * code for choosing a file or directory
 *
 */
import java.io.*;
import java.io.FileFilter;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;

public class ChooseFile extends JPanel
implements ActionListener {
static private final String newline = "\n";
JButton openButton, saveButton;
JTextArea log;
JFileChooser fchoose;

/**
 * 
 */
public ChooseFile() {
super(new BorderLayout());

log = new JTextArea(5,20);
log.setMargin(new Insets(5,5,5,5));
log.setEditable(false);
JScrollPane logScrollPane = new JScrollPane(log);

String directory = System.getProperty("user.dir");//This will be the IDE current working directory if we are using Eclipse e.g.
fchoose = new JFileChooser(directory);//Probably later we will take out "directory" but for now we want to control where files are

fchoose.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

openButton = new JButton("Choose a Database File...");
openButton.addActionListener(this);

saveButton = new JButton("Choose Directory to Save to...");
saveButton.addActionListener(this);

JPanel buttonPanel = new JPanel(); //use FlowLayout
buttonPanel.add(openButton);
buttonPanel.add(saveButton);

add(buttonPanel, BorderLayout.PAGE_START);
add(logScrollPane, BorderLayout.CENTER);
}

public void actionPerformed(ActionEvent e) {

if (e.getSource() == openButton) {
	int returnVal = fchoose.showOpenDialog(ChooseFile.this);
	
	if (returnVal == JFileChooser.APPROVE_OPTION) {
		File file = fchoose.getSelectedFile();
		//This is where a real application would open the file.
		log.append("Opening: " + file.getName() + "." + newline);
} else {
		log.append("Open command cancelled by user." + newline);
}
	log.setCaretPosition(log.getDocument().getLength());

}else if (e.getSource() == saveButton) {
    int returnVal = fchoose.showSaveDialog(ChooseFile.this);
    if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = fchoose.getSelectedFile();
        //This is where a real application would save the file.
        log.append("Saving: " + file.getName() + "." + newline);
    } else {
        log.append("Save command cancelled by user." + newline);
    }
    log.setCaretPosition(log.getDocument().getLength());
}
}

/** Returns an ImageIcon, or null if the path was invalid. */
protected static ImageIcon createImageIcon(String path) {
java.net.URL imgURL = ChooseFile.class.getResource(path);
if (imgURL != null) {
return new ImageIcon(imgURL);
} else {
System.err.println("Couldn't find file: " + path);
return null;
}
}

/**
* Create the GUI and show it.  For thread safety,
* this method should be invoked from the
* event dispatch thread.
*/
private static void createAndShowGUI() {
//Create and set up the window.
JFrame frame = new JFrame("ChooseFile");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//Add content to the window.
frame.add(new ChooseFile());

//Display the window.
frame.pack();
frame.setVisible(true);
}

public static void main(String[] args) {
//Schedule a job for the event dispatch thread:
//creating and showing this application's GUI.
SwingUtilities.invokeLater(new Runnable() {
public void run() {
createAndShowGUI();
}
});
}
}