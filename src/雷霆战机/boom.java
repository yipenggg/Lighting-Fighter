package À×öªÕ½»ú;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class boom {
	int boom_x,boom_y;
	int width=50,height=50;
	
//	Toolkit tk = Toolkit.getDefaultToolkit();
//
//	Image bz1 = tk.getImage(demo.class.getClassLoader().getResource(
//			"images/bz1.png"));
	Image boom_im;
	
	public boom(Image boom_im,int boom_x,int boom_y){
		this.boom_im = boom_im;
		this.boom_x=boom_x;
		this.boom_y=boom_y;
	}
	
	public void Draw(Graphics g){
		g.drawImage(boom_im, boom_x, boom_y, width, height,null);
	}

}
