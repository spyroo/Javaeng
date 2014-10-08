package org.javaeng.core;

import java.awt.Image;
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

	public Animation(Entity parentEntity, String pathToSpriteSheet,
			int widthPerFrame, int heightPerFrame, int numberOfFrames,
			int startPosition) throws IncorrectImageScaleException {
		this.parentEntity = parentEntity;
		this.origTexture = parentEntity.getTexture();
		this.textureList = new ArrayList<Texture>();
		spriteSheet = (BufferedImage) Texture.getImageSource(pathToSpriteSheet);
		this.widthPerFrame = widthPerFrame;
		this.heightPerFrame = heightPerFrame;
		this.numberOfFrames = numberOfFrames;
		this.position = startPosition;
		textureList = Texture.getTextureList(spriteSheet, widthPerFrame, heightPerFrame, numberOfFrames);
	}

	public boolean tick() {
		if (position < textureList.size()) {
			parentEntity.setTexture(textureList.get(position++));
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

}
