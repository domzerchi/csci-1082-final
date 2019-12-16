package finalproject;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class CollectionGUI extends JFrame implements ActionListener {

	private JFrame searchFrame;
	private JPanel cardPnl;
	private JPanel searchEditPnl;
	private JPanel searchByPnl;
	private JPanel searchSettingsPnl;
	private JPanel searchPnl;
	private JPanel searchItemPnl;
	private JPanel searchTagPnl;
	private JPanel tagsPnl;
	private JPanel displayPnl;
	private JPanel deleteItemPnl;
	private JLabel searchByLbl;
	private JLabel searchLbl;
	private JLabel itemLbl;
	private JLabel searchTagLbl;
	private JLabel deleteItemLbl;
	
	private JTextField searchFld;
	private JTextField searchTagFld;
	private JTextField addItemFld;
	private JTextField deleteItemFld;
	
	private JCheckBox nameChkbx;
	private JCheckBox tagChkbx;
	
	private JButton ClxnBtn;
	private JButton newItemBtn;
	
	private JPanel SearchGui;
	private JPanel ItemGui;
	private JPanel itemEditPnl;
	private JPanel itemSettingsPnl;
	private JButton backBtn;
	private JPanel typePnl;
	private JLabel typeLbl;
	private JTextField typeFld;
	private JPanel addTagPnl;
	private JLabel addTagLbl;
	private JTextField addTagFld;
	private JTextField nameFld;
	private JPanel panel;
	private JTextArea textArea;
	
	ArrayList<Item> collection = new ArrayList<>();
//	ArrayList<JButton> items = new ArrayList<>();
//	ArrayList<JButton> tags = new ArrayList<>();
	
	private boolean nameX = true;
	private boolean tagX = false;
	private JCheckBox typeChkbx;
	private JTextField clxnFld;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new CollectionGUI();
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public CollectionGUI() {
		initializeSearch();
		// initialize the displaypanel
//		for (int i = 0; i < this.data.getContents().size(); i++) {
//			newItemBtn = new JButton(data.getContents().get(i).getName());
//			newItemBtn.setPreferredSize(new Dimension(100, 100));
//			displayPnl.add(newItemBtn);
//			newItemBtn.addActionListener(this);
//			displayPnl.revalidate();
//			displayPnl.repaint();
//		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeSearch() {
		searchFrame = new JFrame();
		searchFrame.getContentPane().setLayout(new CardLayout(0, 0));
		
		SearchGui = new JPanel();
		searchFrame.getContentPane().add(SearchGui, "name_119297892460500");
		SearchGui.setLayout(new BorderLayout(0, 0));
		
		searchEditPnl = new JPanel();
		SearchGui.add(searchEditPnl, BorderLayout.EAST);
		searchEditPnl.setPreferredSize(new Dimension(250, 100));
		searchEditPnl.setLayout(new BorderLayout(0, 0));
		
		searchSettingsPnl = new JPanel();
		searchSettingsPnl.setBorder(new LineBorder(new Color(0, 0, 0)));
		searchEditPnl.add(searchSettingsPnl, BorderLayout.NORTH);
		searchSettingsPnl.setLayout(new GridLayout(7, 0, 0, 0));
		
		ClxnBtn = new JButton("Create/Open Collection...");
		searchSettingsPnl.add(ClxnBtn);
		
		clxnFld = new JTextField();
		clxnFld.setHorizontalAlignment(SwingConstants.CENTER);
		clxnFld.setText("placeholder");
		searchSettingsPnl.add(clxnFld);
		clxnFld.setColumns(10);
		
		searchPnl = new JPanel();
		searchPnl.setBackground(Color.WHITE);
		searchSettingsPnl.add(searchPnl);
		searchPnl.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		searchLbl = new JLabel("Search:");
		searchPnl.add(searchLbl);
		
		searchFld = new JTextField();
		searchPnl.add(searchFld);
		searchFld.setColumns(10);
		
		searchByPnl = new JPanel();
		searchByPnl.setBackground(Color.WHITE);
		searchSettingsPnl.add(searchByPnl);
		
		searchByLbl = new JLabel("Search by:");
		searchByPnl.add(searchByLbl);
		
		nameChkbx = new JCheckBox("Name");
		nameChkbx.setBackground(Color.WHITE);
		nameChkbx.setSelected(true);
		searchByPnl.add(nameChkbx);
		
		tagChkbx = new JCheckBox("Tag");
		tagChkbx.setBackground(Color.WHITE);
		searchByPnl.add(tagChkbx);
		
		typeChkbx = new JCheckBox("Type");
		typeChkbx.setBackground(Color.WHITE);
		searchByPnl.add(typeChkbx);
		
		deleteItemPnl = new JPanel();
		deleteItemPnl.setBackground(Color.WHITE);
		FlowLayout flowLayout_1 = (FlowLayout) deleteItemPnl.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		searchSettingsPnl.add(deleteItemPnl);
		
		deleteItemLbl = new JLabel("Delete Item:");
		deleteItemPnl.add(deleteItemLbl);
		
		deleteItemFld = new JTextField();
		deleteItemPnl.add(deleteItemFld);
		deleteItemFld.setColumns(10);
		
		searchItemPnl = new JPanel();
		searchItemPnl.setBackground(Color.WHITE);
		FlowLayout fl_searchItemPnl = (FlowLayout) searchItemPnl.getLayout();
		fl_searchItemPnl.setAlignment(FlowLayout.RIGHT);
		searchSettingsPnl.add(searchItemPnl);
		
		itemLbl = new JLabel("Add Item:");
		searchItemPnl.add(itemLbl);
		
		addItemFld = new JTextField();
		searchItemPnl.add(addItemFld);
		addItemFld.setColumns(10);
		
		searchTagPnl = new JPanel();
		searchTagPnl.setBackground(Color.WHITE);
		FlowLayout fl_searchTagPnl = (FlowLayout) searchTagPnl.getLayout();
		fl_searchTagPnl.setAlignment(FlowLayout.RIGHT);
		searchSettingsPnl.add(searchTagPnl);
		
		searchTagLbl = new JLabel("Add Tag:");
		searchTagPnl.add(searchTagLbl);
		
		searchTagFld = new JTextField();
		searchTagPnl.add(searchTagFld);
		searchTagFld.setColumns(10);
		
		tagsPnl = new JPanel();
		tagsPnl.setBorder(new LineBorder(new Color(0, 0, 0)));
		tagsPnl.setBackground(Color.WHITE);
		searchEditPnl.add(tagsPnl, BorderLayout.CENTER);
		
		displayPnl = new JPanel(); // not scrollable because I am not smart
		SearchGui.add(displayPnl, BorderLayout.CENTER);
		displayPnl.setBorder(new LineBorder(new Color(0, 0, 0)));
		displayPnl.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) displayPnl.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		ItemGui = new JPanel();
		searchFrame.getContentPane().add(ItemGui, "name_119525656447200");
		ItemGui.setLayout(new BorderLayout(0, 0));
		
		itemEditPnl = new JPanel();
		itemEditPnl.setPreferredSize(new Dimension(250, 100));
		ItemGui.add(itemEditPnl, BorderLayout.EAST);
		itemEditPnl.setLayout(new BorderLayout(0, 0));
		
		itemSettingsPnl = new JPanel();
		itemEditPnl.add(itemSettingsPnl, BorderLayout.NORTH);
		itemSettingsPnl.setLayout(new GridLayout(4, 0, 0, 0));
		
		backBtn = new JButton("Back to Search");
		itemSettingsPnl.add(backBtn);
		
		nameFld = new JTextField();
		itemSettingsPnl.add(nameFld);
		nameFld.setColumns(10);
		
		typePnl = new JPanel();
		typePnl.setBackground(Color.WHITE);
		FlowLayout flowLayout_3 = (FlowLayout) typePnl.getLayout();
		flowLayout_3.setAlignment(FlowLayout.RIGHT);
		itemSettingsPnl.add(typePnl);
		
		typeLbl = new JLabel("Type:");
		typePnl.add(typeLbl);
		
		typeFld = new JTextField();
		typePnl.add(typeFld);
		typeFld.setColumns(10);
		
		addTagPnl = new JPanel();
		addTagPnl.setBackground(Color.WHITE);
		FlowLayout flowLayout_2 = (FlowLayout) addTagPnl.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		itemSettingsPnl.add(addTagPnl);
		
		addTagLbl = new JLabel("Add Tag:");
		addTagPnl.add(addTagLbl);
		
		addTagFld = new JTextField();
		addTagPnl.add(addTagFld);
		addTagFld.setColumns(10);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		itemEditPnl.add(panel, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		ItemGui.add(textArea, BorderLayout.CENTER);
		
		searchFrame.setBounds(0, 0, 600, 600);
		searchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		searchFrame.setVisible(true);
		setActionListener();
	}
	
	// sets action listeners
	private void setActionListener() {
		searchFld.addActionListener(this);
		nameChkbx.addActionListener(this);
		deleteItemFld.addActionListener(this);
		addItemFld.addActionListener(this);
		searchTagFld.addActionListener(this);
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
		} else if (event.getSource() == deleteItemFld) {
			deleteItem(event);
		} else if (event.getSource() == addItemFld) {
			addItem();
		} else if (event.getSource() == searchTagFld) {
			addTag();
		} else if (event.getSource() == ClxnBtn) {
			fileChooser();
		} else {
			checkTags(event);
			checkItems(event);
		}
	}

	private void search() { // god why
//		displayPnl.removeAll();
//		// if the search field is empty, all items in data will be displayed
//		if (addItemFld.getText().trim().isEmpty()) {
//			for (int i = 0; i < data.getContents().size(); i++) {
//				newItemBtn = new JButton(data.getContents().get(i).getName());
//				newItemBtn.setPreferredSize(new Dimension(100, 100));
//				displayPnl.add(newItemBtn);
//				newItemBtn.addActionListener(this);
//			}
//		}
//		ArrayList<Item> searchResults = new ArrayList<>();
//		Item searchInput = new Item(searchFld.getText());
//		// searches through names of items in data, then adds them to searchResults
//		if (nameX) {
//			if (data.getContents().contains(searchInput)) {
//				int index = data.getContents().indexOf(searchInput);
//				searchResults.add(data.getContents().get(index));
//			}
//		}
//		// searches through names of items in data, then adds them to searchResults		
//		if (tagX) {
//			for (int i = 0; i < data.getContents().size(); i++) {
//				if (data.getContents().contains(searchInput)) {
//					int index = data.getContents().indexOf(searchInput);
//					searchResults.add(data.getContents().get(index));			
//				}
//			}
//		}
//		// displays all items in searchResults
//		for (int i = 0; i < searchResults.size(); i++) {
//			newItemBtn = new JButton(searchResults.get(i).getName());
//			newItemBtn.setPreferredSize(new Dimension(100, 100));
//			displayPnl.add(newItemBtn);
//			newItemBtn.addActionListener(this);
//		}
//		displayPnl.revalidate();
//		displayPnl.repaint();
//		searchFld.setText("");
	}

	private void checkBox(boolean x) {
		if (x == false)
			x = true;
		else
			x = false;
	}
	
	private void deleteItem(ActionEvent event) { // doesn't work
//		Item oldItem = new Item(deleteItemFld.getText());
//		for (JButton item: items) {
//			System.out.println("Item deleted!");
//			if (event.getActionCommand().equals(item.getName())) {
//				displayPnl.remove(item);
//				displayPnl.revalidate();
//				displayPnl.repaint();
//				data.deleteItem(oldItem);
//				break;
//			}
//		}
//		deleteItemFld.setText("");
	}
	
	private void addItem() {
		Item newItem = new Item(addItemFld.getText());
		// items only get created if they have a name
		if (!addItemFld.getText().trim().isEmpty()) {
			// items only created if its name doesn't already exist
			if (!collection.contains(newItem)) {
				collection.add(newItem);
				createItemBtn(newItem);			
			}
		}
		addItemFld.setText("");
	}

	public void createItemBtn(Item item) {
		newItemBtn = new JButton(addItemFld.getText());
		newItemBtn.setPreferredSize(new Dimension(100, 100));
		displayPnl.add(newItemBtn);
		displayPnl.revalidate();
		newItemBtn.addActionListener(this);
	}
	
	// adds a tag to the tags panel.
	private void addTag() {
//		if (!addTagFld.getText().equals("")) {
//		JButton newTagBtn = new JButton(addTagFld.getText());
//		tagsPnl.add(newTagBtn);
//		tagsPnl.revalidate();
//		newTagBtn.addActionListener(this);
//		tags.add(newTagBtn);
//		addTagFld.setText("");
//		}
	}
	
	private void fileChooser() {
//		// close guiSearch window
//		ChooseFile fileChooser = new ChooseFile();
//		fileChooser.setVisible(true);
//		frame.dispose();
	}
	
	// when a tag is clicked, it gets removed.
	private void checkTags(ActionEvent event) {
//		for (JButton tag: tags) {
//			if (event.getSource() == tag) {
//				tagsPnl.remove(tag);
//				tagsPnl.revalidate();
//				tagsPnl.repaint();
//				tags.remove(tag);
//				break;
//			}
//		}
	}
	
	private void checkItems(ActionEvent event) {
//		for (JButton item: items) {
//			if (event.getSource() == item) {
//				EventQueue.invokeLater(new Runnable() {
//				public void run() {
//					try {
//						int index = items.indexOf(item);
//						data.saveCollection();
//						GuiItem window = new GuiItem(data.getContents().get(index));
//						frame.dispose();
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
//			});
//			}
//		}
	}
	
}
