package planeGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import SolarSystemUtil.Constant;
import SolarSystemUtil.GameUtil;
import SolarSystemUtil.MyFrame;

public class PlaneFrame extends MyFrame{
	Image bg=GameUtil.getImage("Images/sky.jpg");
	Plane plane=new Plane("Images/plane1.png",100,100);
	ArrayList bulletList=new ArrayList();
	Explore ex;
	Date startTime;
	Date endTime;
	public void paint(Graphics g){
		g.drawImage(bg,0,0,null);
		plane.draw(g);
		
		for(int i=0;i<bulletList.size();i++){
			Bullet b=(Bullet)bulletList.get(i);
			b.draw(g);
			boolean result=b.getRect().intersects(plane.getRect());
			if(result){
				plane.setLive(false);			
				if(ex==null){
					endTime=new Date();
					ex=new Explore(plane.x,plane.y);
				}
				ex.draw(g);
				break;
			}
		}
		if(!plane.isLive()){
			printInfo(g,"Over!",100,Constant.GAME_HEIGHT/2-100,Constant.GAME_WIDTH/2,Color.red);
			int period=(int)(endTime.getTime()-startTime.getTime())/1000;
			printInfo(g,"Time:"+period+"s",20,100,100,Color.green);
			switch(period/2){
			case 0:
				printInfo(g,"Newbie",20,150,150,Color.white);
				break;
			case 2:
				printInfo(g,"Entry",20,150,150,Color.white);
				break;
			case 5:
				printInfo(g,"Intermediate",20,150,150,Color.white);
				break;
			case 10:
				printInfo(g,"Advanced",20,150,150,Color.white);
			}
		}
		printInfo(g,"Grade:100",30,50,50,Color.green);
	}
	public void printInfo(Graphics g, String str, int size,int x, int y, Color color){
		Color c=g.getColor();
		g.setColor(color);
		Font f=new Font("Calibri",Font.BOLD,size);
		g.setFont(f);
		g.drawString(str,x,y);
		g.setColor(c);
		
	}
				
	
	public static void main(String[] args){
		new PlaneFrame().launchFrame();
	}
	public void launchFrame(){
		super.launchFrame();
		addKeyListener(new KeyMonitor());
		for(int i=0;i<5;i++){
			Bullet b=new Bullet();
			bulletList.add(b);
		}
		startTime=new Date();
		
	}
	class KeyMonitor extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			System.out.println("Press"+e.getKeyCode());
			plane.addDirection(e);
			
		}
		public void keyReleased(KeyEvent e){
			System.out.println("Release"+e.getKeyCode());
			plane.removeDirection(e);
		}
		
	}
}
