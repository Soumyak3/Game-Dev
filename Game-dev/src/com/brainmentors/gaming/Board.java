package com.brainmentors.gaming;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.brainmentors.gaming.sprites.Enemy;
import com.brainmentors.gaming.sprites.Player;

public class Board extends JPanel{
	
	Timer timer;
	BufferedImage backgroundImage; // to store image
	Player player;
	Enemy enemies[]= new Enemy[3];
	
	
	public Board() {
		setSize(1500,870);
		loadBackgroundImage();
		player=new Player();
		loadEnemies();
		gameLoop();
		
		bindEvents();
		setFocusable(true);
		
		
		
		
	}
	
	private void gameOver(Graphics pen) 
	{   if (player.outOfScreen()) {
		pen.setFont(new Font("times", Font.BOLD , 30));
		pen.setColor(Color.RED);
		pen.drawString("Game Win", 1500/2,870/2);
		timer.stop();
		return;
	}
		for(Enemy enemy : enemies) {
			if(isCollide(enemy)) {
				pen.setFont(new Font("times", Font.BOLD , 30));
				pen.setColor(Color.RED);
				pen.drawString("Game Over", 1500/2,870/2);
				timer.stop();
			}
		}
		}
	
	private boolean isCollide(Enemy enemy) {
		int xDistance =	 Math.abs(player.x - enemy.x);
		int yDistance = Math.abs(player.y - enemy.y);
		int maxH= Math.max(player.h, enemy.h);
		int maxW= Math.max(player.w, enemy.w);
		return xDistance <= maxW-80 && yDistance <= maxH-80;
//		for(Enemy enemy : enemies) {
			
		
	}
	
	private void bindEvents() {
		addKeyListener (new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				
			}


			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
					player.speed=10;
				// TODO Auto-generated method stub
				}
				else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
					player.speed=-5;
					
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				player.speed=0;
				// TODO Auto-generated method stub
				}
		});
		
	}
	private void loadEnemies() {
		int x= 400;
		int gap=350;
		int speed=5;
		for(int i=0 ; i<enemies.length ; i++) {
			enemies[i]= new Enemy(x, speed);
			x=x+gap;
			speed=speed+5;
			
		}
	}
	
	
	
	
	private void gameLoop() {
		timer=new Timer(50,(e)->repaint());
		timer.start();
	}
	
	private void loadBackgroundImage() {
		
		try {
			backgroundImage = ImageIO.read(Board.class.getResource("game bg.jpg"));
		} catch (IOException e) {
			System.out.println("Background image not found...");
			System.exit(1);
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
	
		
	}
	private void printEnemies(Graphics pen) {
		for(Enemy enemy : enemies) {
			enemy.draw(pen);
			enemy.move();
			
		}
	} 
	
	
	
	public void paintComponent(Graphics pen) { 
		//all printing logic will be here
		super.paintComponent(pen); // clean up
		pen.drawImage(backgroundImage,0,0,1500,900,null);
		player.draw(pen);
		player.move();
		printEnemies(pen);
		gameOver(pen);
	}
	

}
