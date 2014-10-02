package org.javaeng.core;

public class BoundingBox {
	
	private int x, y, width, height;
	
	public BoundingBox(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	/**
	 * Returns true if the point of the given x/y is inside of the <code>BoundingBox</code>
	 * @param xPos 
	 * @param yPos
	 */
	public boolean isOverlapping(int xPos, int yPos){
		if(((xPos > x) && (xPos < (x + width))) && ((yPos  > y) && (yPos < (y + height))))
			return true;
		return false;
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
	
	
	
}
