import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class InstructionWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InstructionWindow window = new InstructionWindow();
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
	public InstructionWindow() {
		initialize();
	}

	public JFrame getFrame() {
		return frame;
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 800);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblInstructions = new JLabel("Instructions");
		lblInstructions.setFont(new Font("Tahoma", Font.PLAIN, 41));
		lblInstructions.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstructions.setBounds(293, 35, 213, 37);
		frame.getContentPane().add(lblInstructions);
		
		JLabel lblA = new JLabel("bla bla bla bla bla bla.........");
		lblA.setVerticalAlignment(SwingConstants.TOP);
		lblA.setBounds(190, 180, 484, 212);
		frame.getContentPane().add(lblA);
		
		JButton btnNewButton = new JButton("Understood");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnNewButton.setBackground(new Color(0, 0, 255));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(293, 621, 120, 42);
		frame.getContentPane().add(btnNewButton);
	}
	
	



}
