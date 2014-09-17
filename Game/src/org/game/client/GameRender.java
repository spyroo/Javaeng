package org.game.client;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class GameRender extends JPanel{

	private static final long serialVersionUID = -2267803346729758255L;
	
	
	@Override
	public void update(Graphics g) {
		super.update(g);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawString(new Random().nextInt() + "", 20, 20);
	}
	
}
