package org.game.client;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Controller {

	private GameRender gr;	
	
	public Controller(GameRender gr){
		this.gr = gr;
	}
	
	public void keyPushed(char c){
		
	}
	
	public void keyReleased(char c){
		
	}
	
	public void mouseClicked(MouseEvent e){
		ArrayList<BoundingBox> items = gr.getItems();
		for(BoundingBox b : items){
			if(b.isInside(e.getLocationOnScreen())){
				b.click();
			}
		}
	}
	
}
