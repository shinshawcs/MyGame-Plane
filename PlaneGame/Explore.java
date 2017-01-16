package planeGame;

import java.awt.Graphics;
import java.awt.Image;

import SolarSystemUtil.GameUtil;

public class Explore {
	double x,y;
	static Image[] imgs=new Image[2];
	static{
		for(int i=0;i<2;i++){
			imgs[i]=GameUtil.getImage("Images/ImagesExplode/bomb"+(i+1)+".png");
			imgs[i].getWidth(null);
		}
	}
	int count;
	public void draw(Graphics g){
		if(count<=1){
			g.drawImage(imgs[count], (int)x, (int)y, null);
			count++;
		}		
	}
	
	public Explore(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

}
