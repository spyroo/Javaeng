package org.javaeng.debug;

import java.awt.event.KeyEvent;

import org.javaeng.core.Animation;
import org.javaeng.core.BoundingBox;
import org.javaeng.core.Entity;
import org.javaeng.core.IncorrectImageScaleException;
import org.javaeng.core.Texture;
import org.javaeng.core.UserInputListener;

public class EntityKungFu extends Entity{

	public EntityKungFu() {
		super("kungfu", new BoundingBox(500, 500, 100, 100, 0, 0), new Texture("debugsrc/Keeper_of_the_Light.png"));
	}
	
	@Override
	public void update(int delta) {
		super.update(delta);
		if(UserInputListener.isKeyDown(KeyEvent.VK_P)){
			try {
				setCurrentAnimation(new Animation(this, "debugsrc/enemy_kungfu.png", 100, 100, 25, 0, 15));
			} catch (IncorrectImageScaleException e) {
				e.printStackTrace();
			}
		}
	}
	
}
