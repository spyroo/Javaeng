package org.javaeng.core;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;

public class BoundingBox {
	
	private int x, y, width, height, rotation, layer;
	

	public BoundingBox(int x, int y, int width, int height, int rotation, int layer){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.setRotation(rotation);
		this.layer = layer;
	}
	/**
	 * Returns true if the <code>BoundingBox</code> given overlaps with this <code>BoundingBox</code>
	 * @param xPos 
	 * @param yPos
	 */
	public boolean isOverlapping(BoundingBox otherBox, boolean ignoreLayers) {
		if(!ignoreLayers){
			if(layer != otherBox.getLayer()){
				return false;
			}
		}
		AffineTransform at = new AffineTransform();
		at.rotate(Math.toRadians(rotation), x + width/2, y + height/2);
		Shape rect1 = new Rectangle(new Point(getX(), getY()), new Dimension(width, height));
		rect1 = at.createTransformedShape(rect1);
		
		AffineTransform at2 = new AffineTransform();
		at2.rotate(Math.toRadians(otherBox.getRotation()), otherBox.getX() + otherBox.getWidth()/2, otherBox.getY() + otherBox.getHeight()/2);
		Shape rect2 = new Rectangle(new Point(otherBox.getX(), otherBox.getY()), new Dimension(otherBox.width, otherBox.height));
		rect2 = at2.createTransformedShape(rect2);
		
		Area areaA = new Area(rect1);
		areaA.intersect(new Area(rect2));
		return !areaA.isEmpty();
	}
	
	public boolean isOverlapping(double x, double y){
		AffineTransform at = new AffineTransform();
		at.rotate(Math.toRadians(rotation), x + width/2, y + height/2);
		Shape rect1 = new Rectangle(new Point(getX(), getY()), new Dimension(width, height));
		rect1 = at.createTransformedShape(rect1);
		
		Area a = new Area(rect1);
		return a.contains(x, y);
	}
	
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	public int getRotation() {
		return rotation;
	}
	public void setRotation(int rotation) {
		this.rotation = rotation;
	}
	
	/**
	 * @return the layer
	 */
	public int getLayer() {
		return layer;
	}
	/**
	 * @param layer the layer to set
	 */
	public void setLayer(int layer) {
		this.layer = layer;
	}
	
}
