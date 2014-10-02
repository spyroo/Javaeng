package org.javaeng.debug;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import org.javaeng.core.BoundingBox;
import org.javaeng.core.Entity;
import org.javaeng.core.Texture;

public class PongPaddle extends Entity implements KeyListener{

	private PongBall ball;
	
	public PongPaddle(PongBall ball) {
		super("paddle", new BoundingBox(20, 20, 20, 200), new Texture("debugsrc/paddle.jpg"));
		this.ball = ball;
	}
	
	@Override
	public void update() {
		super.update();
		BoundingBox b = getBoundingBox();
		BoundingBox ballBox = ball.getBoundingBox();
		if(b.getY() > ballBox.getY() && b.getY() + b.getHeight() < ballBox.getY()){
			ball.reverseX();
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		if(e.getKeyCode() == KeyEvent.VK_W){
			BoundingBox b = getBoundingBox();
			b.setY(b.getY() - 5);
			setBoundingBox(b);
		}
		if(e.getKeyCode() == KeyEvent.VK_S){
			BoundingBox b = getBoundingBox();
			b.setY(b.getY() + 5);
			setBoundingBox(b);
		}
	}
	
}
