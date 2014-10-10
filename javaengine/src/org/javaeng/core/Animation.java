package org.javaeng.core;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Animation {

	private Entity parentEntity;
	private Texture origTexture;
	private BufferedImage spriteSheet;
	private int widthPerFrame, heightPerFrame, numberOfFrames;
	private ArrayList<Texture> textureList;
	private int position;
	private boolean running;
	private int framesToSkip;
	private int timer;

	public Animation(Entity parentEntity, String pathToSpriteSheet,
			int widthPerFrame, int heightPerFrame, int numberOfFrames,
			int startPosition, int framesToSkip) throws IncorrectImageScaleException {
		this.parentEntity = parentEntity;
		this.origTexture = parentEntity.getTexture();
		this.textureList = new ArrayList<Texture>();
		spriteSheet = (BufferedImage) Texture.getImageSource(pathToSpriteSheet);
		this.widthPerFrame = widthPerFrame;
		this.heightPerFrame = heightPerFrame;
		this.numberOfFrames = numberOfFrames;
		this.position = startPosition;
		this.framesToSkip = framesToSkip;
		this.timer = 0;
		textureList = Texture.getTextureList(spriteSheet, widthPerFrame, heightPerFrame, numberOfFrames);
	}

	public boolean tick() {
		if (position < textureList.size()) {
			if(timer == framesToSkip){
				parentEntity.setTexture(textureList.get(position++));
				timer = 0;
			}
			timer++;
			return false;
		} else {
			parentEntity.setTexture(origTexture);
			return true;
		}
	}

	public void start(){
		running = true;
	}
	
	public void stop(){
		parentEntity.setTexture(origTexture);
		running = false;
	}
	
	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public Entity getParentEntity() {
		return parentEntity;
	}

	public void setParentEntity(Entity parentEntity) {
		this.parentEntity = parentEntity;
	}

	public Texture getOrigTexture() {
		return origTexture;
	}

	public void setOrigTexture(Texture origTexture) {
		this.origTexture = origTexture;
	}

	public int getWidthPerFrame() {
		return widthPerFrame;
	}

	public void setWidthPerFrame(int widthPerFrame) {
		this.widthPerFrame = widthPerFrame;
	}

	public int getHeightPerFrame() {
		return heightPerFrame;
	}

	public void setHeightPerFrame(int heightPerFrame) {
		this.heightPerFrame = heightPerFrame;
	}

	public int getNumberOfFrames() {
		return numberOfFrames;
	}

	public void setNumberOfFrames(int numberOfFrames) {
		this.numberOfFrames = numberOfFrames;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

}
