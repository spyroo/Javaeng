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
	
	/**
	 * Protected Constructor for <code>Window</code> used to create a <code>Window</code> object. Only to be used by <code>Engine</code>
	 * <br />
	 * <br />
	 * To get an instance of <code>Window</code> use <code>Engine.getWindowInstance(Window.SCREEN_CONFIG)</code>
	 * 
	 * @param mode The <code>SCREEN_CONFIG</code> to create the window with
	 */
	protected Window(SCREEN_CONFIG mode) {
		ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		defaultDevice = ge.getDefaultScreenDevice();
		windowType = mode;
	}
	
	/**
	 * Used to initialize the window, make sure to call <code>super.init()</code> first thing when overriding, or the proper screen type will not be used.
	 * 
	 * @param title Title of the window to be initialize
	 */
	public void init(String title) {
		if(windowType == SCREEN_CONFIG.FULLSCREEN){
			defaultDevice.setFullScreenWindow(this);
		}else if(windowType == SCREEN_CONFIG.BORDERLESS_WINDOWED){
			setUndecorated(true);
			setResizable(false);
		}else{
			setResizable(true);
		}
		setPreferredSize(new Dimension(defaultDevice.getDefaultConfiguration().getBounds().width, defaultDevice.getDefaultConfiguration().getBounds().height));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle(title);
		pack();
	}
	
	/**
	 * Adds the <code>RenderFrame</code> as the current <code>RenderFrame</code> for updating after removing the current <code>RenderFrame</code>
	 * @param frame The <code>RenderFrame</code> to be added
	 */
	public void setRenderFrame(RenderFrame frame){
		if(this.frame != null)
			getContentPane().remove(this.frame);
		this.frame = frame;
		getContentPane().add(frame);
	}
	/**
	 * Gets the current <code>RenderFrame</code> being used to render
	 * @return The current <code>RenderFrame</code>
	 */
	public RenderFrame getRenderFrame(){
		return frame;
	}
	
	/**
	 * Gets the current <code>SCREEN_CONFIG</code> the <code>Window</code> is using
	 * @return
	 */
	public SCREEN_CONFIG getScreenConfig(){
		return windowType;
	}
	
}
