package planeGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import SolarSystemUtil.Constant;

public class Bullet extends PlaneObject {
	double x=Constant.GAME_HEIGHT/2;
	double y=Constant.GAME_WIDTH/2;
	double degree;
	int size=5;
	public Bullet(){
		degree=Math.random()*Math.PI*2;
	}
	public Rectangle getRect(){
		Rectangle r=new Rectangle((int)x,(int)y,size,size);
		return r;
	}
	public void draw(Graphics g){
		Color c=g.getColor();
		g.setColor(Color.YELLOW);
		g.fillOval((int)x, (int)y, size, size);
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);
		if(y>Constant.GAME_HEIGHT-size||y<30){
			degree=-degree;
		}
		if(x<0||x>Constant.GAME_WIDTH-size){
			degree=Math.PI-degree;
		}
		g.setColor(c);
	}
}
