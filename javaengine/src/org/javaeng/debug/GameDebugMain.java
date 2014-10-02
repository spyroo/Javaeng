package org.javaeng.debug;

import java.awt.Toolkit;

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
		ball = new PongBall(w.getScreenWidth(), w.getScreenHeight());
		paddle = new PongPaddle(ball);
		pongFrame.addEntity(ball);
		pongFrame.addEntity(paddle);
		
		w.addKeyListener(ball);
		w.addKeyListener(paddle);
		
		w.setRenderFrame(pongFrame);
		w.init("Debug game");
	}
	
	public static PongBall getBall(){
		return ball;
	}
	
}
