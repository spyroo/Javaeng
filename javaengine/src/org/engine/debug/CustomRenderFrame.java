package org.engine.debug;

import java.awt.Graphics;

import org.engine.client.RenderFrame;

public class CustomRenderFrame extends RenderFrame{

	private static final long serialVersionUID = 854133136512304179L;
	private int fps;
	
	public CustomRenderFrame(int fps) {
		this.fps = fps;
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawString("FPS: ", 20, 20);
		super.paint(g);
	}
	
	public void updateFps(int fps){
		this.fps = fps;
	}
	
}
