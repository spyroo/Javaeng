package org.engine.client;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class RenderFrame extends JPanel{

	private static final long serialVersionUID = 3943753884244498773L;
	private ArrayList<Entity> entities;
	private static ArrayList<Sound> soundQueue;
	
	public RenderFrame(){
		entities= new ArrayList<Entity>();
		soundQueue = new ArrayList<Sound>();
	}
	
	/**
	 * Updates the render frame, redrawing all of the entities and calling their update method
	 * 
	 */
	public void updateFrame(){
		for(Entity e : entities){
			e.update();
		}
		for(Sound s : soundQueue){
			new Thread(s).start();
			System.out.println("queue");
		}
		soundQueue.clear();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for(Entity e : entities){
			g.drawImage(e.getTexture().getImage().getScaledInstance(e.getBoundingBox().getWidth(), e.getBoundingBox().getHeight(), 0), e.getBoundingBox().getX(), e.getBoundingBox().getY(), null);
		}
		
	}
	
	public void addEntity(Entity e){
		entities.add(e);
	}
	
	public static void addSoundToQueue(Sound s){
		soundQueue.add(s);
	}
	
}
