package org.engine.debug;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import org.engine.client.BoundingBox;
import org.engine.client.Entity;
import org.engine.client.RenderFrame;
import org.engine.client.Sound;
import org.engine.client.Texture;

public class EntityTest extends Entity{

	public EntityTest() {
		super("dev_test", new BoundingBox(20, 20, 50, 200), new Texture("debugsrc/Keeper_of_the_Light.png"));
	}
	
	@Override
	public void update() {
		super.update();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar() == 'l'){
			RenderFrame.addSoundToQueue(new Sound("debugsrc/0477.wav"));
		}
		if(e.getKeyChar() == 'w'){
			BoundingBox b = getBoundingBox();
			b.setY(b.getY() - 15);
			setBoundingBox(b);
		}
		if(e.getKeyChar() == 's'){
			BoundingBox b = getBoundingBox();
			b.setY(b.getY() + 15);
			setBoundingBox(b);
		}
		if(e.getKeyChar() == 'a'){
			BoundingBox b = getBoundingBox();
			b.setX(b.getX() - 15);
			setBoundingBox(b);
		}
		if(e.getKeyChar() == 'd'){
			BoundingBox b = getBoundingBox();
			b.setX(b.getX() + 15);
			setBoundingBox(b);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onClicked() {
		super.onClicked();
		RenderFrame.addSoundToQueue(new Sound("debugsrc/disconnect.wav"));
	}
	
}
