package org.javaeng.debug;

import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JOptionPane;

import org.javaeng.core.Animation;
import org.javaeng.core.BoundingBox;
import org.javaeng.core.Entity;
import org.javaeng.core.IncorrectImageScaleException;
import org.javaeng.core.RenderFrame;
import org.javaeng.core.Sound;
import org.javaeng.core.Texture;
import org.javaeng.core.UserInputListener;

public class PongBall extends Entity{

	private float velocityX;
	private float velocityY;
	private int screenWidth;
	private int screenHeight;
	private EntityWall wallTop, wallBot, wallBack;
	private int bounces;
	
	public PongBall(int screenWidth, int screenHeight, EntityWall wallTop, EntityWall wallBot, EntityWall wallBack) {
		super("ball", new BoundingBox((screenWidth / 3) * 2, screenHeight / 2, 20, 20, 0, 0), new Texture("debugsrc/paddle.jpg"));
		this.getTexture().setText("This is a test");
		this.getTexture().setTextY(20);
		this.screenHeight = screenHeight;
		this.screenWidth = screenWidth;
		velocityX = 0;
		velocityY = 0;
		this.wallBack = wallBack;
		this.wallTop = wallTop;
		this.wallBot = wallBot;
		bounces = 0;
	}
	
	@Override
	public void update(int delta) {
		super.update(delta);
		if(UserInputListener.isKeyDown(KeyEvent.VK_ENTER)){
			start();
		}

		if(getBoundingBox().getX() <= 0){
			JOptionPane.showMessageDialog(null, "Game Over!");
			start();
		}
		
		BoundingBox b = getBoundingBox();
		b.setX(b.getX() + (int) (velocityX * delta));
		b.setY(b.getY() + (int) (velocityY * delta));
		b.setRotation(b.getRotation() + 1);
		setBoundingBox(b);
	}
	
	private void playBounceSound(){

		RenderFrame.addSoundToQueue(new Sound("debugsrc/bloop_x.wav"));
		this.getTexture().setText("Bounces: " + bounces++);
	}
	
	public void start(){
		BoundingBox b = getBoundingBox();
		b.setX((screenWidth / 3) * 2);
		b.setY(screenHeight / 2);
		setBoundingBox(b);
		velocityX = new Random().nextFloat() - 0.5f;
		velocityY = new Random().nextFloat() - 0.5f;
	}
	
	public void reverseX(){
		velocityX = -velocityX + 0.3f;
		playBounceSound();
	}
	
	@Override
	public void collisionWith(Entity otherEnt) {
		playBounceSound();
		if(otherEnt.equals(wallTop) || otherEnt.equals(wallBot)){
			velocityY = -velocityY;
		}
		else if(otherEnt.equals(wallBack)){
			velocityX = -velocityX;
		}
	}
	
}
