package org.engine.client;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Window extends JFrame {

	private static final long serialVersionUID = -8266163970188368677L;
	private Dimension screenSize;
	private int width;
	private int height;
	private RenderFrame frame;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem itemOptions;

	protected Window() {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int) screenSize.getWidth();
		height = (int) screenSize.getHeight();
	}

	public void init(String title) {
		setPreferredSize(new Dimension(width, height));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setUndecorated(true);
		setVisible(true);
		setTitle(title);
		pack();
	}
	
	public void setRenderFrame(RenderFrame frame){
		this.frame = frame;
		add(frame);
	}
	
	public RenderFrame getRenderFrame(){
		return frame;
	}
	
}
