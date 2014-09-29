package org.engine.client;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class RenderFrame extends JPanel{

	private static final long serialVersionUID = 3943753884244498773L;
	private ArrayList<Entity> entities;
	
	public RenderFrame(){
		entities= new ArrayList<Entity>();
	}
	
	/**
	 * Updates the render frame, redrawing all of the entities and calling their update method
	 * 
	 */
	public void updateFrame(){
		for(Entity e : entities){
			e.update();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawString("HELLO", 50, 50);
		for(Entity e : entities){
			g.drawImage(e.getTexture().getImage().getScaledInstance(e.getBoundingBox().getWidth(), e.getBoundingBox().getHeight(), 0), e.getBoundingBox().getX(), e.getBoundingBox().getY(), null);
		}
		super.paint(g);
	}
	
	public void addEntity(Entity e){
		entities.add(e);
	}
	
}
