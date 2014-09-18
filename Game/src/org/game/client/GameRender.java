package org.game.client;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class GameRender extends JPanel{

	private static final long serialVersionUID = -2267803346729758255L;
	private BoundingBox b;
	
	public GameRender(){
		b = new BoundingBox(20, 20, 100, 20);
	}
	
	@Override
	public void update(Graphics g) {
		super.update(g);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawString(new Random().nextInt() + "", 20, 20);
		//b.setLocation(getMousePosition());
		g.drawRect((int)b.getX(), (int)b.getY(), (int)b.getWidth(), (int)b.getHeight());
	}
	
	public BoundingBox getBounding(){
		return b;
	}
	
}
