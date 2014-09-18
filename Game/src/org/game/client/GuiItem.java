package org.game.client;

import java.awt.Point;

public class GuiItem {
	
	private BoundingBox boundingBox;
	private Texture texture;
	
	public GuiItem(BoundingBox boundingBox, Texture texture){
		this.boundingBox = boundingBox;
		this.texture = texture;
	}
	
	public BoundingBox getBoundingBox(){
		return boundingBox;
	}
	
	public void setLocation(Point loc){
		boundingBox.setLocation(loc);
	}
	
	public Texture getTexture(){
		return texture;
	}
	
	public void setTexture(Texture texture){
		this.texture = texture;
	}
	
}
