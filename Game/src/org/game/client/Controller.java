package org.game.client;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Controller {

	private GameRender gr;	
	
	public Controller(GameRender gr){
		this.gr = gr;
	}
	
	public void keyPushed(char c){
		ArrayList<BoundingBox> boxes = gr.getItems();
		if(c == 'w'){
			for(BoundingBox b : boxes){
				b.setLocation(b.getX(), b.getY() - 10);
			}
		}
		if(c == 'a'){
			for(BoundingBox b : boxes){
				b.setLocation(b.getX() - 10, b.getY());
			}
		}
		if(c == 's'){
			for(BoundingBox b : boxes){
				b.setLocation(b.getX(), b.getY() + 10);
			}
		}
		if(c == 'd'){
			for(BoundingBox b : boxes){
				b.setLocation(b.getX() + 10, b.getY());
			}
		}
	}
	
	public void keyReleased(char c){
		
	}
	
	public void mouseClicked(MouseEvent e){
		ArrayList<BoundingBox> items = gr.getItems();
		for(BoundingBox b : items){
			if(b.isInside(e.getLocationOnScreen())){
				b.click(b.getItem().getId());
			}
		}
	}
	
}
