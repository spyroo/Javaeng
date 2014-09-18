package org.game.client;

import java.awt.Point;
import java.util.ArrayList;

public class BoundingBox {
	
	private double x;
	private double y;
	private double width;
	private double height;
	
	public BoundingBox(double x, double y, double width, double height){
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	
	public BoundingBox(Point pos, int width, int height){
		this.x = (int) pos.getX();
		this.y = (int) pos.getY();
		this.height = height;
		this.width = width;
	}
	
	public void setLocation(Point location){
		this.x = location.getX();
		this.y = location.getY();
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public double getHeight(){
		return height;
	}
	
	public double getWidth(){
		return width;
	}
	
	public void setX(double x){
		this.x = x;
	}
	
	public void setY(double y){
		this.y = y;
	}
	
	public void setWidth(double width){
		this.width = width;
	}
	
	public void setHeight(double height){
		this.height = height;
	}
	
	public boolean isInside(Point p){
		Point topLeft = new Point();
		topLeft.setLocation(getX(), getY());
		Point botLeft = new Point();
		botLeft.setLocation(getX(), getY() + getHeight());
		Point topRight = new Point();
		topRight.setLocation(getX() + getWidth(), getY());
		if(p.getX() > topLeft.getX() && p.getX() < topRight.getX()){
			if(p.getY() > topLeft.getY() && p.getY() < botLeft.getY()){
				System.out.println("A BUTTON WAS VCLAICKE");
				return true;
			}
		}
		return false;
	}
	
	public double distanceBetween(Point a, Point b){
		return Math.sqrt(Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2));
	}
	
	public Point midPoint(Point a, Point b){
		Point mid = new Point();
		mid.setLocation((a.getX() + b.getX()) / 2, (a.getY() / b.getY()) / 2);
		return mid;
	}
	
}
