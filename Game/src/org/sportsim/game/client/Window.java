package org.sportsim.game.client;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Window extends JFrame {
	
	private JFrame frame = new JFrame();
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int width = (int) screenSize.getWidth();
	private int height = (int) screenSize.getHeight();
	private static final long serialVersionUID = -4369730830015653927L;
	
	public Window() {
		
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}

}
