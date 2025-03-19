package com.brainmentors.gaming.sprites;

//import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Enemy extends Sprite{
	
	
	public Enemy(int x, int speed) {
		y=30;
		this.x=x; // this matlab jo parent se aaya hai
		this.speed=speed;
		w=200;
		h=200;
		image=new ImageIcon(Enemy.class.getResource("spider.gif"));
	
		
	}
	public void move() {
		if(y>860) {
			 y=0;
		}
		y=y+speed;
	}
	

}
