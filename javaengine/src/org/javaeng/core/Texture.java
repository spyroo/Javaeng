package org.javaeng.core;

import java.awt.Image;
import java.io.FileInputStream;

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
}
