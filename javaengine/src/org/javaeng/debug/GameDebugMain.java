package org.javaeng.debug;

import java.awt.Toolkit;

import javax.swing.JOptionPane;

import org.javaeng.core.Engine;
import org.javaeng.core.RenderFrame;
import org.javaeng.core.Window;
import org.javaeng.core.Window.SCREEN_CONFIG;

public class GameDebugMain {

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
		PongBall ball = new PongBall(w.getScreenWidth(), w.getScreenHeight());
		PongPaddle paddle = new PongPaddle(ball);
		pongFrame.addEntity(ball);
		pongFrame.addEntity(paddle);
		
		w.addKeyListener(ball);
		w.addKeyListener(paddle);
		
		w.setRenderFrame(pongFrame);
		w.init("Debug game");
	}
	/*
	 * //-----DEBUG-----
	//The releases WILL NOT HAVE A MAIN METHOD DELETE ME BEFORE RELEASING
	public static void main(String[] args){
		Engine e = new Engine();
		Window w = e.getWindowInstance(Window.SCREEN_CONFIG.FULLSCREEN, 1440, 900);
		RenderFrame f = new RenderFrame();
		e.startEngine();
		f.addEntity(new EntityTest());
		w.setRenderFrame(f);
		w.setIconImage(Toolkit.getDefaultToolkit().getImage("debugsrc/nickCage.jpg"));
		w.init("Javaeng Test Build");
	}
	//-----END DEBUG-----
	 * 
	 */

}
