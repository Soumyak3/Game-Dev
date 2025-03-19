package com.brainmentors.gaming;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
	
	Board board= new Board();

	public  GameFrame() {
		Board board=new Board();
		//this has the calling address (in this case of frame)
		//it is optional to call this and java calls it automatically
		// if writing in main in which "frame" object is called write"frame." and continue
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setTitle("Game Dev in Java");
        setSize(1500,900);
        setResizable(false);
        setLocationRelativeTo(null);
        add(board);
        setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Board board= new Board();
//        GameFrame frame= new GameFrame();
		new GameFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setTitle("Game Dev in Java");
//        frame.setSize(1500,900);
//        frame.setResizable(false);
//        frame.setLocationRelativeTo(null);
//        frame.add(board);
//         frame.setVisible(true);
        
	}

	

}
