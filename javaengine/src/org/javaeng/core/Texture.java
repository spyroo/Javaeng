package org.javaeng.core;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Texture {
	
	private Image image;
	
	private String text;
	private boolean hasText;
	int textX, textY;
	
	/**
	 * The Constructor for <code>Texture</code>
	 * 
	 * @param imageNameAndPath Path and Image name to the image
	 */
	public Texture(String imageNameAndPath) {
		image = getImageSource(imageNameAndPath);
	}
	
	public Texture(Image image){
		this.image = image;
	}
	
	public Texture(Image image, String text, int textX, int textY){
		this.image = image;
		this.hasText = true;
		this.text = text;
		this.textX = textX;
		this.textY = textY;
	}
	
	public Texture(String imageNameAndPath, String text, int textX, int textY){
		image = getImageSource(imageNameAndPath);
		this.hasText = true;
		this.text = text;
		this.textX = textX;
		this.textY = textY;
	}
	
	/**
	 * Gets the image of the path
	 * 
	 * @param imageNameAndPath
	 * @return
	 */
	public static Image getImageSource(String imageNameAndPath) {
		try {
			Image imageTemp = ImageIO.read(new FileInputStream(imageNameAndPath));
			return imageTemp;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(String fileName) {
		image = getImageSource(fileName);
	}
	
	public static ArrayList<Texture> getTextureList(BufferedImage spriteSheet, int widthPerFrame, int heightPerFrame, int numberOfFrames) throws IncorrectImageScaleException {
		ArrayList<Texture> textureList = new ArrayList<Texture>();
		if (spriteSheet.getWidth(null) % widthPerFrame > 0 || spriteSheet.getHeight(null) % heightPerFrame > 0)
			throw new IncorrectImageScaleException();
		int numberOfTexturesPerRow = spriteSheet.getWidth(null) / widthPerFrame;
		int numberOfTexturesPerCol = spriteSheet.getHeight(null)
				/ heightPerFrame;
		for (int row = 0; row < numberOfTexturesPerRow; row++) {
			for (int col = 0; col < numberOfTexturesPerCol; col++) {
				if (textureList.size() < numberOfFrames)
					textureList.add(new Texture((Image) spriteSheet.getSubimage(col * widthPerFrame, row* heightPerFrame, widthPerFrame,heightPerFrame)));
				else
					return textureList;
			}
		}
		return textureList;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		if(text.length() < 1){
			this.hasText = false;
		}else{
			this.hasText = true;
		}
		this.text = text;
	}

	public int getTextX() {
		return textX;
	}

	public void setTextX(int textX) {
		this.textX = textX;
	}

	public int getTextY() {
		return textY;
	}

	public void setTextY(int textY) {
		this.textY = textY;
	}

	public boolean isHasText() {
		return hasText;
	}
	
}
