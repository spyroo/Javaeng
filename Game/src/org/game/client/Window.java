package org.game.client;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Window extends JFrame implements Runnable, KeyListener{
	
	private Dimension screenSize;
	private int width;
	private int height;
	private static final long serialVersionUID = -4369730830015653927L;
	private GameRender gameRender;
	private ArrayList<Character> currentKeys;
	
	public Window() {
		
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int) screenSize.getWidth();
		height = (int) screenSize.getHeight();
		gameRender = new GameRender();
		System.out.println(width + ":" + height);
		init();
	}
	
	/**
	 * Initialize the window
	 */
	public void init(){
		setPreferredSize(new Dimension(width, height));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setUndecorated(true);
		setVisible(true);
		add(gameRender);
		addKeyListener(this);
		pack();
	}

	@Override
	public void run() {
		long lastFrameTime = System.currentTimeMillis();
		while(true){
			if(System.currentTimeMillis() - lastFrameTime > 1000/60){
				gameRender.repaint();
				lastFrameTime = System.currentTimeMillis();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		currentKeys.add(arg0.getKeyChar());
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		currentKeys.remove(arg0.getKeyChar());
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
