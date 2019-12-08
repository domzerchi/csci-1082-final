package finalproject;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class GuiSearch extends JFrame implements ActionListener {

	private JFrame frame;
	
	private JPanel DisplayPanel;
	private JPanel editPnl;
	private JPanel toggleSearchPnl;
	private JPanel settingsPnl;
	private JPanel filePnl;
	
	private JLabel titleLbl;
	private JLabel searchByLbl;
	
	private JTextField searchFld;
	private JTextField addTagFld;
	
	private JCheckBox nameChkbx;
	private JCheckBox tagChkbx;
	private JCheckBox toggleImgChkbx;
	
	private JButton newClxnBtn;
	private JButton openClxnBtn;
	private JTextField newItemFld;
	private JPanel searchPnl;
	private JLabel searchLbl;
	private JPanel itemPnl;
	private JLabel itemLbl;
	private JPanel panel;
	private JPanel tagPnl;

	private JScrollPane scrollPane;
	
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
		
		settingsPnl = new JPanel();
		editPnl.add(settingsPnl, BorderLayout.NORTH);
		settingsPnl.setLayout(new GridLayout(6, 0, 0, 0));
		
		titleLbl = new JLabel("*database*");
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		settingsPnl.add(titleLbl);
		
		searchPnl = new JPanel();
		settingsPnl.add(searchPnl);
		searchPnl.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		searchLbl = new JLabel("Search");
		searchPnl.add(searchLbl);
		
		searchFld = new JTextField();
		searchPnl.add(searchFld);
		searchFld.setForeground(Color.BLACK);
		searchFld.setColumns(10);
		
		toggleSearchPnl = new JPanel();
		settingsPnl.add(toggleSearchPnl);
		
		searchByLbl = new JLabel("Search by:");
		toggleSearchPnl.add(searchByLbl);
		
		nameChkbx = new JCheckBox("Name");
		toggleSearchPnl.add(nameChkbx);
		
		tagChkbx = new JCheckBox("Tag");
		toggleSearchPnl.add(tagChkbx);
		
		toggleImgChkbx = new JCheckBox("Show Images");
		settingsPnl.add(toggleImgChkbx);
		
		itemPnl = new JPanel();
		settingsPnl.add(itemPnl);
		
		itemLbl = new JLabel("Add Item");
		itemPnl.add(itemLbl);
		
		newItemFld = new JTextField();
		itemPnl.add(newItemFld);
		newItemFld.setForeground(Color.BLACK);
		newItemFld.setColumns(10);
		
		panel = new JPanel();
		settingsPnl.add(panel);
		
		addTagFld = new JTextField();
		panel.add(addTagFld);
		addTagFld.setForeground(Color.LIGHT_GRAY);
		addTagFld.setText("Add Tag");
		addTagFld.setColumns(10);
		
		tagPnl = new JPanel();
		editPnl.add(tagPnl, BorderLayout.CENTER);
		scrollPane = new JScrollPane();
		tagPnl.add(scrollPane);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
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
		setActionListener();
	}

	private void setActionListener() {
		searchFld.addActionListener(this);
		addTagFld.addActionListener(this);
		nameChkbx.addActionListener(this);
		tagChkbx.addActionListener(this);
		toggleImgChkbx.addActionListener(this);
		newClxnBtn.addActionListener(this);
		openClxnBtn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == searchFld) {
			
		} else if (event.getSource() == addTagFld) {
			
		} else if (event.getSource() == nameChkbx) {
			
		} else if (event.getSource() == tagChkbx) {
			
		} else if (event.getSource() == toggleImgChkbx) {
			
		} else if (event.getSource() == newClxnBtn) {
			
		} else if (event.getSource() == openClxnBtn) {
			
		}
	}
	
}
