package finalproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

public class GuiItem extends JFrame implements ActionListener {

	private JFrame frame;
	private JPanel editPnl;
	private JPanel helperPnl;
	private JTextField typeFld;
	private JTextField tagFld;
	private JLabel typeLbl;
	private JLabel addTagLbl;
	private JPanel typePnl;
	private JPanel tagPnl;
	private JPanel tagsPnl;
	private JPanel savePnl;
	private JButton saveBtn;
	private JTextArea notesArea;
	private JScrollPane scroll;
	private JPanel notesPnl;
	private JTextField nameFld;
	
	Item item = new Item("");
	ArrayList<JButton> tags = new ArrayList<>();

	/**
	 * Create the application.
	 */
	public GuiItem() {
		initialize();
	}
	
	/**
	 * create the application with an existing item.
	 * @param input's values are displayed in the frame.
	 */
	public GuiItem(Item input) {
		item = input;
		initialize();
		// set name
		nameFld.setText(item.getName());
		// set type
		typeFld.setText(item.getType());
		// set tags
		ArrayList<Tag> itemTags = item.getTags();
		for (int i = 0; i < itemTags.size(); i++) {
			JButton newTagBtn = new JButton(itemTags.get(i).getValue());
			tagsPnl.add(newTagBtn);
			newTagBtn.addActionListener(this);
			tags.add(newTagBtn);
		}
		tagsPnl.revalidate();
		// set notes
		notesArea.setText(item.getNote());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		editPnl = new JPanel();
		editPnl.setBorder(new LineBorder(new Color(0, 0, 0)));
		editPnl.setBackground(Color.WHITE);
		editPnl.setPreferredSize(new Dimension(180, 100));
		frame.getContentPane().add(editPnl, BorderLayout.EAST);
		editPnl.setLayout(new BorderLayout(0, 0));
		
		helperPnl = new JPanel();
		helperPnl.setBorder(new LineBorder(new Color(0, 0, 0)));
		helperPnl.setBackground(Color.WHITE);
		editPnl.add(helperPnl, BorderLayout.NORTH);
		helperPnl.setLayout(new GridLayout(3, 0, 0, 0));
		
		nameFld = new JTextField();
		nameFld.setHorizontalAlignment(SwingConstants.CENTER);
		nameFld.setText("Name");
		helperPnl.add(nameFld);
		nameFld.setColumns(10);
		
		typePnl = new JPanel();
		typePnl.setBackground(Color.WHITE);
		helperPnl.add(typePnl);
		typePnl.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		typeLbl = new JLabel("Type:");
		typePnl.add(typeLbl);
		typeLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		
		typeFld = new JTextField();
		typeFld.setHorizontalAlignment(SwingConstants.LEFT);
		typePnl.add(typeFld);
		typeFld.setColumns(10);
		
		tagPnl = new JPanel();
		tagPnl.setBackground(Color.WHITE);
		helperPnl.add(tagPnl);
		tagPnl.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		addTagLbl = new JLabel("Add Tag:");
		tagPnl.add(addTagLbl);
		addTagLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tagFld = new JTextField();
		tagPnl.add(tagFld);
		tagFld.setColumns(10);
		
		tagsPnl = new JPanel();
		tagsPnl.setBackground(Color.WHITE);
		editPnl.add(tagsPnl, BorderLayout.CENTER);
		
		savePnl = new JPanel();
		editPnl.add(savePnl, BorderLayout.SOUTH);
		savePnl.setLayout(new GridLayout(1, 0, 0, 0));
		
		saveBtn = new JButton("Save Notes");
		savePnl.add(saveBtn);
		
		notesPnl = new JPanel();
		notesPnl.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(notesPnl, BorderLayout.CENTER);
		notesPnl.setLayout(new BorderLayout(0, 0));
		
		notesArea = new JTextArea();
		notesPnl.add(notesArea);
		notesArea.setPreferredSize(new Dimension(584, 200));
		notesArea.setLineWrap(true);
		notesArea.setWrapStyleWord(true);
		notesArea.setBackground(Color.WHITE);
		scroll = new JScrollPane(notesArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED); // doesn't work woooo
		notesPnl.add(scroll);

		frame.setBounds(0, 0, 600, 600);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setVisible(true);
		setActionListener();
	}

	private void setActionListener() {
		nameFld.addActionListener(this);
		typeFld.addActionListener(this);
		tagFld.addActionListener(this);
		saveBtn.addActionListener(this);

		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				item.setNote(notesArea.getText());
		    	frame.dispose();
				GuiSearch window = new GuiSearch();
		    }
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nameFld) {
			setName();
		} else if (e.getSource() == typeFld) {
			setType();
		} else if (e.getSource() == tagFld) {
			addTag();
		} else if (e.getSource() == saveBtn) {
			saveNotes();
		} else {
			checkTags(e);
		}
	}

	// writes a name in the item's name field.
	private void setName() {
		item.setName(nameFld.getText());
	}
	// writes a type in the item's type field.
	private void setType() {
		item.setType(typeFld.getText());
	}
	
	// adds a tag to the item's tags panel.
	private void addTag() {
		if (!tagFld.getText().equals("")) {
		JButton newTagBtn = new JButton(tagFld.getText());
		tagsPnl.add(newTagBtn);
		tagsPnl.revalidate();
		newTagBtn.addActionListener(this);
		tags.add(newTagBtn);
		tagFld.setText("");
		}
	}
	
	// saves notes
	private void saveNotes() {
		item.setNote(notesArea.getText());
	}
	
	// deletes tags when they're clicked.
	private void checkTags(ActionEvent e) {
		for (JButton tag: tags) {
			if (e.getSource() == tag) {
				tagsPnl.remove(tag);
				tagsPnl.revalidate();
				tagsPnl.repaint();
				tags.remove(tag);
				break;
			}
		}
	}
	
}
