package org.game.client;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Window extends JFrame {
	
	Dimension screenSize;
	private int width;
	private int height;
	private static final long serialVersionUID = -4369730830015653927L;
	
	public Window() {
		
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int) screenSize.getWidth();
		height = (int) screenSize.getHeight();
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
		pack();
	}
	
	

}
