package org.engine.client;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Entity implements KeyListener{
	
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
	 * Called when the entity is clicked on
	 */
	public void onClicked(){
		
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
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
