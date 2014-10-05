package org.javaeng.debug;

import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JOptionPane;

import org.javaeng.core.BoundingBox;
import org.javaeng.core.Entity;
import org.javaeng.core.RenderFrame;
import org.javaeng.core.Sound;
import org.javaeng.core.Texture;
import org.javaeng.core.UserInputListener;

public class PongBall extends Entity{

	private int velocityX;
	private int velocityY;
	private int screenWidth;
	private int screenHeight;
	private EntityWall wallTop, wallBot, wallBack;
	
	public PongBall(int screenWidth, int screenHeight, EntityWall wallTop, EntityWall wallBot, EntityWall wallBack) {
		super("ball", new BoundingBox((screenWidth / 3) * 2, screenHeight / 2, 20, 20), new Texture("debugsrc/paddle.jpg"));
		this.screenHeight = screenHeight;
		this.screenWidth = screenWidth;
		velocityX = 0;
		velocityY = 0;
		this.wallBack = wallBack;
		this.wallTop = wallTop;
		this.wallBot = wallBot;
	}
	
	@Override
	public void update() {
		super.update();
		if(UserInputListener.isKeyDown(KeyEvent.VK_ENTER)){
			start();
		}
		if(getBoundingBox().isOverlapping(wallBack.getBoundingBox())){
			velocityX = -velocityX;
			playBounceSound();
		}
		if(getBoundingBox().isOverlapping(wallTop.getBoundingBox()) || getBoundingBox().isOverlapping(wallBot.getBoundingBox())){
			velocityY = -velocityY;
			playBounceSound();
		}
		if(getBoundingBox().getX() <= 0){
			JOptionPane.showMessageDialog(null, "Game Over!");
			start();
		}
		
		BoundingBox b = getBoundingBox();
		b.setX(b.getX() + velocityX);
		b.setY(b.getY() + velocityY);
		setBoundingBox(b);
	}
	
	private void playBounceSound(){
		RenderFrame.addSoundToQueue(new Sound("debugsrc/bloop_x.wav"));
	}
	
	public void start(){
		BoundingBox b = getBoundingBox();
		b.setX((screenWidth / 3) * 2);
		b.setY(screenHeight / 2);
		setBoundingBox(b);
		velocityX = new Random().nextInt(10) - 5;
		velocityY = new Random().nextInt(10) - 5;
	}
	
	public void reverseX(){
		velocityX = (int) ((int) -velocityX * 1.5);
		playBounceSound();
	}
	
}
