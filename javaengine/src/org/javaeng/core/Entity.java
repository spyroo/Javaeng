package org.javaeng.core;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Entity{
	
	private String entityId;
	private BoundingBox boundingBox;
	private Texture texture;
	private Animation currentAnimation;
	
	public Entity(String entityId, BoundingBox boundingBox, Texture texture){
		this.entityId = entityId;
		this.boundingBox = boundingBox;
		this.texture = texture;
	}
	/**
	 * Update the Entity
	 */
	public void update(int delta){
		if(currentAnimation != null){
			if(currentAnimation.tick()){
				currentAnimation = null;
			}
		}
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
	
	public void keyTyped(KeyEvent e) {
		
	}
	
	public void mouseMoved(MouseEvent e) {
		
	}
	
	public void mousePressed(MouseEvent e) {
		
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	public void mouseEntered(MouseEvent e) {
		
	}
	
	public void mouseExited(MouseEvent e) {
		
	}
	
	public void mouseDragged(MouseEvent e) {
		
	}
	public Animation getCurrentAnimation() {
		return currentAnimation;
	}
	public void setCurrentAnimation(Animation currentAnimation) {
		if(this.currentAnimation == null)
			this.currentAnimation = currentAnimation;
	}
	
}
