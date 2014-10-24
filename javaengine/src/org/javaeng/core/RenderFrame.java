package org.javaeng.core;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class RenderFrame extends JPanel implements MouseListener,
		MouseMotionListener, KeyListener {

	private static final long serialVersionUID = 3943753884244498773L;
	private ArrayList<Entity> entities;
	private static ArrayList<Sound> soundQueue;
	private static boolean canAddSoundToQueue;
	private UserInputListener userInputListener;
	private RenderingHints rhints;

	public RenderFrame() {
		entities = new ArrayList<Entity>();
		soundQueue = new ArrayList<Sound>();
		canAddSoundToQueue = true;
		rhints = new RenderingHints(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		rhints.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	}

	public void addUserInputListener(UserInputListener userInputListener) {
		this.userInputListener = userInputListener;
	}

	/**
	 * Updates the render frame, redrawing all of the entities and calling their
	 * update method
	 * 
	 */

	public synchronized void updateFrame(int delta) {
		for (Entity e : entities) {
			e.update(delta);
		}
		canAddSoundToQueue = false;
		for (Sound s : soundQueue) {
			new Thread(s).start();
		}
		soundQueue.clear();
		canAddSoundToQueue = true;
		
		ArrayList<Entity> tempEnts = new ArrayList<Entity>();
		tempEnts.addAll(entities);
		for(int i = 0, max = tempEnts.size(); i < max; i++){
			Entity thisOne = tempEnts.get(0);
			tempEnts.remove(0);
			for(Entity e : tempEnts){
				if(thisOne.getBoundingBox().isOverlapping(e.getBoundingBox(), false)){
					thisOne.collisionWith(e);
					e.collisionWith(thisOne);
				}
			}
		}
		
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (Entity e : entities) {
			if (e.getTexture() != null) {
				Graphics2D g2d = (Graphics2D) g.create();
				g2d.setRenderingHints(rhints);
				g2d.rotate(Math.toRadians(e.getBoundingBox().getRotation()), e.getBoundingBox().getX() + e.getBoundingBox().getWidth()/2,e.getBoundingBox().getY() +  e.getBoundingBox().getHeight()/2);
				g2d.drawImage(e.getTexture().getImage().getScaledInstance(e.getBoundingBox().getWidth(),e.getBoundingBox().getHeight(), 0), e.getBoundingBox().getX(), e.getBoundingBox().getY(), null);
				g2d.dispose();
			}
		}

	}

	public synchronized void addEntity(Entity e) {
		entities.add(e);
	}

	public synchronized static boolean addSoundToQueue(Sound s) {
		if (canAddSoundToQueue) {
			soundQueue.add(s);
			return true;
		}
		return false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for (Entity ent : entities) {
			if (ent.getBoundingBox().isOverlapping(e.getX(), e.getY())) {
				ent.onClicked();
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		for (Entity ent : entities) {
			ent.mousePressed(e);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		for (Entity ent : entities) {
			ent.mouseReleased(e);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		for (Entity ent : entities) {
			ent.mouseEntered(e);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		for (Entity ent : entities) {
			ent.mouseExited(e);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		for (Entity ent : entities) {
			ent.mouseDragged(e);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		for (Entity ent : entities) {
			ent.mouseMoved(e);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		for (Entity ent : entities) {
			ent.keyTyped(e);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (userInputListener != null)
			userInputListener.addKeyDown(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (userInputListener != null)
			userInputListener.removeKeyDown(e.getKeyCode());
	}

}
