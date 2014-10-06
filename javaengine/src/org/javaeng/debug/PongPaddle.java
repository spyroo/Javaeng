package org.javaeng.debug;

import java.awt.event.MouseEvent;

import org.javaeng.core.BoundingBox;
import org.javaeng.core.Entity;
import org.javaeng.core.Texture;

public class PongPaddle extends Entity{

	private PongBall ball;
	
	public PongPaddle(PongBall ball) {
		super("paddle", new BoundingBox(20, 20, 20, 200, 45, 0), new Texture("debugsrc/paddle.jpg"));
		this.ball = ball;
	}
	
	@Override
	public void update(int delta) {
		super.update(delta);
		ball = GameDebugMain.getBall();
		BoundingBox paddleBox = getBoundingBox();
		BoundingBox ballBox = ball.getBoundingBox();
		if(paddleBox.isOverlapping(ballBox, false)){
			ball.reverseX();
		}
		BoundingBox b = getBoundingBox();
		b.setRotation(b.getRotation() + 1);
		setBoundingBox(b);
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
