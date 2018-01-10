package À×öªÕ½»ú;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.text.GapContent;

public class daoju {
	int daoju_x,daoju_y;
	int width=30,height=30;
	int temp1=5,temp2=5;
	Image im;
	
	public daoju(Image im,int daoju_x,int daoju_y){
		this.im = im;
		this.daoju_x = daoju_x;
		this.daoju_y = daoju_y;
	}
	
	
	public void move(){
		daoju_x+=temp1; 
		if(daoju_x>=380){
			temp1=-5;
		}else if(daoju_x<=0){
			temp1=5;
		}
	
	

		daoju_y += temp2;

		if (daoju_y >= 400) {
			temp2 = -5;
		} else if (daoju_y <= 20) {
			temp2 = 5;
		}
	
		
}
	

	
	public void Draw(Graphics g){
		g.drawImage(im, daoju_x, daoju_y, width, height, null);
		move();
	}
	
	public Rectangle getRec() {
		return new Rectangle(daoju_x, daoju_y, 20, 30);
	}
}
