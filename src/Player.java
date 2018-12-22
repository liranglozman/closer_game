import java.awt.*;
import java.util.TimerTask;

public class Player extends TimerTask implements IDrawable {

	private Direction direction;

	private int x;

	private int y;

	private int radius, halfRadius;

	private Color color;

	private Polygon polygon;

	private Polyline2D polyline;

	public Player(int x, int y, int radius, Color color) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		halfRadius = radius / 2;
		this.color = color;

		polygon = new Polygon();
		polygon.addPoint(x - radius, y - radius);
		polygon.addPoint(x + radius, y - radius);
		polygon.addPoint(x + radius, y + radius);
		polygon.addPoint(x - radius, y + radius);

		polyline = new Polyline2D();

	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Direction getDirection() {
		return direction;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getRadius() {
		return radius;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public void draw(Graphics2D graphics2D) {

		Color savedColor = graphics2D.getColor();

		graphics2D.setColor(this.color);

		graphics2D.fillPolygon(polygon);

		if (polyline.npoints != 0) {
			graphics2D.draw(polyline);
		}

		graphics2D.fillRect(x - halfRadius, y - halfRadius, radius, radius);

		graphics2D.setColor(savedColor);

	}

	@Override
	public String toString() {
		return "Circle{" + "x=" + x + ", y=" + y + ", radius=" + radius
				+ ", color=" + color + '}';
	}

	@Override
	public void run() {
		if (direction == null) {
			return;
		}

		int oldX = x, oldY = y;

		switch (direction) {
		case UP:
			y = y - radius / 2;
			break;
		case DOWN:
			y = y + radius / 2;
			break;
		case LEFT:
			x = x - radius / 2;
			break;
		case RIGHT:
			x = x + radius / 2;
			break;
		default:
			return;
		}

		if (polyline.contains(x, y)) {
			System.out.println("LOOOOOSSSSSSSSSSSEEEEEERRRRRRRRRRR");
			System.exit(2);
		}
		
		if (!polygon.contains(x, y)) {
			System.out.println("OUT");
			polyline.addPoint(x, y);
		} else {
			System.out.println("IN");
		}

	}
}
