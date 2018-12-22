import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class Main {

	private final static int SEC_IN_MILLIS = 1000;
	private final static int RENDERING_FREQUENCY_HZ = 15;
	private final static int RENDERING_TASK_PERIOD_MILLIS = SEC_IN_MILLIS
			/ RENDERING_FREQUENCY_HZ;

	private Timer m_timer;

	private JFrame mainFrame;

	private Panel controlPanel;

	private Player m_player;

	private KeyEventDispatcher keyEventDispatcher = new KeyEventDispatcher() {
		@Override
		public boolean dispatchKeyEvent(KeyEvent event) {
			switch (event.getKeyCode()) {
			case KeyEvent.VK_A:
				if (m_player.getDirection() != Direction.RIGHT)
					m_player.setDirection(Direction.LEFT);
				break;
			case KeyEvent.VK_D:
				if (m_player.getDirection() != Direction.LEFT)
					m_player.setDirection(Direction.RIGHT);
				break;
			case KeyEvent.VK_W:
				if (m_player.getDirection() != Direction.DOWN)
					m_player.setDirection(Direction.UP);
				break;
			case KeyEvent.VK_S:
				if (m_player.getDirection() != Direction.UP)
					m_player.setDirection(Direction.DOWN);
				break;
			}

			return true;
		}
	};

	private MyCanvas myCanvas;

	Main() {
		prepareGUI();
		prepareGameObjects();
		prepareTimer();
	}

	private void prepareGameObjects() {
		List<IDrawable> drawables = new ArrayList<>();
		m_player = new Player(50, 50, 10, Color.BLUE);
		drawables.add(m_player);
		drawables.add(new Circle(50, 50, 10, Color.RED));
		myCanvas = new MyCanvas(800, 800, drawables);
		controlPanel.add(myCanvas);
	}

	private void prepareTimer() {
		m_timer = new Timer();

	}

	public static void main(String[] args) {
		Main main = new Main();
		main.start();
	}

	private void start() {
		RenderTask renderTask = new RenderTask();
		m_timer.scheduleAtFixedRate(renderTask, SEC_IN_MILLIS,
				RENDERING_TASK_PERIOD_MILLIS);
		m_timer.scheduleAtFixedRate(m_player, SEC_IN_MILLIS,
				RENDERING_TASK_PERIOD_MILLIS);
		mainFrame.setVisible(true);
	}

	private void prepareGUI() {
		mainFrame = new JFrame("");
		mainFrame.setResizable(false);
		mainFrame.setSize(800, 800);
		mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});

		controlPanel = new Panel();
		mainFrame.add(controlPanel);
		controlPanel.setLayout(null);
		mainFrame.setVisible(true);

		KeyboardFocusManager.getCurrentKeyboardFocusManager()
				.addKeyEventDispatcher(keyEventDispatcher);
	}

	public JFrame getFrame() {
		return mainFrame;
	}

	class MyCanvas extends Canvas {

		private final int width;
		private final int height;

		private final List<? extends IDrawable> drawableList;

		public MyCanvas(int width, int height,
				List<? extends IDrawable> drawableList) {
			super();
			this.width = width;
			this.height = height;
			this.drawableList = drawableList;
			setBackground(Color.WHITE);
			setSize(width, height);

			Polygon polygon = new Polygon();
		}

		@Override
		public void paint(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			for (int i = 0; i < drawableList.size(); i++) {
				drawableList.get(i).draw(g2);
			}
		}

	}

	class RenderTask extends TimerTask {
		@Override
		public void run() {
			myCanvas.repaint();

		}
	}
}
