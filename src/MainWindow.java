import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MainWindow {

	private JFrame frame;
	private final JLabel lblNewLabel = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		// Getting the project location and locating the background picture;
		System.out.println(System.getProperty("user.dir")+"/src");
		
		JButton btnInstruction = new JButton("Instruction");
		btnInstruction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InstructionWindow IW = new InstructionWindow();
				IW.getFrame().setVisible(true);;
			}
		});
		btnInstruction.setBounds(154, 279, 89, 23);
		frame.getContentPane().add(btnInstruction);
		lblNewLabel.setBackground(SystemColor.textHighlight);
		lblNewLabel.setIcon(new ImageIcon(System.getProperty("user.dir")+"/src/renault-Megane-Trophy-2009-Image-08-800.jpg"));
		//Size Of Background;
		lblNewLabel.setBounds(0, 0, 800, 800);
		frame.getContentPane().add(lblNewLabel);
	}
}
