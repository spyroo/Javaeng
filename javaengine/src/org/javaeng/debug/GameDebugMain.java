package org.javaeng.debug;

import javax.swing.JOptionPane;

import org.javaeng.core.Engine;
import org.javaeng.core.RenderFrame;
import org.javaeng.core.Window;
import org.javaeng.core.Window.SCREEN_CONFIG;

public class GameDebugMain {

	private static PongPaddle paddle;
	private static PongBall ball;
	
	public static void main(String[] args) {
		Engine e = new Engine();
		Window w;
		RenderFrame pongFrame = new RenderFrame();
		
		Object[] possibilities = { "Borderless Windowed", "Fullscreen", "Windowed" };
		String s = (String) JOptionPane.showInputDialog(null, "Display Option",
				"Choose Display", JOptionPane.PLAIN_MESSAGE, null,
				possibilities, "Borderless Windowed");
		if(s.toLowerCase().contains("borderless")){
			w = e.getWindowInstance(SCREEN_CONFIG.BORDERLESS_WINDOWED, 0, 0);
		}
		else if(s.toLowerCase().contains("fullscreen")){
			w = e.getWindowInstance(SCREEN_CONFIG.FULLSCREEN, 0, 0);
		}else{
			w = e.getWindowInstance(SCREEN_CONFIG.WINDOWED, 1920, 1080);
		}
		e.startEngine();
		e.startEngine();
		
		EntityWall wallTop = new EntityWall(0, -200);
		EntityWall wallBot = new EntityWall(0, w.getScreenHeight());
		EntityWall wallBack = new EntityWall(w.getScreenWidth());
		
		ball = new PongBall(w.getScreenWidth(), w.getScreenHeight(), wallTop, wallBot, wallBack);
		paddle = new PongPaddle(ball);
		
		pongFrame.addEntity(wallTop);
		pongFrame.addEntity(wallBot);
		pongFrame.addEntity(wallBack);
		pongFrame.addEntity(ball);
		pongFrame.addEntity(paddle);
		
		w.addKeyListener(pongFrame);
		w.addMouseListener(pongFrame);
		w.addMouseMotionListener(pongFrame);
		
		w.setRenderFrame(pongFrame);
		w.init("Debug game");
	}
	
	public static PongBall getBall(){
		return ball;
	}
	
}
