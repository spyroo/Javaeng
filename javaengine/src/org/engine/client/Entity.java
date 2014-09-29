package org.engine.client;

public class Entity {
	
	private String entityId;
	private BoundingBox boundingBox;
	private Texture texture;
	
	public Entity(String entityId, BoundingBox boundingBox, Texture texture){
		this.entityId = entityId;
		this.boundingBox = boundingBox;
		this.texture = texture;
	}
	/**
	 * Update the Entity
	 */
	public void update(){
		
	}
	/**
	 * @return the entityId
	 */
	public String getEntityId() {
		return entityId;
	}
	/**
	 * @param boundingBox the boundingBox to set
	 */
	public void setBoundingBox(BoundingBox boundingBox) {
		this.boundingBox = boundingBox;
	}
	/**
	 * @param texture the texture to set
	 */
	public void setTexture(Texture texture) {
		this.texture = texture;
	}
	/**
	 * @return the boundingBox
	 */
	public BoundingBox getBoundingBox() {
		return boundingBox;
	}
	/**
	 * @return the texture
	 */
	public Texture getTexture() {
		return texture;
	}
	
	public void setX(int x){
		boundingBox.setX(x);
	}
	
	public void setY(int y){
		boundingBox.setY(y);
	}
	
}
