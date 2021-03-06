package org.javaeng.core;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.swing.JFrame;


public class Window extends JFrame implements KeyListener{

	public static enum SCREEN_CONFIG {
		FULLSCREEN, WINDOWED, BORDERLESS_WINDOWED
	};

	private static final long serialVersionUID = -8266163970188368677L;
	private GraphicsEnvironment ge;
	private GraphicsDevice defaultDevice;
	private RenderFrame frame;
	private SCREEN_CONFIG windowType;
	private int width;
	private int height;
	private boolean isMac;

	/**
	 * Protected Constructor for <code>Window</code> used to create a
	 * <code>Window</code> object. Only to be used by <code>Engine</code> <br />
	 * <br />
	 * To get an instance of <code>Window</code> use
	 * <code>Engine.getWindowInstance(Window.SCREEN_CONFIG)</code>
	 * 
	 * @param mode
	 *            The <code>SCREEN_CONFIG</code> to create the window with
	 * @param width
	 *            The width of the <code>Window</code> to be created, ignored if
	 *            <code>SCREEN_CONFIG</code> is <code>BORDERLESS_WINDOWED</code>
	 * @param height
	 *            The height of the <code>Window</code> to be created, ignored
	 *            if <code>SCREEN_CONFIG</code> is
	 *            <code>BORDERLESS_WINDOWED</code>
	 */
	
	protected Window(SCREEN_CONFIG mode, int width, int height) {
		ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		defaultDevice = ge.getDefaultScreenDevice();
		windowType = mode;
		this.width = width;
		this.height = height;
		if(System.getProperty("os.name").contains("Mac")){
			isMac = true;
		}
	}

	/**
	 * Used to initialize the window, make sure to call
	 * <code>super.init()</code> first thing when overriding, or the proper
	 * screen type will not be used.
	 * 
	 * @param title
	 *            Title of the window to be initialize
	 */
	public void init(String title) {
		
		setResizable(false);
		setUndecorated(true);

		if (windowType == SCREEN_CONFIG.FULLSCREEN) {
			if(isMac){
				addKeyListener(this);
			}
			setPreferredSize(new Dimension((int) getScreenBounds(this).getWidth(), (int) getScreenBounds(this).getHeight()));
			defaultDevice.setFullScreenWindow(this);
			validate();
		} else if (windowType == SCREEN_CONFIG.BORDERLESS_WINDOWED) {
			setPreferredSize(new Dimension((int) getScreenBounds(this).getWidth(), (int) getScreenBounds(this).getHeight()));
		} else {
			setUndecorated(false);
			setResizable(true);
			setPreferredSize(new Dimension(width, height));
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle(title);
		pack();
	}

	/**
	 * Adds the <code>RenderFrame</code> as the current <code>RenderFrame</code>
	 * for updating after removing the current <code>RenderFrame</code>
	 * 
	 * @param frame
	 *            The <code>RenderFrame</code> to be added
	 */
	public void setRenderFrame(RenderFrame frame) {
		if (this.frame != null)
			getContentPane().remove(this.frame);
		this.frame = frame;
		add(frame);
		addMouseListener((MouseListener) frame);
	}

	/**
	 * Gets the current <code>RenderFrame</code> being used to render
	 * 
	 * @return The current <code>RenderFrame</code>
	 */
	public RenderFrame getRenderFrame() {
		return frame;
	}

	/**
	 * Gets the current <code>SCREEN_CONFIG</code> the <code>Window</code> is
	 * using
	 * 
	 * @return
	 */
	public SCREEN_CONFIG getScreenConfig() {
		return windowType;
	}
	
	/**
	 * Gets the screen bounds of the main window
	 * @param wnd The window
	 * @return
	 */
	public Rectangle getScreenBounds(Window wnd) {
		Rectangle sb;
		Insets si = getScreenInsets(wnd);

		if (wnd == null) {
			sb = GraphicsEnvironment.getLocalGraphicsEnvironment()
					.getDefaultScreenDevice().getDefaultConfiguration()
					.getBounds();
		} else {
			sb = wnd.getGraphicsConfiguration().getBounds();
		}

		sb.x += si.left;
		sb.y += si.top;
		
		sb.width -= si.left + si.right;
		return sb;
	}

	public Insets getScreenInsets(Window wnd) {
		Insets si;

		if (wnd == null) {
			si = Toolkit.getDefaultToolkit()
					.getScreenInsets(
							GraphicsEnvironment.getLocalGraphicsEnvironment()
									.getDefaultScreenDevice()
									.getDefaultConfiguration());
		} else {
			si = wnd.getToolkit().getScreenInsets(wnd.getGraphicsConfiguration());
		}
		return si;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_ESCAPE){
			System.exit(0);
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	public int getScreenWidth(){
		return (int) getScreenBounds(this).getWidth();
	}
	public int getScreenHeight(){
		return (int) getScreenBounds(this).getHeight();
	}
	

}
