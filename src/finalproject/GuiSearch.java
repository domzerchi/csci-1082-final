package projectfinal;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class GuiSearch {

	private JFrame frame;
	private JPanel viewPanel;
	private JPanel settingsPanel;
	private JPanel editPanel;
	private JPanel tagPanel;
	private JPanel toggleSearch;
	private JPanel toggleImage;
	private JLabel lblSearchBy;
	private JCheckBox chckbxName;
	private JCheckBox chkbxTag;
	private JTextField txtSearch;
	private JCheckBox chckbxType;
	private JCheckBox chckbxNewCheckBox;
	private JPanel filePanel;
	private JButton newBtn;
	private JButton openBtn;

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
		frame.getContentPane().setLayout(null);
		
		viewPanel = new JPanel();
		viewPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		viewPanel.setBackground(Color.WHITE);
		viewPanel.setBounds(0, 0, 400, 561);
		frame.getContentPane().add(viewPanel);
		
		settingsPanel = new JPanel();
		settingsPanel.setBorder(null);
		settingsPanel.setBackground(Color.WHITE);
		settingsPanel.setBounds(399, 0, 185, 561);
		frame.getContentPane().add(settingsPanel);
		settingsPanel.setLayout(new BorderLayout(0, 0));
		
		editPanel = new JPanel();
		settingsPanel.add(editPanel, BorderLayout.NORTH);
		editPanel.setLayout(new GridLayout(3, 0, 0, 0));
		
		toggleImage = new JPanel();
		toggleImage.setBorder(new LineBorder(new Color(0, 0, 0)));
		toggleImage.setBackground(Color.WHITE);
		editPanel.add(toggleImage);
		
		chckbxNewCheckBox = new JCheckBox("Toggle Images");
		chckbxNewCheckBox.setBackground(Color.WHITE);
		toggleImage.add(chckbxNewCheckBox);
		
		toggleSearch = new JPanel();
		toggleSearch.setBorder(null);
		toggleSearch.setBackground(Color.WHITE);
		editPanel.add(toggleSearch);
		toggleSearch.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		lblSearchBy = new JLabel("Search by:");
		toggleSearch.add(lblSearchBy);
		
		chckbxName = new JCheckBox("Name");
		chckbxName.setBackground(Color.WHITE);
		toggleSearch.add(chckbxName);
		
		chkbxTag = new JCheckBox("Tag");
		chkbxTag.setBackground(Color.WHITE);
		toggleSearch.add(chkbxTag);
		
		chckbxType = new JCheckBox("Type");
		toggleSearch.add(chckbxType);
		
		txtSearch = new JTextField();
		editPanel.add(txtSearch);
		txtSearch.setForeground(Color.LIGHT_GRAY);
		txtSearch.setText("Search");
		txtSearch.setColumns(18);
		
		tagPanel = new JPanel();
		tagPanel.setBorder(null);
		tagPanel.setBackground(Color.WHITE);
		settingsPanel.add(tagPanel, BorderLayout.CENTER);
		
		filePanel = new JPanel();
		filePanel.setBackground(Color.WHITE);
		settingsPanel.add(filePanel, BorderLayout.SOUTH);
		filePanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		newBtn = new JButton("New Database");
		filePanel.add(newBtn);
		
		openBtn = new JButton("Open Database");
		filePanel.add(openBtn);
		frame.setBounds(600, 600, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
