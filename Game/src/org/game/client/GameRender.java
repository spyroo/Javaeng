package org.game.client;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GameRender extends JPanel{

	private static final long serialVersionUID = -2267803346729758255L;
	private ArrayList<GuiItemInteractable> guiItemInteractableItems;
	
	public GameRender(){
		guiItemInteractableItems = new ArrayList<GuiItemInteractable>();
	}
	
	@Override
	public void update(Graphics g) {
		super.update(g);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for(GuiItemInteractable i : guiItemInteractableItems){
			g.drawImage(i.getTexture().getImage().getScaledInstance((int)i.getBoundingBox().getWidth(), (int)i.getBoundingBox().getHeight(), 0), (int) i.getBoundingBox().getX(), (int) i.getBoundingBox().getY(), null);
		}
	}
	
	public void addItemToRender(GuiItemInteractable i){
		guiItemInteractableItems.add(i);
	}
	
	public boolean removeItemToRender(GuiItemInteractable i){
		return guiItemInteractableItems.remove(i);
	}
	
	public ArrayList<BoundingBox> getItems(){
		ArrayList<BoundingBox> items = new ArrayList<BoundingBox>();
		for(GuiItemInteractable i : guiItemInteractableItems){
			items.add(i.getBoundingBox());
		}
		return items;
	}
	
	public void clearItems(){
		guiItemInteractableItems.clear();
	}

	public void removeItemToRender(int i) {
		guiItemInteractableItems.remove(i);
	}
	
	public boolean removeItemByID(String id){
		for(GuiItemInteractable i : guiItemInteractableItems){
			if(i.getId().equalsIgnoreCase(id)){
				guiItemInteractableItems.remove(i);
				return true;
			}
		}
		return false;
	}
	
}
