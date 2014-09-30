package org.engine.client;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class RenderFrame extends JPanel implements MouseListener{

	private static final long serialVersionUID = 3943753884244498773L;
	private ArrayList<Entity> entities;
	private static ArrayList<Sound> soundQueue;
	private static boolean canAddSoundToQueue;
	
	public RenderFrame(){
		entities= new ArrayList<Entity>();
		soundQueue = new ArrayList<Sound>();
		canAddSoundToQueue = true;
	}
	
	/**
	 * Updates the render frame, redrawing all of the entities and calling their update method
	 * 
	 */
	public synchronized void updateFrame(){
		for(Entity e : entities){
			e.update();
		}
		canAddSoundToQueue = false;
		for(Sound s : soundQueue){
			new Thread(s).start();
		}
		soundQueue.clear();
		canAddSoundToQueue = true;
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for(Entity e : entities){
			g.drawImage(e.getTexture().getImage().getScaledInstance(e.getBoundingBox().getWidth(), e.getBoundingBox().getHeight(), 0), e.getBoundingBox().getX(), e.getBoundingBox().getY(), null);
		}
		
	}
	
	public synchronized void addEntity(Entity e){
		entities.add(e);
	}
	
	public synchronized static boolean addSoundToQueue(Sound s){
		if(canAddSoundToQueue){
			soundQueue.add(s);
			return true;
		}
		return false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for(Entity ent : entities){
			if(ent.getBoundingBox().isOverlapping(e.getX(), e.getY())){
				ent.onClicked();
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
