package org.javaeng.core;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class RenderFrame extends JPanel implements MouseListener, MouseMotionListener, KeyListener{

	private static final long serialVersionUID = 3943753884244498773L;
	private ArrayList<Entity> entities;
	private static ArrayList<Sound> soundQueue;
	private static boolean canAddSoundToQueue;
	private UserInputListener userInputListener;
	
	public RenderFrame(){
		entities= new ArrayList<Entity>();
		soundQueue = new ArrayList<Sound>();
		canAddSoundToQueue = true;
	}
	
	public void addUserInputListener(UserInputListener userInputListener){
		this.userInputListener = userInputListener;
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
			if(e.getTexture() != null)
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
		for(Entity ent : entities){
			ent.mousePressed(e);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		for(Entity ent : entities){
			ent.mouseReleased(e);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		for(Entity ent : entities){
			ent.mouseEntered(e);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		for(Entity ent : entities){
			ent.mouseExited(e);
		}		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		for(Entity ent : entities){
			ent.mouseDragged(e);
		}		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		for(Entity ent : entities){
			ent.mouseMoved(e);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		for(Entity ent : entities){
			ent.keyTyped(e);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(userInputListener != null)
			userInputListener.addKeyDown(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(userInputListener != null)
			userInputListener.removeKeyDown(e.getKeyCode());
	}
	
}
