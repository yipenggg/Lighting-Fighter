package À×öªÕ½»ú;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class zidan {
	int zd_x,zd_y;
	int zd_width=20,zd_height=30;
	//Boolean shoot = false;
	
	Toolkit tk = Toolkit.getDefaultToolkit();

	Image zj_zd = tk.getImage(demo.class.getClassLoader().getResource(
			"images/zj_zd.png"));
	Image zj_zd_daoju = tk.getImage(demo.class.getClassLoader().getResource(
			"images/zj_zd_daoju.png"));
	Image dj_zd1 = tk.getImage(demo.class.getClassLoader().getResource(
			"images/dj_zd.png"));
	Image boss_zd1 = tk.getImage(demo.class.getClassLoader().getResource(
			"images/boss_zd.png"));
	
	
	Image zidan_images;
	
	public zidan(int zd_x,int zd_y){
		this.zd_x = zd_x;
		this.zd_y = zd_y;
	}
	
	public void zj_move() {
		zd_y -= 10;
	}
	
	public void use_zd_daoju_zj_move_left(){
		zd_x-=1;
		zd_y-=10;
	}
	
	public void use_zd_daoju_zj_move_right(){
		zd_x+=1;
		zd_y-=10;
	}
	
	public void dj_move() {
		zd_y += 10;
	}
	
	public void boss_move() {
		zd_y += 20;
	}
	
	public void zj_Draw(Graphics g){
		g.drawImage(zj_zd, zd_x, zd_y, zd_width, zd_height, null);
		zj_move();
	}
	
	public void use_zd_daoju_zj_Draw_left(Graphics g){
		g.drawImage(zj_zd_daoju, zd_x, zd_y, zd_width, zd_height, null);
		use_zd_daoju_zj_move_left();
	}
	
	public void use_zd_daoju_zj_Draw_right(Graphics g){
		g.drawImage(zj_zd_daoju, zd_x, zd_y, zd_width, zd_height, null);
		use_zd_daoju_zj_move_right();
	}
	
	public void dj_Draw(Graphics g) {
		g.drawImage(dj_zd1, zd_x, zd_y, zd_width, zd_height, null);
		dj_move();
	}
	
	public void boss_Draw(Graphics g) {
		g.drawImage(boss_zd1, zd_x-9, zd_y+40, zd_width, zd_height, null);
		boss_move();
	}
	
	public Rectangle getRec() {
		return new Rectangle(zd_x, zd_y, 20, 30);
	}
}
