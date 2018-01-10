package À×öªÕ½»ú;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class zj {
	
	int zj_x=170, zj_y=530;
	Toolkit tk = Toolkit.getDefaultToolkit();
	
	Image zj = tk.getImage(demo.class.getClassLoader().getResource(
			"images/zj.png"));
	
	public zj(int zj_x, int zj_y){
		this.zj_x = zj_x;
		this.zj_y = zj_y;
	}
	
	public int getX(){
		return zj_x;
	}
	
	public int getY(){
		return zj_y;
	}
	
	public void move(boolean up,boolean down, boolean left, boolean right) {
		if (up == true && zj_y > 30) {
			zj_y -= 5;
		}
		if (down == true && zj_y < 550) {
			zj_y += 5;
		}
		if (left == true && zj_x > -20) {
			zj_x -= 5;
		}
		if (right == true && zj_x < 350) {
			zj_x += 5;
		}
	}

	public void Draw(Graphics g,boolean up,boolean down, boolean left, boolean right){
		g.drawImage(zj, zj_x, zj_y, 70, 70, null);
		move(up,down,left,right);
	}
	
	public Rectangle getRec() {
		return new Rectangle(zj_x, zj_y, 70, 70);
	}
}
