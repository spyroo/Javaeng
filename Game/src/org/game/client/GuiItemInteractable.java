package org.game.client;

import java.awt.Point;

public class GuiItemInteractable implements GuiItem{
	
	private String id;
	private BoundingBox boundingBox;
	private Texture texture;
	
	public GuiItemInteractable(String id, BoundingBox boundingBox, Texture texture, GuiActionListener actionListener){
		this.boundingBox = boundingBox;
		this.texture = texture;
		boundingBox.setGuiActionListener(actionListener);
		boundingBox.setGuiitem(this);
		this.id = id;
	}
	
	@Override
	public BoundingBox getBoundingBox(){
		return boundingBox;
	}
	
	public void setLocation(Point loc){
		boundingBox.setLocation(loc);
	}
	
	public void setLocation(double x, double y){
		boundingBox.setLocation(x, y);
	}
	
	@Override
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
