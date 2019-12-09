package finalproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JPanel imgPnl;
	private JPanel editPnl;
	private JPanel helperPnl;
	private JLabel nameLbl;
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

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GuiItem window = new GuiItem();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public GuiItem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		imgPnl = new JPanel();
		imgPnl.setBackground(Color.WHITE);
		imgPnl.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(imgPnl, BorderLayout.CENTER);
		
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
		
		nameLbl = new JLabel("*database title*");
		nameLbl.setBackground(Color.WHITE);
		nameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		helperPnl.add(nameLbl);
		
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
		frame.getContentPane().add(notesPnl, BorderLayout.SOUTH);
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		setActionListener();
	}

	private void setActionListener() {
		typeFld.addActionListener(this);
		tagFld.addActionListener(this);
		saveBtn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// add name editor
		if (e.getSource() == typeFld) {
			addType();
		} else if (e.getSource() == tagFld) {
			addTag();
		} else if (e.getSource() == saveBtn) {
			saveNotes();
		}
	}

	private void addType() {
		// TODO Auto-generated method stub
		
	}
	
	private void addTag() {
		// TODO Auto-generated method stub
		
	}
	
	private void saveNotes() {
		// TODO Auto-generated method stub
		
	}
	
}
