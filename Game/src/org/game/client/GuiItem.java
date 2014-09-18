package org.game.client;

import java.awt.Point;

public class GuiItem {
	
	private BoundingBox boundingBox;
	
	public GuiItem(BoundingBox boundingBox){
		this.boundingBox = boundingBox;
	}
	
	public BoundingBox getBoundingBox(){
		return boundingBox;
	}
	
	public void setLocation(Point loc){
		boundingBox.setLocation(loc);
	}
}
