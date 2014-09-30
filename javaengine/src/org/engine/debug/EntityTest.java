package org.engine.debug;

import java.util.Random;

import org.engine.client.BoundingBox;
import org.engine.client.Entity;
import org.engine.client.RenderFrame;
import org.engine.client.Sound;
import org.engine.client.Texture;

public class EntityTest extends Entity{

	public EntityTest() {
		super("dev_test", new BoundingBox(20, 20, 50, 20), new Texture("debugsrc/Keeper_of_the_Light.png"));
	}
	
	@Override
	public void update() {
		super.update();
		if(new Random().nextInt(10000000) == 1){
			RenderFrame.addSoundToQueue(new Sound("debugsrc/0477.wav"));
			System.out.println("Scream!");
		}
	}
	
	
}
