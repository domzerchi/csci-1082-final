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
import java.util.Collections;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;

//import edu.century.pa5.Product;

public class CollectionGUI extends JFrame implements ActionListener {

	private JFrame frame;
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
	private JCheckBox tagChkbx;
	
	private JButton ClxnBtn;
	private JButton newItemBtn;
	
	private JPanel searchGui;
	private JPanel itemGui;
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
	private JPanel itemTagsPnl;
	private JTextArea notesArea;
	CardLayout card = new CardLayout(0, 0);

	private Item currentItem;
	private ArrayList<Item> collection = new ArrayList<>();
	private ArrayList<Tag> tagBtns = new ArrayList<>();
	private FileIO file = new FileIO();

	private JTextField clxnFld;
	private JPanel filePnl;
	private JButton SaveBtn;
	private JRadioButton nameRbtn;
	private JRadioButton typeRbtn;
	
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
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeSearch() {
		frame = new JFrame();
		frame.getContentPane().setLayout(card);
		
		searchGui = new JPanel();
		frame.getContentPane().add(searchGui, "search");
		searchGui.setLayout(new BorderLayout(0, 0));
		
		searchEditPnl = new JPanel();
		searchGui.add(searchEditPnl, BorderLayout.EAST);
		searchEditPnl.setPreferredSize(new Dimension(250, 100));
		searchEditPnl.setLayout(new BorderLayout(0, 0));
		
		searchSettingsPnl = new JPanel();
		searchSettingsPnl.setBorder(new LineBorder(new Color(0, 0, 0)));
		searchEditPnl.add(searchSettingsPnl, BorderLayout.NORTH);
		searchSettingsPnl.setLayout(new GridLayout(7, 0, 0, 0));
		
		filePnl = new JPanel();
		searchSettingsPnl.add(filePnl);
		filePnl.setLayout(new GridLayout(0, 2, 0, 0));
		
		ClxnBtn = new JButton("Browse...");
		filePnl.add(ClxnBtn);
		
		SaveBtn = new JButton("Save");
		filePnl.add(SaveBtn);
		
		clxnFld = new JTextField();
		clxnFld.setHorizontalAlignment(SwingConstants.CENTER);
		clxnFld.setText("database");
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
		
		nameRbtn = new JRadioButton("Name");
		nameRbtn.setSelected(true);
		nameRbtn.setBackground(Color.WHITE);
		searchByPnl.add(nameRbtn);
		
		typeRbtn = new JRadioButton("Type");
		typeRbtn.setBackground(Color.WHITE);
		searchByPnl.add(typeRbtn);
		
		ButtonGroup group = new ButtonGroup();
		group.add(nameRbtn);
		group.add(typeRbtn);
		
		tagChkbx = new JCheckBox("Tag");
		tagChkbx.setBackground(Color.WHITE);
		searchByPnl.add(tagChkbx);
		
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
		searchGui.add(displayPnl, BorderLayout.CENTER);
		displayPnl.setBorder(new LineBorder(new Color(0, 0, 0)));
		displayPnl.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) displayPnl.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		itemGui = new JPanel();
		frame.getContentPane().add(itemGui, "item");
		itemGui.setLayout(new BorderLayout(0, 0));
		
		itemEditPnl = new JPanel();
		itemEditPnl.setPreferredSize(new Dimension(250, 100));
		itemGui.add(itemEditPnl, BorderLayout.EAST);
		itemEditPnl.setLayout(new BorderLayout(0, 0));
		
		itemSettingsPnl = new JPanel();
		itemSettingsPnl.setBorder(new LineBorder(new Color(0, 0, 0)));
		itemEditPnl.add(itemSettingsPnl, BorderLayout.NORTH);
		itemSettingsPnl.setLayout(new GridLayout(4, 0, 0, 0));
		
		backBtn = new JButton("Back to Search");
		itemSettingsPnl.add(backBtn);
		
