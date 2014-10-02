package org.javaeng.debug;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import org.javaeng.core.BoundingBox;
import org.javaeng.core.Entity;
import org.javaeng.core.Texture;

public class PongPaddle extends Entity{

	private PongBall ball;
	
	public PongPaddle(PongBall ball) {
		super("paddle", new BoundingBox(20, 20, 20, 200), new Texture("debugsrc/paddle.jpg"));
		this.ball = ball;
	}
	
	@Override
	public void update() {
		super.update();
		ball = GameDebugMain.getBall();
		BoundingBox paddleBox = getBoundingBox();
		BoundingBox ballBox = ball.getBoundingBox();
		if(paddleBox.isOverlapping(ballBox.getX(), ballBox.getY())){
			ball.reverseX();
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		if(e.getKeyCode() == KeyEvent.VK_W){
			BoundingBox b = getBoundingBox();
			b.setY(b.getY() - 15);
			setBoundingBox(b);
		}
		if(e.getKeyCode() == KeyEvent.VK_S){
			BoundingBox b = getBoundingBox();
			b.setY(b.getY() + 15);
			setBoundingBox(b);
		}
	}
	
	public void setBall(PongBall b){
		this.ball = b;
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		BoundingBox box = getBoundingBox();
		box.setY(e.getY() - (box.getHeight()/2));
		setBoundingBox(box);
	}
	
}
