package org.game.client;

import java.awt.Point;

public class GuiItem {
	
	private String id;
	private BoundingBox boundingBox;
	private Texture texture;
	
	public GuiItem(String id, BoundingBox boundingBox, Texture texture, GuiActionListener actionListener){
		this.boundingBox = boundingBox;
		this.texture = texture;
		boundingBox.setGuiActionListener(actionListener);
		boundingBox.setGuiitem(this);
		this.id = id;
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
	
	public String getId(){
		return id;
	}
	
	
}
