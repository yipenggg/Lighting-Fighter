package 雷霆战机;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;

public class demo extends Frame {

	zj zj = new zj(170, 530);
	boss b = null;

	int zj_x = zj.getX(), zj_y = zj.getY(), bg_y = 0, zj_hp, life,
			boss_hp = 200, score = 0, imagesNum = 0, diji_imagesNum = 0,boom_imagesNum=0,
			timers = 0,qp_daojuNum=0,zd_daojuNum=0,zd_daojuTimer=100;

	ArrayList zj_zdarraylist = new ArrayList();
	ArrayList zj_zd_daoju_leftarraylist = new ArrayList();
	ArrayList zj_zd_daoju_rightarraylist = new ArrayList();
	ArrayList dj_zdarraylist = new ArrayList();
	ArrayList boss_zdarraylist = new ArrayList();
	ArrayList dj1arraylist = new ArrayList();
	Random ra = new Random();
	boolean up = false, down = false, left = false, right = false,
			space = false, flag = false,isqp_daoju=true,issm_daoju=true,iszd_daoju=true
			,use_zd_daoju=false,iswin=false,onlife=false;

	Toolkit tk = Toolkit.getDefaultToolkit();

	Image bg1 = tk.getImage(demo.class.getClassLoader().getResource(
			"images/bg1.png"));
	Image bg2 = tk.getImage(demo.class.getClassLoader().getResource(
			"images/bg2.jpg"));
	Image bg3 = tk.getImage(demo.class.getClassLoader().getResource(
			"images/bg3.png"));
	
	Image[] images = { bg1, bg2, bg3 };
	
	Image boss1 = tk.getImage(demo.class.getClassLoader().getResource(
			"images/boss1.png"));
	Image boss2 = tk.getImage(demo.class.getClassLoader().getResource(
			"images/boss2.png"));
	Image boss3 = tk.getImage(demo.class.getClassLoader().getResource(
			"images/boss3.png"));

	Image dj1 = tk.getImage(demo.class.getClassLoader().getResource(
			"images/dj1.png"));
	Image dj2 = tk.getImage(demo.class.getClassLoader().getResource(
			"images/dj2.png"));
	Image dj3 = tk.getImage(demo.class.getClassLoader().getResource(
			"images/dj3.png"));
	
	Image[] diji_images = { dj1, dj2, dj3 };
	
	Image bz1 = tk.getImage(demo.class.getClassLoader().getResource(
			"images/bz1.png"));
	Image bz2 = tk.getImage(demo.class.getClassLoader().getResource(
			"images/bz2.png"));
	Image bz3 = tk.getImage(demo.class.getClassLoader().getResource(
			"images/bz3.png"));
	
	Image[] boom_images = { bz1, bz2, bz3 };
	
	Image sm_dj = tk.getImage(demo.class.getClassLoader().getResource(
			"images/sm_dj.png"));
	Image qp_dj = tk.getImage(demo.class.getClassLoader().getResource(
			"images/qp_dj.gif"));
	Image zd_dj = tk.getImage(demo.class.getClassLoader().getResource(
			"images/zd_dj.png"));

