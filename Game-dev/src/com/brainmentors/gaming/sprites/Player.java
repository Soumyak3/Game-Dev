package com.brainmentors.gaming.sprites;

//import java.awt.Graphics;


import javax.swing.ImageIcon;

public class Player extends Sprite{
	
	 
	public Player() {
		x= 50;
		y=450;
		w=200;
		h=200;
		image= new ImageIcon(Player.class.getResource("boyingame.gif"));
	}
	public void move() {
		x=x+speed;
	}
	public boolean outOfScreen() {
		return x>1400;
	}
	
}