		nameFld = new JTextField();
		nameFld.setHorizontalAlignment(SwingConstants.CENTER);
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
		
		itemTagsPnl = new JPanel();
		itemTagsPnl.setBorder(new LineBorder(new Color(0, 0, 0)));
		itemTagsPnl.setBackground(Color.WHITE);
		itemEditPnl.add(itemTagsPnl, BorderLayout.CENTER);
		
		notesArea = new JTextArea();
		notesArea.setWrapStyleWord(true);
		notesArea.setLineWrap(true);
		itemGui.add(notesArea, BorderLayout.CENTER);
		
		frame.setBounds(0, 0, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		setActionListener();
	}
	
	// sets action listeners
	private void setActionListener() {
		searchFld.addActionListener(this);
		deleteItemFld.addActionListener(this);
		addItemFld.addActionListener(this);
		searchTagFld.addActionListener(this);
		ClxnBtn.addActionListener(this);
		SaveBtn.addActionListener(this);
		
		backBtn.addActionListener(this);
		nameFld.addActionListener(this);
		typeFld.addActionListener(this);
		addTagFld.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == searchFld) {
			search();
		} else if (event.getSource() == deleteItemFld) {
			deleteItem(event);
		} else if (event.getSource() == addItemFld) {
			addItem();
		} else if (event.getSource() == searchTagFld) {
			addSearchTag();
		} else if (event.getSource() == ClxnBtn) {
			chooseFile();
		} else if (event.getSource() == SaveBtn) {
			saveFile();
		} else if (event.getSource() == backBtn) {
			backToSearch();
		} else if (event.getSource() == nameFld) {
			currentItem.setName(nameFld.getText());
		} else if (event.getSource() == typeFld) {
			currentItem.setType(typeFld.getText());
		} else if (event.getSource() == addTagFld) {
			addItemTag(event);
		} else {
			checkItemTags(event);
			checkTags(event);
			checkItems(event);
		}
	}

	private void search() {
		if (searchFld.getText().trim().isEmpty()) {
			updateDisplay(collection);
		} else {
			ArrayList<Item> searchResults = new ArrayList<>();
			if (nameRbtn.isSelected()) {
				Item i = new Item(searchFld.getText());
				if (collection.contains(i)) {
					searchResults.add(i);
				}
			} else if (typeRbtn.isSelected()){
				for (Item i: collection) {
					if (i.getType().equals(searchFld.getText())) {
						searchResults.add(i);
					}
				}
			}
			if (tagChkbx.isSelected()) {
				ArrayList<Item> toRemove = new ArrayList<>();
				for (Item i: searchResults) {
					if (!i.hasTags(tagBtns)) {
						toRemove.add(i);
					}
				}
				searchResults.removeAll(toRemove);
			}
			updateDisplay(searchResults);
			searchFld.setText("");	
		}
	}
	
	private void deleteItem(ActionEvent event) {
		int index = -1;
		Item oldItem = new Item(deleteItemFld.getText());
		for (Item i: collection) {
			if (i.equals(oldItem)) {
				index = collection.indexOf(i);
				break;
			}
		}
		if (index != -1) {
			collection.remove(index);
			updateDisplay(collection);
		}
		deleteItemFld.setText("");
	}

	private void addItem() {
		Item newItem = new Item(addItemFld.getText());
		// items only get created if they have a name
		if (!addItemFld.getText().trim().isEmpty()) {
			// items only created if its name doesn't already exist
			if (!collection.contains(newItem)) {
				collection.add(newItem);
				updateDisplay(collection);
				addItemFld.setText("");
			} else {
				JOptionPane.showMessageDialog(null, "Item already exists!", "", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	private void updateDisplay(ArrayList<Item> list) {
		Collections.sort(list, Item.CompareByName);
		list.trimToSize();
		displayPnl.removeAll();
		for (Item i: list) {
			JButton iBtn = new JButton(i.getName());
//			iBtn.setPreferredSize(new Dimension(100, 100));
			iBtn.addActionListener(this);
			displayPnl.add(iBtn);
		}
		displayPnl.repaint();
		displayPnl.revalidate();
	}
	
	// adds a tag to the tags panel.
	private void addSearchTag() {
		Tag newTag = new Tag(searchTagFld.getText());
		if (!searchTagFld.getText().trim().isEmpty()) {
			if (!tagBtns.contains(newTag)) {
				tagBtns.add(newTag);
				updateSearchTags();
				search();
				searchTagFld.setText("");
			} else {
				JOptionPane.showMessageDialog(null, "Tag already exists!", "", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void updateSearchTags() {
		Collections.sort(tagBtns, Tag.CompareByTag);
		tagBtns.trimToSize();
		tagsPnl.removeAll();
		for (Tag t: tagBtns) {
			JButton tBtn = new JButton(t.getTag());
			tBtn.addActionListener(this);
			tagsPnl.add(tBtn);
		}
		tagsPnl.repaint();
		tagsPnl.revalidate();
	}

	private void chooseFile() {
		collection.clear();
		collection.addAll(file.browse());
		updateDisplay(collection);
	}
	
	private void saveFile() {
		file.writeTo(clxnFld.getText(), collection);
		JOptionPane.showMessageDialog(null, "Saved!", "", JOptionPane.INFORMATION_MESSAGE);
	}
	
	// when a tag is clicked, it gets removed.
	private void checkTags(ActionEvent event) {
		int index = -1;
		Tag oldTag = new Tag(event.getActionCommand());
		for (Tag t: tagBtns) {
			if (t.equals(oldTag)) {
				index = tagBtns.indexOf(t);
				break;
			}
		}
		if (index != -1) {
			tagBtns.remove(index);
			updateSearchTags();
		}
	}
	
	private void checkItems(ActionEvent event) {
		Item temp = new Item(event.getActionCommand()); // ugh
		int index = collection.indexOf(temp);
		if (index != -1) {
			currentItem = collection.get(index);
			nameFld.setText(currentItem.getName());
			notesArea.setText(currentItem.getNote());
			typeFld.setText(currentItem.getType());
			updateItemTags();
			
			searchGui.setVisible(false);
			itemGui.setVisible(true);	
		}
	}

	private void backToSearch() {
		currentItem.setNote(notesArea.getText());
		itemGui.setVisible(false);
		searchGui.setVisible(true);
		updateDisplay(collection);
	}

	private void addItemTag(ActionEvent event) {
		Tag newTag = new Tag(addTagFld.getText());
		if (!addTagFld.getText().trim().isEmpty()) {
			if (!currentItem.getTags().contains(newTag)) {
				currentItem.addTag(newTag.getTag());
					updateItemTags();
					search();
					addTagFld.setText("");
			} else {
				JOptionPane.showMessageDialog(null, "Tag already exists!", "", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void updateItemTags() {
		Collections.sort(currentItem.getTags(), Tag.CompareByTag);
		currentItem.getTags().trimToSize();
		itemTagsPnl.removeAll();
		for (Tag t: currentItem.getTags()) {
			JButton tBtn = new JButton(t.getTag());
			tBtn.addActionListener(this);
			itemTagsPnl.add(tBtn);
		}
		itemTagsPnl.repaint();
		itemTagsPnl.revalidate();
	}

	private void checkItemTags(ActionEvent event) {
		System.out.println("test");
		if (currentItem != null) {
		int index = -1;
		Tag oldTag = new Tag(event.getActionCommand());
		if (currentItem.getTags() != null) {
			for (Tag t: currentItem.getTags()) {
				if (t.equals(oldTag)) {
					index = currentItem.getTags().indexOf(t);
					break;
				}
			}	
		}
		if (index != -1) {
			currentItem.getTags().remove(index);
			updateItemTags();
		}
	}
	}
}