	public void start() {
		this.setTitle("雷霆战机");
		this.setSize(400, 600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		this.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});

		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					up = true;
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					down = true;
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					left = true;
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					right = true;
				}

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					flag = true;
					// type = false;
					GameSound gs = new GameSound();
					gs.playBgSound("HalfSpeed.mp3");
					if (onlife) {
						zj = null;
						onlife = false;
						zj = new zj(170, 530);
						zj_hp = 100;
						life = 3;
						// imagesNum=0;
						diji_imagesNum = 0;
						boom_imagesNum = 0;
						b = null;
						score = 0;
						dj1arraylist.clear();
						dj_zdarraylist.clear();
						zj_zdarraylist.clear();
						boss_zdarraylist.clear();
					}
				}

				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					space = true;
					// type = false;
					GameSound gs = new GameSound();
					gs.playSound("fashe_1.mp3");
					zidan zj_zd = new zidan(zj.getX() + 26, zj.getY() - 25);
					zj_zdarraylist.add(zj_zd);
					if (use_zd_daoju == true) {
						zd_daojuTimer--;
						if (zd_daojuTimer >= 0) {
							zidan zd_daoju_left = new zidan(zj.getX(),
									zj.getY() - 25);
							zj_zd_daoju_leftarraylist.add(zd_daoju_left);
							zidan zd_daoju_right = new zidan(zj.getX() + 50,
									zj.getY() - 25);
							zj_zd_daoju_rightarraylist.add(zd_daoju_right);
						}
					}
				}

				if (e.getKeyCode() == KeyEvent.VK_A) {
					if (qp_daojuNum != 0) {
						dj1arraylist.clear();
						dj_zdarraylist.clear();
						qp_daojuNum = 0;
					}
				}

				if (e.getKeyCode() == KeyEvent.VK_S) {
					if (zd_daojuNum != 0) {
						use_zd_daoju = true;
						zd_daojuNum = 0;
					}
				}
			}

			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					up = false;
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					down = false;
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					left = false;
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					right = false;
				}

				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					space = false;
				}
			}
		});

		myThread mt = new myThread();
		mt.start();
	}
	daoju sm_daoju = new daoju(sm_dj, 100, 100);
	daoju qp_daoju = new daoju(qp_dj, 200, 100);
	daoju zd_daoju = new daoju(zd_dj, 300, 100);
	
	public void paint(Graphics g) {
		g.drawImage(images[imagesNum], 0, bg_y, 400, 600, null);
		g.drawImage(images[imagesNum], 0, bg_y - 600, 400, 600, null);
		g.setColor(Color.red);
		g.setFont(new Font("宋体", Font.BOLD, 25));
		g.drawString("生命数：" + life, 10, 580);
		g.drawString("生命值：" + zj_hp, 10, 550);
		g.drawString("得分：" + score, 250, 580);
		g.drawString("清屏道具", 10, 525);
		g.drawImage(qp_dj, 120, 500, 30, 30, null);
		g.drawString("X" + qp_daojuNum, 155, 525);
		g.drawString("子弹道具", 10, 500);
		g.drawImage(zd_dj, 120, 475, 30, 30, null);
		g.drawString("X"+zd_daojuNum, 155, 500);
		
		
		if (flag == false) {
			g.setColor(Color.red);
			g.setFont(new Font("宋体", Font.BOLD, 30));
			g.drawString("键入Enter开始游戏", 70, 300);
			g.setFont(new Font("宋体", Font.BOLD, 20));
			g.drawString("游戏说明：", 10, 50);
			g.drawString("捡到清屏道具", 10, 70);
			g.drawImage(qp_dj, 135, 50, 25, 25, null);
			g.drawString("按a使用", 160, 70);
			g.drawString("捡到子弹道具", 10, 90);
			g.drawImage(zd_dj, 135, 70, 25, 25, null);
			g.drawString("按s使用", 160, 90);
			g.drawString("捡到生命道具", 10, 110);
			g.drawImage(sm_dj, 135, 90, 25, 25, null);
			g.drawString("自动加一条生命", 160, 110);
			zj_hp = 100;
			life = 3;
		}
		
		if (life <= 0) {
			b = null;
			zj_hp = 0;
			zj_zdarraylist.clear();
			dj_zdarraylist.clear();
			dj1arraylist.clear();
			onlife=true;
//			enter=false;
//			if(enter==false){
			g.drawString("游戏结束！", 150, 280);
			g.drawString("键入Enter重新开始游戏", 70, 310);
//			}
			//flag = false;
		}
		if (flag == true && !onlife) {
			// move();
			zj.Draw(g, up, down, left, right);

			if (bg_y >= 600) {
				bg_y = 0;
			}
			bg_y += 5;

			if (zj_hp <= 0 && life > 0) {
				zj_hp = 100;
				life--;
			}

			if (diji_imagesNum == 0 && ra.nextInt(100) > 95) {
				diji d = new diji(diji_images[diji_imagesNum],
						ra.nextInt(380) + 10, 0);
				dj1arraylist.add(d);
			} else if (diji_imagesNum == 1 && ra.nextInt(100) > 95) {
				diji d = new diji(diji_images[diji_imagesNum],
						ra.nextInt(380) + 10, 0);
				dj1arraylist.add(d);
			} else if (diji_imagesNum == 2 && ra.nextInt(100) > 95) {
				diji d = new diji(diji_images[diji_imagesNum],
						ra.nextInt(380) + 10, 0);
				dj1arraylist.add(d);
			}

			if (b == null && iswin == false) {
				timers++;
				if (score>200 && timers > 300 && imagesNum == 0) {
					timers = 0;
					b = new boss(boss1, 160, 30);
					zidan boss1_zd = new zidan(b.getX(), b.getY());
					boss_zdarraylist.add(boss1_zd);
				} else if (score>600 && timers > 500 && imagesNum == 1) {
					timers = 0;
					b = new boss(boss2, 150, 30);
					zidan boss2_zd = new zidan(b.getX(), b.getY());
					boss_zdarraylist.add(boss2_zd);
				} else if (score>2000 && timers > 500 && imagesNum == 2) {
					b = new boss(boss3, 150, 30);
					zidan boss3_zd = new zidan(b.getX(), b.getY());
					boss_zdarraylist.add(boss3_zd);
				}
			}
			if (b != null) {
				b.Draw(g);
				g.fillRect(b.getX(), b.getY()-15, boss_hp, 15);
				if (b.zds == true) {
					zidan boss1_zd = b.shoot();
					boss_zdarraylist.add(boss1_zd);
				}
				for (int i = 0; i < boss_zdarraylist.size(); i++) {
					zidan boss_zd = (zidan) boss_zdarraylist.get(i);
					boss_zd.boss_Draw(g);
				}

				// 战机子弹和boss的碰撞
				Rectangle rec_boss1 = b.getRec();

				for (int i = 0; i < zj_zdarraylist.size(); i++) {
					zidan zj_zd = (zidan) zj_zdarraylist.get(i);
					Rectangle rec2 = zj_zd.getRec();

					if (rec_boss1.intersects(rec2)) {
						boss_hp -= 5;
						score += 20;
						zj_zdarraylist.remove(i);
					}
				}
				
				Rectangle rec_boss2 = b.getRec();

				for (int i = 0; i < zj_zd_daoju_leftarraylist.size(); i++) {
					zidan zj_zd_daoju = (zidan) zj_zd_daoju_leftarraylist.get(i);
					Rectangle rec2 = zj_zd_daoju.getRec();

					if (rec_boss2.intersects(rec2)) {
						boss_hp -= 5;
						score += 30;
						zj_zd_daoju_leftarraylist.remove(i);
					}
				}
				
				Rectangle rec_boss3 = b.getRec();

				for (int i = 0; i < zj_zd_daoju_rightarraylist.size(); i++) {
					zidan zj_zd_daoju = (zidan) zj_zd_daoju_rightarraylist.get(i);
					Rectangle rec2 = zj_zd_daoju.getRec();

					if (rec_boss3.intersects(rec2)) {
						boss_hp -= 5;
						score += 30;
						zj_zd_daoju_rightarraylist.remove(i);
					}
				}

				// //战机和boss碰撞
				// Rectangle rec_boss2 = b.getRec();
				//
				// for (int i = 0; i < zj_zdarraylist.size(); i++) {
				// zidan zj_zd = (zidan) zj_zdarraylist.get(i);
				// Rectangle rec2 = zj_zd.getRec();
				//
				// if (rec_boss.intersects(rec2)) {
				// boss_hp-=10;
				// zj_zdarraylist.remove(i);
				// }
				// }
			}
			if (boss_hp <= 0 && imagesNum == 0) {
				b = null;
				boss_hp=400;
				GameSound gs = new GameSound();
				gs.playSound("bz.mp3");
				imagesNum++;       
				diji_imagesNum++;
				boom_imagesNum++;
				boss_hp = 500;
				dj1arraylist.clear();
				dj_zdarraylist.clear();
				zj_zdarraylist.clear();
			} else if (boss_hp <= 0 && imagesNum == 1) {
				b = null;
				boss_hp=1000;
				GameSound gs = new GameSound();
				gs.playSound("bz.mp3");
				imagesNum++;
				diji_imagesNum++;
				boom_imagesNum++;
				boss_hp = 300;
				dj1arraylist.clear();
				dj_zdarraylist.clear();
				zj_zdarraylist.clear();
			} else if (boss_hp <= 0 && imagesNum == 2) {
				b = null;
				iswin=true;
//				GameSound gs = new GameSound();
//				gs.playSound("bz.mp3");
				dj1arraylist.clear();
				zj_zdarraylist.clear();
				dj_zdarraylist.clear();
				boss_zdarraylist.clear();
				g.drawString("恭喜你已成功通关！", 100, 280);
				g.drawString("你的分数是："+score, 100, 310);
				zj.zj_y -= 10;
//				type = true;
//				flag=false;
			}

			for (int i = 0; i < zj_zdarraylist.size(); i++) {
				zidan zd = (zidan) zj_zdarraylist.get(i);
				zd.zj_Draw(g);
			}

			for (int i = 0; i < dj1arraylist.size(); i++) {
				diji dj = (diji) dj1arraylist.get(i);
				dj.Draw(g);
				if (dj.zds == true) {
					zidan dj_zd = dj.shoot();
					dj_zdarraylist.add(dj_zd);
				}
			}

			for (int i = 0; i < dj_zdarraylist.size(); i++) {
				zidan zd = (zidan) dj_zdarraylist.get(i);
				zd.dj_Draw(g);
			}
		}

		// 战机子弹和敌机的碰撞
		for (int i = 0; i < zj_zdarraylist.size(); i++) {
			zidan z = (zidan) zj_zdarraylist.get(i);
			z.zj_Draw(g);

			Rectangle rec1 = z.getRec();

			for (int j = 0; j < dj1arraylist.size(); j++) {
				diji d = (diji) dj1arraylist.get(j);
				Rectangle rec2 = d.getRec();

				if (rec1.intersects(rec2)) {
					zj_zdarraylist.remove(i);
					dj1arraylist.remove(j);
					GameSound gs = new GameSound();
					gs.playSound("bz.mp3");
					if (boom_imagesNum == 0) {
						boom b = new boom(boom_images[boom_imagesNum],
								d.getX() + 5, d.getY() - 10);
						b.Draw(g);
					} else if (boom_imagesNum == 1) {
						boom b = new boom(boom_images[boom_imagesNum],
								d.getX() + 5, d.getY() - 10);
						b.Draw(g);
					} else if (boom_imagesNum == 2) {
						boom b = new boom(boom_images[boom_imagesNum],
								d.getX() + 5, d.getY() - 10);
						b.Draw(g);
					}

					score += 10;
				}
			}
		}

		// 战机和敌机子弹的碰撞
		Rectangle rec_zj1 = zj.getRec();

		for (int j = 0; j < dj_zdarraylist.size(); j++) {
			zidan dj_zd = (zidan) dj_zdarraylist.get(j);
			Rectangle rec2 = dj_zd.getRec();

			if (rec_zj1.intersects(rec2)) {
				zj_hp -= 5;
				dj_zdarraylist.remove(j);
			}

		}
		// 战机和敌机碰撞
		Rectangle rec_zj2 = zj.getRec();

		for (int j = 0; j < dj1arraylist.size(); j++) {
			diji d = (diji) dj1arraylist.get(j);
			Rectangle rec2 = d.getRec();

			if (rec_zj2.intersects(rec2)) {
				zj_hp -= 5;
				dj1arraylist.remove(j);
				GameSound gs = new GameSound();
				gs.playSound("bz.mp3");
				if (boom_imagesNum == 0) {
					boom b = new boom(boom_images[boom_imagesNum],
							d.getX() + 5, d.getY() - 10);
					b.Draw(g);
				} else if (boom_imagesNum == 1) {
					boom b = new boom(boom_images[boom_imagesNum],
							d.getX() + 5, d.getY() - 10);
					b.Draw(g);
				} else if (boom_imagesNum == 2) {
					boom b = new boom(boom_images[boom_imagesNum],
							d.getX() + 5, d.getY() - 10);
					b.Draw(g);
				}
			}
		}

		// 战机和boss子弹的碰撞
		Rectangle rec_zj3 = zj.getRec();

		for (int i = 0; i < boss_zdarraylist.size(); i++) {
			zidan dj_zd = (zidan) boss_zdarraylist.get(i);
			Rectangle rec2 = dj_zd.getRec();

			if (rec_zj3.intersects(rec2)) {
				zj_hp -= 10;
				boss_zdarraylist.remove(i);
			}
		}
		
		for (int i = 0; i < zj_zd_daoju_leftarraylist.size(); i++) {
			zidan z = (zidan) zj_zd_daoju_leftarraylist.get(i);
			z.use_zd_daoju_zj_Draw_left(g);

			Rectangle rec1 = z.getRec();

			for (int j = 0; j < dj1arraylist.size(); j++) {
				diji d = (diji) dj1arraylist.get(j);
				Rectangle rec2 = d.getRec();

				if (rec1.intersects(rec2)) {
					zj_zd_daoju_leftarraylist.remove(i);
					dj1arraylist.remove(j);
					GameSound gs = new GameSound();
					gs.playSound("bz.mp3");
					if (boom_imagesNum == 0) {
						boom b = new boom(boom_images[boom_imagesNum],
								d.getX() + 5, d.getY() - 10);
						b.Draw(g);
					} else if (boom_imagesNum == 1) {
						boom b = new boom(boom_images[boom_imagesNum],
								d.getX() + 5, d.getY() - 10);
						b.Draw(g);
					} else if (boom_imagesNum == 2) {
						boom b = new boom(boom_images[boom_imagesNum],
								d.getX() + 5, d.getY() - 10);
						b.Draw(g);
					}

					score += 10;
				}
			}
		}
		
		for (int i = 0; i < zj_zd_daoju_rightarraylist.size(); i++) {
			zidan z = (zidan) zj_zd_daoju_rightarraylist.get(i);
			z.use_zd_daoju_zj_Draw_right(g);;

			Rectangle rec1 = z.getRec();

			for (int j = 0; j < dj1arraylist.size(); j++) {
				diji d = (diji) dj1arraylist.get(j);
				Rectangle rec2 = d.getRec();

				if (rec1.intersects(rec2)) {
					zj_zd_daoju_rightarraylist.remove(i);
					dj1arraylist.remove(j);
					GameSound gs = new GameSound();
					gs.playSound("bz.mp3");
					if (boom_imagesNum == 0) {
						boom b = new boom(boom_images[boom_imagesNum],
								d.getX() + 5, d.getY() - 10);
						b.Draw(g);
					} else if (boom_imagesNum == 1) {
						boom b = new boom(boom_images[boom_imagesNum],
								d.getX() + 5, d.getY() - 10);
						b.Draw(g);
					} else if (boom_imagesNum == 2) {
						boom b = new boom(boom_images[boom_imagesNum],
								d.getX() + 5, d.getY() - 10);
						b.Draw(g);
					}

					score += 10;
				}
			}
		}


		if (life <= 2 && issm_daoju == true) {
			
			sm_daoju.Draw(g);
			// 战机和生命道具的碰撞
			Rectangle rec_zj4 = zj.getRec();

			Rectangle rec2 = sm_daoju.getRec();

			if (rec_zj4.intersects(rec2)) {
				life++;
				issm_daoju = false;
			}
		}

		if (score >= 600 && isqp_daoju == true) {
			
			qp_daoju.Draw(g);
			// 战机和清屏道具的碰撞
			Rectangle rec_zj5 = zj.getRec();

			Rectangle rec2 = qp_daoju.getRec();

			if (rec_zj5.intersects(rec2)) {
				qp_daojuNum++;
				isqp_daoju = false;
			}
		}

		if (score >= 500 && iszd_daoju == true) {
			
			zd_daoju.Draw(g);
			// 战机和子弹道具的碰撞
			Rectangle rec_zj6 = zj.getRec();

			Rectangle rec2 = zd_daoju.getRec();

			if (rec_zj6.intersects(rec2)) {
				zd_daojuNum=1;
				iszd_daoju = false;
			}
		}
			for (int i = 0; i < zj_zd_daoju_leftarraylist.size(); i++) {
				zidan zd_daoju = (zidan) zj_zd_daoju_leftarraylist.get(i);
				zd_daoju.use_zd_daoju_zj_Draw_left(g);
			}
			for (int i = 0; i < zj_zd_daoju_rightarraylist.size(); i++) {
				zidan zd_daoju = (zidan) zj_zd_daoju_rightarraylist.get(i);
				zd_daoju.use_zd_daoju_zj_Draw_right(g);		
				}
	}

	Image im_bg = null;

	public void update(Graphics g) {
		if (im_bg == null) {
			im_bg = this.createImage(400, 600);
		}
		Graphics bg = im_bg.getGraphics();
		paint(bg);

		g.drawImage(im_bg, 0, 0, 400, 600, null);
	}

	class myThread extends Thread {
		public void run() {
			while (true) {
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		demo d = new demo();
		d.start();
	}
}
