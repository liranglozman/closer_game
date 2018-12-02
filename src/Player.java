import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class Player {
	
	private int id,size,x,y;
	private int[][] colorArr; //1 = shura 2 = tur;
	private String color;
	
	public Player(int id,int size,int[][] colorArr,String color)
	{
		this.x = (int)(Math.random()*40);
		this.y = (int)(Math.random()*40);
		this.id = id;
		colorArr[x][y] = id;
		this.size = size;
		this.colorArr = colorArr;
	}

	
	
	public void moveRight()
	{
		
	}
	



	public int getId() {
		return id;
	}







	public void setId(int id) {
		this.id = id;
	}







	public int getSize() {
		return size;
	}







	public void setSize(int size) {
		this.size = size;
	}





	public int[][] getColorArr() {
		return colorArr;
	}







	public void setColorArr(int[][] colorArr) {
		this.colorArr = colorArr;
	}







	public String getColor() {
		return color;
	}







	public void setColor(String color) {
		this.color = color;
	}







	@Override
	public String toString() {
		return "Player [id=" + id + ", size=" + size
				+", colorArr="
				+ Arrays.toString(colorArr) + "]";
	}

	
	
	


}
