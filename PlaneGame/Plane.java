package planeGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import SolarSystemUtil.GameUtil;

public class Plane extends PlaneObject {
	boolean left,up,right,down;
	boolean live=true;
	
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	public void draw(Graphics g){
		if(live){
			g.drawImage(img,(int)x,(int)y,null);
			move();
		}		
	}
	public void move(){
		if(left){
			x-=speed;
		}
		if(right){
			x+=speed;
		}
		if(up){
			y-=speed;
		}
		if(down){
			y+=speed;
		}		
	}
	public void addDirection(KeyEvent e){
		switch(e.getKeyCode()){
		case 37:
			left=true;
			break;
		case 38:
			up=true;
			break;
		case 39:
			right=true;
			break;
		case 40:
			down=true;
			break;
		default:
			break;
		}
	}
	public void removeDirection(KeyEvent e){
		switch(e.getKeyCode()){
		case 37:
			left=false;
			break;
		case 38:
			up=false;
			break;
		case 39:
			right=false;
			break;
		case 40:
			down=false;
			break;
		default:
			break;
		}
	}
	public Plane(String imgPath, double x, double y) {
		super();
		this.img = GameUtil.getImage(imgPath);
		this.width=img.getWidth(null);
		this.height=img.getHeight(null);
		this.x = x;
		this.y = y;
	}
	public Plane(){
		
	}
	
}
