package org.javaeng.debug;

import org.javaeng.core.BoundingBox;
import org.javaeng.core.Entity;

public class EntityWall extends Entity{

	public EntityWall(int x, int y) {
		super("wall", new BoundingBox(x, y, 1920, 200, 0, 0), null);
	}
	
	public EntityWall(int width) {
		super("wall", new BoundingBox(width, 0, 200, 1920, 0, 0), null);
	}
}
