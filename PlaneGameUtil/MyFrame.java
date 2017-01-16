package SolarSystemUtil;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame{
	Image img=GameUtil.getImage("images/sun.png");
	public void launchFrame(){
		 setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		 setLocation(0,0);
		 setVisible(true);
		 new PaintThread().start();
		 addWindowListener(new WindowAdapter(){
			 public void windowClosing(WindowEvent e){
				 System.exit(0);
			 }
		 });
	}
	private double x=50,y=50;
	private double degree=3.14/3;
	private double speed=10;
	public void paint (Graphics g){
		g.drawImage(img, (int)x, (int)y, null);
		if(speed>0){
			speed-=0.01;
		}
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);
		if(y>400-50||y<0){
			degree=-degree;
		}
		if(x<0||x>400-50){
			degree=Math.PI-degree;
		}
	}
	class PaintThread extends Thread{
		public void run(){
			while(true){
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args){
		MyFrame gf=new MyFrame();
		gf.launchFrame();
	}
		
}
