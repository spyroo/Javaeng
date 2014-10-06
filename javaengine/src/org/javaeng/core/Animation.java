package org.javaeng.core;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Animation {
	
	private BufferedImage spriteSheet;
	private int widthPerFrame, heightPerFrame, numberOfFrames;
	private ArrayList<Texture> textureList;
	
	public Animation(String pathToSpriteSheet, int widthPerFrame, int heightPerFrame, int numberOfFrames){
		spriteSheet = (BufferedImage) Texture.getImageSource(pathToSpriteSheet);
		this.widthPerFrame = widthPerFrame;
		this.heightPerFrame = heightPerFrame;
		this.numberOfFrames = numberOfFrames;
	}
	
	private void populateTextureList() throws IncorrectImageScaleException{
		if(spriteSheet.getWidth(null) % widthPerFrame > 0 || spriteSheet.getHeight(null) % heightPerFrame > 0)
			throw new IncorrectImageScaleException();
		int numberOfTexturesPerRow = spriteSheet.getWidth(null) / widthPerFrame;
		int numberOfTexturesPerCol = spriteSheet.getHeight(null) / heightPerFrame;
		for(int row = 0; row < numberOfTexturesPerRow; row++){
			for(int col = 0; col < numberOfTexturesPerCol; col++){
				if(textureList.size() < numberOfFrames)
					textureList.add(new Texture((Image) spriteSheet.getSubimage(row * widthPerFrame, col * heightPerFrame, widthPerFrame, heightPerFrame)));
				else
					return;
			}
		}
	}
	
}
