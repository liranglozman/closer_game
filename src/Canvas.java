import java.awt.Graphics;

import javax.swing.JPanel;


public class Canvas extends JPanel {
	
	private boolean isStarted = false;

	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		g.fillRect(0, 0, 20, 20);
		if(isStarted){
			g.fillRect(0, 0, 20, 20);
		}
		
	}
	
	
	public void start()
	{
		isStarted = true;
	}
}
