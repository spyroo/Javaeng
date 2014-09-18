package org.game.client;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

public class Texture {
	
	private Image image;
	
	public Texture(String imageName){
		image = getImage(imageName);
	}
	
	public Image getImage(String imageName){
		try{
			Image imageTemp = ImageIO.read(new FileInputStream("res/" + imageName));
			return imageTemp;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public Image getImage(){
		return image;
	}
	
	public void setImage(String fileName){
		image = getImage(fileName);
	}
	
}
