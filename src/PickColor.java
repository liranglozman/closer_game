import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.ProcessBuilder.Redirect;


public class PickColor {

	private JFrame frame;
	private int[][] colorArr = new int[40][40];
	private String colorPicked;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PickColor window = new PickColor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PickColor() {
		JLabel Red = new JLabel("");
		JLabel Green = new JLabel("");
		JLabel Blue = new JLabel("");
		initialize(Red,Green,Blue);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JLabel Red,JLabel Green,JLabel Blue) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 600, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		Green.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Player One = new Player(1,1,colorArr,"Green");
				colorPicked = "Green";
				Green.setEnabled(false);
				Green.setVisible(false);
				Red.setEnabled(false);
				Blue.setEnabled(false);
			}
		});
		Green.setIcon(new ImageIcon(System.getProperty("user.dir")+"/src/GreenPick.png"));
		Green.setBounds(400, 92, 100, 100);
		frame.getContentPane().add(Green);
		
		
		Blue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			Player One = new Player(1,1,colorArr,"Blue");
			colorPicked = "Blue";
			Blue.setEnabled(false);
			Blue.setVisible(false);
			Red.setEnabled(false);
			Green.setEnabled(false);
			
			}
		});
		Blue.setIcon(new ImageIcon(System.getProperty("user.dir")+"/src/BluePick.png"));
		Blue.setBounds(250, 92, 100, 100);
		frame.getContentPane().add(Blue);
		
		
		Red.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(Red.isEnabled())
				Player One = new Player(1,1,colorArr,"Red");
				colorPicked = "Red";
				Red.setEnabled(false);
				Red.setVisible(false);
				Blue.setEnabled(false);
				Green.setEnabled(false);
			}
		});
		Red.setIcon(new ImageIcon(System.getProperty("user.dir")+"/src/RedPick.png"));
		Red.setBounds(100, 92, 100, 100);
		frame.getContentPane().add(Red);
		
		JLabel lblPickAColor = new JLabel("Pick A Color");
		lblPickAColor.setFont(new Font("Tahoma", Font.BOLD, 41));
		lblPickAColor.setHorizontalAlignment(SwingConstants.CENTER);
		lblPickAColor.setBounds(105, 9, 390, 45);
		frame.getContentPane().add(lblPickAColor);
	}

}
