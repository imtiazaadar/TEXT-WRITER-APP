package text_writer_app;
/*
 * Author : Imtiaz Adar
 * Email : imtiaz-adar@hotmail.com
 * Project Name : Text Writer
 * Language Used : Java
 */
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class AboutIt extends JFrame implements ActionListener {
	private JLabel introLabel, aboutLabel;
	private ImageIcon img;
	private JButton back;
	private String myString = "You can contact with him via email.\nEmail : imtiaz-adar@hotmail.com, </html>";
	public AboutIt() {
		img = new ImageIcon(getClass().getResource("icon.png"));
		this.setIconImage(img.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(350, 10, 800, 814);
		this.setTitle("TEXT WRITER");
		this.getContentPane().setBackground(new Color(32, 32, 32));
		this.setResizable(false);
		this.setLayout(null);
		this.setVisible(true);
		introLabel = new JLabel("TEXT WRITER APP");
		introLabel.setBounds(106, 100, 600, 70);
		introLabel.setFont(new Font("Comic Sans Ms", Font.BOLD, 60));
		introLabel.setForeground(Color.WHITE);
		this.add(introLabel);
		aboutLabel = new JLabel();
		aboutLabel.setBounds(100, 250, 500, 30);
		aboutLabel.setFont(new Font("Comic Sans Ms", Font.PLAIN, 30));
		aboutLabel.setForeground(Color.WHITE);
		this.add(aboutLabel);
		JLabel aboutLabel1 = new JLabel("It's a text writing app. Here You can write, open,");
		aboutLabel1.setBounds(100, 280, 650, 35);
		aboutLabel1.setFont(new Font("Comic Sans Ms", Font.PLAIN, 25));
		aboutLabel1.setForeground(Color.WHITE);
		this.add(aboutLabel1);
		JLabel aboutLabel2 = new JLabel("edit, save and even print your text file. This");
		aboutLabel2.setBounds(100, 330, 600, 35);
		aboutLabel2.setFont(new Font("Comic Sans Ms", Font.PLAIN, 25));
		aboutLabel2.setForeground(Color.WHITE);
		this.add(aboutLabel2);
		JLabel aboutLabel3 = new JLabel("app is made by IMTIAZ AHMED ADAR. He is also");
		aboutLabel3.setBounds(100, 380, 630, 35);
		aboutLabel3.setFont(new Font("Comic Sans Ms", Font.PLAIN, 25));
		aboutLabel3.setForeground(Color.WHITE);
		this.add(aboutLabel3);
		JLabel aboutLabel4 = new JLabel("known as IMTIAZ ADAR, is an upcoming software");
		aboutLabel4.setBounds(100, 430, 620, 35);
		aboutLabel4.setFont(new Font("Comic Sans Ms", Font.PLAIN, 25));
		aboutLabel4.setForeground(Color.WHITE);
		this.add(aboutLabel4);
		JLabel aboutLabel5 = new JLabel("engineer. You can contact with him via email");
		aboutLabel5.setBounds(100, 480, 620, 35);
		aboutLabel5.setFont(new Font("Comic Sans Ms", Font.PLAIN, 25));
		aboutLabel5.setForeground(Color.WHITE);
		this.add(aboutLabel5);
		JLabel aboutLabel6 = new JLabel("Email : imtiaz-adar@hotmail.com or imtiazadar");
		aboutLabel6.setBounds(100, 530, 620, 35);
		aboutLabel6.setFont(new Font("Comic Sans Ms", Font.PLAIN, 25));
		aboutLabel6.setForeground(Color.WHITE);
		this.add(aboutLabel6);
		JLabel aboutLabel7 = new JLabel("official@gmail.com. Thank You.");
		aboutLabel7.setBounds(100, 580, 620, 35);
		aboutLabel7.setFont(new Font("Comic Sans Ms", Font.PLAIN, 25));
		aboutLabel7.setForeground(Color.WHITE);
		this.add(aboutLabel7);
		back = new JButton("BACK");
		back.setBounds(316, 660, 150, 60);
		back.setFont(new Font("Comic Sans Ms", Font.BOLD, 45));
		back.setForeground(Color.WHITE);
		back.setBackground(new Color(198, 22, 22));
		back.setBorder(new LineBorder(new Color(198, 22, 22), 1));
		back.setFocusPainted(false);
		back.setCursor(new Cursor(Cursor.HAND_CURSOR));
		back.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {
				back.setForeground(new Color(198, 22, 22));
				back.setBackground(Color.WHITE);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				back.setForeground(Color.WHITE);
				back.setBackground(new Color(198, 22, 22));
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				back.setForeground(new Color(198, 22, 22));
				back.setBackground(Color.WHITE);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				back.setForeground(new Color(198, 22, 22));
				back.setBackground(Color.WHITE);
				
			}
		});
		this.add(back);
		back.addActionListener((ActionListener) this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back) {
			setVisible(false);
			new Text_Writer_App().setVisible(true);
		}
		
	}
}
