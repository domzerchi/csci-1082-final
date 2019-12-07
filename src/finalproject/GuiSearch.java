package finalproject;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class GuiSearch {

	private JFrame frame;
	private JPanel DisplayPanel;
	private JPanel editPnl;
	private JLabel titleLbl;
	private JTextField searchFld;
	private JPanel toggleSearchPnl;
	private JLabel searchByLbl;
	private JCheckBox nameChkbx;
	private JCheckBox tagChkbx;
	private JCheckBox toggleImgChkbx;
	private JPanel searchPnl;
	private JPanel tagPnl;
	private JTextField addTagFld;
	private JPanel addedTagsPnl;
	private JPanel filePnl;
	private JButton newClxnBtn;
	private JButton openClxnBtn;

	/**
	 * Create the application.
	 */
	public GuiSearch() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		editPnl = new JPanel();
		frame.getContentPane().add(editPnl, BorderLayout.EAST);
		editPnl.setLayout(new BorderLayout(0, 0));
		
		searchPnl = new JPanel();
		editPnl.add(searchPnl, BorderLayout.NORTH);
		searchPnl.setLayout(new GridLayout(4, 0, 0, 0));
		
		titleLbl = new JLabel("*database*");
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		searchPnl.add(titleLbl);
		
		searchFld = new JTextField();
		searchPnl.add(searchFld);
		searchFld.setColumns(10);
		
		toggleSearchPnl = new JPanel();
		searchPnl.add(toggleSearchPnl);
		
		searchByLbl = new JLabel("Search by:");
		toggleSearchPnl.add(searchByLbl);
		
		nameChkbx = new JCheckBox("Name");
		toggleSearchPnl.add(nameChkbx);
		
		tagChkbx = new JCheckBox("Tag");
		toggleSearchPnl.add(tagChkbx);
		
		toggleImgChkbx = new JCheckBox("Show Images");
		searchPnl.add(toggleImgChkbx);
		
		tagPnl = new JPanel();
		editPnl.add(tagPnl, BorderLayout.CENTER);
		tagPnl.setLayout(new BorderLayout(0, 0));
		
		addTagFld = new JTextField();
		tagPnl.add(addTagFld, BorderLayout.NORTH);
		addTagFld.setColumns(10);
		
		addedTagsPnl = new JPanel();
		tagPnl.add(addedTagsPnl);
		
		filePnl = new JPanel();
		editPnl.add(filePnl, BorderLayout.SOUTH);
		filePnl.setLayout(new GridLayout(2, 0, 0, 0));
		
		newClxnBtn = new JButton("Create New Database");
		filePnl.add(newClxnBtn);
		
		openClxnBtn = new JButton("Open Existing Database");
		filePnl.add(openClxnBtn);
		
		DisplayPanel = new JPanel();
		DisplayPanel.setBackground(Color.WHITE);
		frame.getContentPane().add(DisplayPanel, BorderLayout.CENTER);
		frame.setBounds(0, 0, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
