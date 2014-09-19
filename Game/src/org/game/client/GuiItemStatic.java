package org.game.client;

public class GuiItemStatic implements GuiItem{

	private String id;
	private Texture texture;
	private BoundingBox boundingBox;
	
	public GuiItemStatic(String id, Texture texture, BoundingBox boundingBox){
		this.id = id;
		this.texture = texture;
		this.boundingBox = boundingBox;
		boundingBox.setGuiitem(this);
	}
	
	
	@Override
	public Texture getTexture() {
		return texture;
	}

	@Override
	public BoundingBox getBoundingBox() {
		return boundingBox;
	}


	@Override
	public String getId() {
		return id;
	}
	
	
	
}
