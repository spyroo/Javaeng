package org.engine.client;

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
		image = getImage(imageNameAndPath);
	}
	
	/**
	 * Gets the image of the path
	 * 
	 * @param imageNameAndPath
	 * @return
	 */
	private Image getImage(String imageNameAndPath) {
		try {
			Image imageTemp = ImageIO.read(new FileInputStream(imageNameAndPath));
			System.out.println("yep");
			return imageTemp;
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("nope");
		return null;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(String fileName) {
		image = getImage(fileName);
	}
}
