package org.javaeng.core;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Texture {
	
	private Image image;
	
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
					textureList.add(new Texture((Image) spriteSheet.getSubimage(row * widthPerFrame, col* heightPerFrame, widthPerFrame,heightPerFrame)));
				else
					return textureList;
			}
		}
		return textureList;
	}
	
}
