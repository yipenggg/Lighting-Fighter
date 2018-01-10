package À×öªÕ½»ú;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.Random;

public class boss {
	int boss_x,boss_y;
	int width = 100,height=80;
	int timer=0;
	Random ra = new Random();
	int temp1=ra.nextInt(10),temp2=ra.nextInt(10);
	boolean zds=true;
	Image im;
	
	public boss(Image im,int boss_x,int boss_y){
		this.im = im;
		this.boss_x=boss_x;
		this.boss_y=boss_y;
	}
	
	public int getX(){
		return boss_x;
	}
	
	public int getY(){
		return boss_y;
	}
	
	public void move(){
		boss_x+=temp1; 
		boss_y+=temp2;
		if(boss_x>=350){
			temp1=-5;
		}else if(boss_x<=0){
			temp1=5;
		}
		if(boss_y>=400){
			temp2=-5;
		}else if(boss_y<=20){
			temp2=5;
		}
	}
	
	public void Draw(Graphics g){
		g.drawImage(im, boss_x, boss_y, width, height, null);
		move();
		timer++;
		if(timer>20){
			zds=true;
			timer=0;
		}
	}
	
	public Rectangle getRec() {
		return new Rectangle(boss_x, boss_y, width, height);
	}
	
	public zidan shoot(){
		zds=false;
		return new zidan(boss_x+50,boss_y+30);
	}
}
