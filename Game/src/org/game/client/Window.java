package org.game.client;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class Window extends JFrame implements Runnable, KeyListener, MouseListener {

	private Dimension screenSize;
	private int width;
	private int height;
	private static final long serialVersionUID = -4369730830015653927L;
	private GameRender gameRender;
	private Controller controller;
	private SoundManager soundManager;
	private static final String WINDOW_TITLE = "Sport sim alpha";
	private Sound s;

	public Window() {
		s = new Sound("pacman_eatghost.wav");
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int) screenSize.getWidth();
		height = (int) screenSize.getHeight();
		gameRender = new GameRender();
		soundManager = new SoundManager();
		controller = new Controller(gameRender);
		System.out.println(width + ":" + height);
		init();
		
		
		gameRender.addItemToRender(new GuiItemInteractable("button1", new BoundingBox(50, 50, 350, 200), new Texture("league.jpeg"), new GuiActionListener() {
			@Override
			public void actionPreformed(String id) {
				soundManager.addSound(s);
				System.out.println("Button " + id + " was pressed");
				gameRender.removeItemByID("button1");
			}
		}));
		gameRender.addItemToRender(new GuiItemInteractable("button2", new BoundingBox(500, 302, 350, 200), new Texture("dota.png"), new GuiActionListener() {
			@Override
			public void actionPreformed(String id) {
				System.out.println("Button " + id + " was pressed");
			}
		}));
		
	}

	/**
	 * Initialize the window
	 */
	
	public void init() {
		setPreferredSize(new Dimension(width, height));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setUndecorated(true);
		setVisible(true);
		add(gameRender);
		addKeyListener(this);
		addMouseListener(this);
		setTitle(WINDOW_TITLE);
		pack();
	}

	@Override
	public void run() {
		long lastFrameTime = System.currentTimeMillis();
		while (true) {
			if (hasFocus()) {
				if (System.currentTimeMillis() - lastFrameTime > 1000 / 60) {
					gameRender.repaint();
					soundManager.doSounds();
					lastFrameTime = System.currentTimeMillis();
				}
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		controller.keyPushed(arg0.getKeyChar());
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		controller.keyReleased(arg0.getKeyChar());
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		controller.mouseClicked(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
