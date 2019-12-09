package finalproject;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.FlowLayout;
import javax.swing.border.LineBorder;

public class GuiSearch extends JFrame implements ActionListener {

	private JFrame frame;
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
	
	private JButton ClxnBtn;
	private JTextField addItemFld;
	private JPanel searchPnl;
	private JLabel searchLbl;
	private JPanel itemPnl;
	private JLabel itemLbl;
	private JPanel tagPnl;
	private JPanel tagsPnl;
	private JLabel tagLbl;
	Collection data = new Collection("data");
	ArrayList<JButton> items = new ArrayList<>();
	ArrayList<JButton> tags = new ArrayList<>();
	
	private boolean nameX = true;
	private boolean tagX = false;
	private boolean imgX = false;
	private JButton newItemBtn;
	private JPanel displayPnl;
	
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
		editPnl.setPreferredSize(new Dimension(200, 100));
		frame.getContentPane().add(editPnl, BorderLayout.EAST);
		editPnl.setLayout(new BorderLayout(0, 0));
		
		settingsPnl = new JPanel();
		settingsPnl.setBorder(new LineBorder(new Color(0, 0, 0)));
		settingsPnl.setBackground(Color.WHITE);
		editPnl.add(settingsPnl, BorderLayout.NORTH);
		settingsPnl.setLayout(new GridLayout(6, 0, 0, 0));
		
		titleLbl = new JLabel(data.getName());
		titleLbl.setBackground(Color.WHITE);
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		settingsPnl.add(titleLbl);
		
		searchPnl = new JPanel();
		searchPnl.setBackground(Color.WHITE);
		settingsPnl.add(searchPnl);
		searchPnl.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		searchLbl = new JLabel("Search");
		searchPnl.add(searchLbl);
		
		searchFld = new JTextField();
		searchPnl.add(searchFld);
		searchFld.setForeground(Color.BLACK);
		searchFld.setColumns(10);
		
		toggleSearchPnl = new JPanel();
		toggleSearchPnl.setBackground(Color.WHITE);
		settingsPnl.add(toggleSearchPnl);
		
		searchByLbl = new JLabel("Search by:");
		toggleSearchPnl.add(searchByLbl);
		
		nameChkbx = new JCheckBox("Name");
		nameChkbx.setSelected(true);
		nameChkbx.setBackground(Color.WHITE);
		toggleSearchPnl.add(nameChkbx);
		
		tagChkbx = new JCheckBox("Tag");
		tagChkbx.setBackground(Color.WHITE);
		toggleSearchPnl.add(tagChkbx);
		
		toggleImgChkbx = new JCheckBox("Show Images");
		toggleImgChkbx.setBackground(Color.WHITE);
		settingsPnl.add(toggleImgChkbx);
		
		itemPnl = new JPanel();
		itemPnl.setBackground(Color.WHITE);
		settingsPnl.add(itemPnl);
		
		itemLbl = new JLabel("Add Item");
		itemPnl.add(itemLbl);
		
		addItemFld = new JTextField();
		itemPnl.add(addItemFld);
		addItemFld.setForeground(Color.BLACK);
		addItemFld.setColumns(10);
		
		tagPnl = new JPanel();
		tagPnl.setBackground(Color.WHITE);
		settingsPnl.add(tagPnl);
		
		tagLbl = new JLabel("Add Tag");
		tagPnl.add(tagLbl);
		
		addTagFld = new JTextField();
		tagPnl.add(addTagFld);
		addTagFld.setForeground(Color.BLACK);
		addTagFld.setColumns(10);
		
		tagsPnl = new JPanel();
		tagsPnl.setBorder(new LineBorder(new Color(0, 0, 0)));
		tagsPnl.setBackground(Color.WHITE);
		editPnl.add(tagsPnl, BorderLayout.CENTER);
		
		filePnl = new JPanel();
		editPnl.add(filePnl, BorderLayout.SOUTH);
		filePnl.setLayout(new GridLayout(1, 0, 0, 0));
		
		ClxnBtn = new JButton("Create/Open Database...");
		filePnl.add(ClxnBtn);
		
		displayPnl = new JPanel(); // not scrollable because I am not smart
		frame.getContentPane().add(displayPnl, BorderLayout.CENTER);
		FlowLayout flowLayout = (FlowLayout) displayPnl.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		displayPnl.setBorder(new LineBorder(new Color(0, 0, 0)));
		displayPnl.setBackground(Color.WHITE);
		
		frame.setBounds(0, 0, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		setActionListener();
	}
	
	private void setActionListener() {
		searchFld.addActionListener(this);
		nameChkbx.addActionListener(this);
		tagChkbx.addActionListener(this);
		toggleImgChkbx.addActionListener(this);
		addItemFld.addActionListener(this);
		addTagFld.addActionListener(this);
		ClxnBtn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == searchFld) {
			search();
		} else if (event.getSource() == nameChkbx) {
			checkBox(nameX);
		} else if (event.getSource() == tagChkbx) {
			checkBox(tagX);
		} else if (event.getSource() == toggleImgChkbx) {
			checkBox(imgX);
		} else if (event.getSource() == addItemFld) {
			addItem();
		} else if (event.getSource() == addTagFld) {
			addTag();
		} else if (event.getSource() == ClxnBtn) {
			fileChooser();
		} else {
			checkTags(event);
			checkItems(event);
		}
	}

	private void search() {
		searchFld.setText("");
	}

	private void checkBox(boolean x) {
		if (x == false)
			x = true;
		else
			x = false;
	}
	
	private void addItem() {
		newItemBtn = new JButton(addItemFld.getText());
		newItemBtn.setPreferredSize(new Dimension(100, 100));
		displayPnl.add(newItemBtn);
		displayPnl.revalidate();
		newItemBtn.addActionListener(this);
		items.add(newItemBtn);
		addItemFld.setText("");
	}
	
	private void addTag() {
		if (!addTagFld.getText().equals("")) {
		JButton newTagBtn = new JButton(addTagFld.getText());
		tagsPnl.add(newTagBtn);
		tagsPnl.revalidate();
		newTagBtn.addActionListener(this);
		tags.add(newTagBtn);
		addTagFld.setText("");
		}
	}
	
	private void fileChooser() { 
		// don't know how to do thingsssss
	}
	
	private void checkTags(ActionEvent event) {
		for (JButton tag: tags) {
			if (event.getSource() == tag) {
				tagsPnl.remove(tag);
				tagsPnl.revalidate();
				tagsPnl.repaint();
				break;
			}
		}
	}
	
	private void checkItems(ActionEvent event) {
		for (JButton item: items) {
			if ( event.getSource() == item) {
				EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GuiItem window = new GuiItem();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			}
		}
	}
	
}