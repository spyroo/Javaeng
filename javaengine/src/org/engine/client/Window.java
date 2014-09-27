package org.engine.client;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Window extends JFrame {

	private static final long serialVersionUID = -8266163970188368677L;
	private Dimension screenSize;
	private int width;
	private int height;
	private RenderFrame frame;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItem;

	protected Window() {
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menu = new JMenu("Options");
		menuBar.add(menu);
		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menu.add(menuItem);
		
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
		getContentPane().add(frame);
	}
	
	public RenderFrame getRenderFrame(){
		return frame;
	}
	
}
