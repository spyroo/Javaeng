package org.game.client;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class GameRender extends JPanel{

	private static final long serialVersionUID = -2267803346729758255L;
	private ArrayList<GuiItem> guiItems;
	
	public GameRender(){
		guiItems = new ArrayList<GuiItem>();
	}
	
	@Override
	public void update(Graphics g) {
		super.update(g);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawString(new Random().nextInt() + "", 20, 20);
		for(GuiItem i : guiItems){
			g.drawImage(i.getTexture().getImage(), (int) i.getBoundingBox().getX(), (int) i.getBoundingBox().getY(), null);
		}
	}
	
	public void addItemToRender(GuiItem i){
		guiItems.add(i);
	}
	
	public boolean removeItemToRender(GuiItem i){
		return guiItems.remove(i);
	}
	
	public ArrayList<BoundingBox> getItems(){
		ArrayList<BoundingBox> items = new ArrayList<BoundingBox>();
		for(GuiItem i : guiItems){
			items.add(i.getBoundingBox());
		}
		return items;
	}
	
	public void clearItems(){
		guiItems.clear();
	}
	
}
