package À×öªÕ½»ú;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.Random;

public class diji {
	int dj1_x,dj1_y;
	int width = 50, height = 50;
	int temp = 5,timer=0;
//	int diji_imagesNum=0;
	boolean zds = true;
	Random ra = new Random();
	
//	Toolkit tk = Toolkit.getDefaultToolkit();
//
//	Image dj1 = tk.getImage(demo.class.getClassLoader().getResource(
//			"images/dj1.png"));
//	Image dj2 = tk.getImage(demo.class.getClassLoader().getResource(
//			"images/dj2.png"));
//	Image dj3 = tk.getImage(demo.class.getClassLoader().getResource(
//			"images/dj3.png"));

	Image diji_images;
	
	public diji(Image diji_images,int dj1_x,int dj1_y){
		this.diji_images = diji_images;
		this.dj1_x = dj1_x;
		this.dj1_y = dj1_y;
	}
	
	public int getX(){
		return dj1_x;
	}
	
	public int getY(){
		return dj1_y;
	}
	
	public void move() {
		dj1_x += temp;
		if(dj1_x>=350){
			temp-=5;
		}else if(dj1_x<=0){
			temp+=5;
		}
		dj1_y += 5;
	}
	
	public void Draw(Graphics g){
		g.drawImage(diji_images, dj1_x, dj1_y, width, height, null);
		move();
		timer++;
		if(timer>30){
			zds=true;
			timer=0;
		}
	}
	
	public Rectangle getRec(){
		return new Rectangle(dj1_x, dj1_y, width, height);	
		}
	
	public zidan shoot(){
		zds=false;
		return new zidan(dj1_x + 15, dj1_y + 30);
	}
}
