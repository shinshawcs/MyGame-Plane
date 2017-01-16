package planeGame;

import java.awt.Image;
import java.awt.Rectangle;

public class PlaneObject {
	Image img;
	double x, y;
	int speed=10;
	int width,height;
	public Rectangle getRect(){
		return new Rectangle((int)x,(int)y,width,height);
	}
	public PlaneObject(Image img, double x, double y, int speed, int width,
			int height) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.width = width;
		this.height = height;
	}
	public PlaneObject(){
		
	}
}
