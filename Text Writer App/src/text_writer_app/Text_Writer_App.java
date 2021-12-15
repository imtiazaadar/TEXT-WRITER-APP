package text_writer_app;
/*
 * Author : Imtiaz Adar
 * Email : imtiaz-adar@hotmail.com
 * Project Name : Text Writer
 * Language Used : Java
 */
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Text_Writer_App extends JFrame implements ActionListener{
	// VARIABLES
	private JTextArea textArea;
	private JComboBox fontStyleBox;
	private JScrollPane scrollPane;
	private JSpinner fontSpinner;
	private JButton fontColorButton;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu editMenu;
	private JMenu aboutMenu;
	private JMenuItem newItem;
	private JMenuItem openItem;
	private JMenuItem saveItem;
	private JMenuItem printItem;
	private JMenuItem exit;
	private JMenuItem copyItem;
	private JMenuItem cutItem;
	private JMenuItem pasteItem;
	private JMenuItem selectAllItem;
	private JMenuItem aboutIt;
	private JLabel fontLabel;
	private ImageIcon img, img1, newfileIcon, openfileIcon, savefileIcon, printfileIcon, exitfileIcon,
	copyIcon, cutIcon, pasteIcon, selectIcon, aboutIcon;
	private Font textFieldInitialFont = new Font("Calibri", Font.PLAIN, 40);
	private Font fontLabelFont = new Font("Comic Sans Ms", Font.BOLD, 40);
	private Font spinnerFont = new Font("Comic Sans Ms", Font.BOLD, 18);
	private Font comboFont = new Font("Comic Sans Ms", Font.BOLD, 15);
	private String[] fontStyles;
	private String texts;
	public Text_Writer_App() {
		// ICON AND INTRO PIC
		img = new ImageIcon(getClass().getResource("icon.png"));
		this.setIconImage(img.getImage());
		img1 = new ImageIcon(getClass().getResource("text-editor1.png"));
		JLabel imgLabel = new JLabel(img1);
		imgLabel.setBounds(10, 20, 100, 50);
		this.add(imgLabel);
		// MENU ICONS
		newfileIcon = new ImageIcon(getClass().getResource("new__file.png"));
		openfileIcon = new ImageIcon(getClass().getResource("open__file.png"));
		savefileIcon = new ImageIcon(getClass().getResource("save__file.png"));
		printfileIcon = new ImageIcon(getClass().getResource("print__file.png"));
		exitfileIcon = new ImageIcon(getClass().getResource("exit__file.png"));
		copyIcon = new ImageIcon(getClass().getResource("copy__file.png"));
		cutIcon = new ImageIcon(getClass().getResource("cut__file.png"));
		pasteIcon = new ImageIcon(getClass().getResource("paste__file.png"));
		selectIcon = new ImageIcon(getClass().getResource("select__file.png"));
		aboutIcon = new ImageIcon(getClass().getResource("about__it.png"));
		// TEXT AREA
		textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setMargin(new Insets(2, 5, 2, 2));
		//textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setFont(textFieldInitialFont);
		// SCROLL PANE
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(40, 90, 707, 625);
		// FONT LABEL
		fontLabel = new JLabel("FONT");
		fontLabel.setBounds(120, 15, 150, 50);
		fontLabel.setForeground(Color.WHITE);
		fontLabel.setFont(fontLabelFont);
		this.add(fontLabel);
		// SPINNER
		fontSpinner = new JSpinner();
		fontSpinner.setBounds(673, 20, 75, 50);
		fontSpinner.setValue(40);
		fontSpinner.setFont(spinnerFont);
		fontSpinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				textArea.setFont(new Font(textArea.getFont().getFamily(), Font.PLAIN, (int)fontSpinner.getValue()));
				
			}
		});
		// FONT STYLE COMBO BOX
		fontStyles = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		fontStyleBox = new JComboBox(fontStyles);
		fontStyleBox.setSelectedItem("Calibri");
		fontStyleBox.setAlignmentY(CENTER_ALIGNMENT);
		fontStyleBox.setFont(comboFont);
		fontStyleBox.setBounds(392, 20, 280, 50);
		fontStyleBox.addActionListener(this);
		this.add(fontStyleBox);
		// FONT COLOR CHOOSER BUTTON
		fontColorButton = new JButton("COLOR");
		fontColorButton.setBounds(261, 20, 130, 50);
		fontColorButton.setBackground(new Color(198, 22, 22));
		fontColorButton.setForeground(Color.WHITE);
		fontColorButton.setBorder(new LineBorder(new Color(198, 22, 22), 1));
		fontColorButton.setFocusPainted(false);
		fontColorButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		fontColorButton.setFont(new Font("Comic Sans Ms", Font.BOLD, 28));
		fontColorButton.setHorizontalAlignment(JButton.CENTER);
		fontColorButton.setVerticalAlignment(JButton.CENTER);
		this.add(fontColorButton);
		fontColorButton.addActionListener(this);
		fontColorButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {
				fontColorButton.setForeground(new Color(198, 22, 22));
				fontColorButton.setBackground(Color.WHITE);	
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				fontColorButton.setForeground(Color.WHITE);
				fontColorButton.setBackground(new Color(198, 22, 22));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				fontColorButton.setForeground(new Color(198, 22, 22));
				fontColorButton.setBackground(Color.WHITE);	
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				fontColorButton.setForeground(new Color(198, 22, 22));
				fontColorButton.setBackground(Color.WHITE);	
			}
		});
		this.add(fontSpinner);
		this.add(scrollPane);
		// MENU BAR
		menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		fileMenu = new JMenu("FILE");
		fileMenu.add(Box.createRigidArea(new Dimension(200, 0)));
		editMenu = new JMenu("EDIT");
		editMenu.add(Box.createRigidArea(new Dimension(200, 0)));
		aboutMenu = new JMenu("ABOUT");
		aboutMenu.add(Box.createRigidArea(new Dimension(200, 0)));
		// MENU ITEM
		newItem = new JMenuItem("NEW");
		newItem.setIcon(newfileIcon);
		newItem.setIconTextGap(7);
		openItem = new JMenuItem("OPEN");
		openItem.setIcon(openfileIcon);
		openItem.setIconTextGap(7);
		saveItem = new JMenuItem("SAVE");
		saveItem.setIcon(savefileIcon);
		saveItem.setIconTextGap(7);
		printItem = new JMenuItem("PRINT");
		printItem.setIcon(printfileIcon);
		printItem.setIconTextGap(7);
		exit = new JMenuItem("EXIT");
		exit.setIcon(exitfileIcon);
		exit.setIconTextGap(7);
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(aboutMenu);
		copyItem = new JMenuItem("COPY");
		copyItem.setIcon(copyIcon);
		copyItem.setIconTextGap(5);
		cutItem = new JMenuItem("CUT");
		cutItem.setIcon(cutIcon);
		cutItem.setIconTextGap(5);
		pasteItem = new JMenuItem("PASTE");
		pasteItem.setIcon(pasteIcon);
		pasteItem.setIconTextGap(5);
		selectAllItem = new JMenuItem("SELECT ALL");
		selectAllItem.setIcon(selectIcon);
		selectAllItem.setIconTextGap(5);
		fileMenu.add(newItem);
		fileMenu.add(openItem);
		fileMenu.addSeparator();
		fileMenu.add(saveItem);
		fileMenu.add(printItem);
		fileMenu.addSeparator();
		fileMenu.add(exit);
		editMenu.add(copyItem);
		editMenu.add(cutItem);
		editMenu.add(pasteItem);
		editMenu.addSeparator();
		editMenu.add(selectAllItem);
		aboutIt = new JMenuItem("ABOUT ME");
		aboutIt.setIcon(aboutIcon);
		aboutIt.setIconTextGap(7);
		aboutMenu.add(aboutIt);
		// ACTION LISTENER
		newItem.addActionListener(this);
		newItem.setAccelerator(KeyStroke.getKeyStroke((char) KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		openItem.addActionListener(this);
		openItem.setAccelerator(KeyStroke.getKeyStroke((char) KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		saveItem.addActionListener(this);
		saveItem.setAccelerator(KeyStroke.getKeyStroke((char) KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		printItem.addActionListener(this);
		printItem.setAccelerator(KeyStroke.getKeyStroke((char) KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		exit.addActionListener(this);
		exit.setAccelerator(KeyStroke.getKeyStroke((char) KeyEvent.VK_F4, ActionEvent.ALT_MASK));
		copyItem.addActionListener(this);
		copyItem.setAccelerator(KeyStroke.getKeyStroke((char) KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		cutItem.addActionListener(this);
		cutItem.setAccelerator(KeyStroke.getKeyStroke((char) KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		pasteItem.addActionListener(this);
		pasteItem.setAccelerator(KeyStroke.getKeyStroke((char) KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		selectAllItem.addActionListener(this);
		selectAllItem.setAccelerator(KeyStroke.getKeyStroke((char) KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		aboutIt.addActionListener(this);
		aboutIt.setAccelerator(KeyStroke.getKeyStroke((char) KeyEvent.VK_I, ActionEvent.CTRL_MASK));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(350, 10, 800, 814);
		this.setTitle("TEXT WRITER");
		this.getContentPane().setBackground(new Color(32, 32, 32));
		this.setResizable(false);
		this.setLayout(null);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == fontColorButton) {
			JColorChooser colorChooser = new JColorChooser();
			Color newColor = colorChooser.showDialog(null, "Choose Any Color You Want", Color.BLACK);
			textArea.setForeground(newColor);
		}
		if(e.getSource() == fontStyleBox) {
			textArea.setFont(new Font((String)fontStyleBox.getSelectedItem(), Font.PLAIN, textArea.getFont().getSize()));
		}
		if(e.getSource() == newItem) {
			textArea.setText("");
		}
		if(e.getSource() == openItem) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File("."));
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files Only", "txt");
			fileChooser.setFileFilter(filter);
			int result = fileChooser.showOpenDialog(null);
			BufferedReader br = null;
			if(result == JFileChooser.APPROVE_OPTION) {
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				try {
					br = new BufferedReader(new FileReader(file));
					String str = "";
					while((str = br.readLine()) != null) {
						String text = str + "\n";
						textArea.append(text);
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				finally {
					try {
						br.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		if(e.getSource() == saveItem) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File("."));
			int result = fileChooser.showSaveDialog(null);
			BufferedWriter bw = null;
			if(result == JFileChooser.APPROVE_OPTION) {
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				try {
					bw = new BufferedWriter(new FileWriter(file));
					bw.write(textArea.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				finally {
					try {
						bw.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		if(e.getSource() == printItem) {
			try {
				textArea.print();
			}
			catch(Exception eee) {
				eee.printStackTrace();
			}
		}
		if(e.getSource() == exit) {
			System.exit(0);
		}
		
		if(e.getSource() == copyItem) {
			texts = textArea.getSelectedText();
		}
		if(e.getSource() == pasteItem) {
			textArea.insert(texts, textArea.getCaretPosition());
		}
		if(e.getSource() == cutItem) {
			texts = textArea.getSelectedText();
			textArea.replaceRange("", textArea.getSelectionStart(), textArea.getSelectionEnd());
		}
		if(e.getSource() == selectAllItem) {
			textArea.selectAll();
		}
		if(e.getSource() == aboutIt) {
			setVisible(false);
			AboutIt abit = new AboutIt();
			abit.setVisible(true);
		}
	}
}

