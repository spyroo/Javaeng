package org.engine.client;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Window extends JFrame {

	public static enum SCREEN_CONFIG {FULLSCREEN, WINDOWED, BORDERLESS_WINDOWED};
	
	private static final long serialVersionUID = -8266163970188368677L;
	private GraphicsEnvironment ge;
	private GraphicsDevice defaultDevice;
	private RenderFrame frame;
	private SCREEN_CONFIG windowType;

	protected Window(SCREEN_CONFIG mode) {
		ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		defaultDevice = ge.getDefaultScreenDevice();
		windowType = mode;
	}

	public void init(String title) {
		if(windowType == SCREEN_CONFIG.FULLSCREEN){
			defaultDevice.setFullScreenWindow(this);
		}else if(windowType == SCREEN_CONFIG.BORDERLESS_WINDOWED){
			setUndecorated(true);
		}
		setPreferredSize(new Dimension(defaultDevice.getDefaultConfiguration().getBounds().width, defaultDevice.getDefaultConfiguration().getBounds().height));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setTitle(title);
		pack();
	}
	
	public void setRenderFrame(RenderFrame frame){
		this.frame = frame;
		getContentPane().add(frame);
	}
	
	public RenderFrame getRenderFrame(){
		return frame;
	}
	
}
