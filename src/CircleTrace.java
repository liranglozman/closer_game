import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;


public class CircleTrace implements IDrawable {

	private int x,y,width,height;
	private Color color;
	private ArrayList<Integer> arr_X,arr_Y;
	
	public CircleTrace(int x,int y,int width,int height,Color color)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.arr_X = new ArrayList<Integer>();
		this.arr_Y = new ArrayList<Integer>();

	}
	
	
	public void updateArr(int x,int y)
	{
		arr_X.add(x);
		arr_Y.add(y);
	}

	public void draw(Graphics2D g)
	{
		if(arr_X.isEmpty() || arr_Y.isEmpty()){
			return;
		}
		g.setColor(color);
		
		int[] x1 = arr_X.stream().mapToInt(i->i).toArray();
		int[] y1 = arr_Y.stream().mapToInt(i->i).toArray();
		
		g.drawPolyline(x1, y1, Math.min(x1.length, y1.length));
	}
	public ArrayList<Integer> getArr_X() {
		return arr_X;
	}


	public void setArr_X(ArrayList<Integer> arr_X) {
		this.arr_X = arr_X;
	}


	public ArrayList<Integer> getArr_Y() {
		return arr_Y;
	}

	public void setArr_Y(ArrayList<Integer> arr_Y) {
		this.arr_Y = arr_Y;
	}
	
	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}
}
