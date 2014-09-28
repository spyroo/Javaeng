package org.engine.client;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.engine.debug.*;

public class Engine implements Runnable{
	
	private long lastFps;
	private int fps;
	private int workingFps;
	private int maxFps;
	private Window window;
	
	//-----DEBUG-----
	//The releases WILL NOT HAVE A MAIN METHOD DELETE ME BEFORE RELEASING
	public static void main(String[] args){
		Engine e = new Engine();
		Window w = e.getWindowInstance(Window.SCREEN_CONFIG.FULLSCREEN, 800, 600);
		e.startEngine();
		RenderFrame f = new CustomRenderFrame();
		w.setRenderFrame(f);
		w.init("Javaeng Test Build");
	}
	//-----END DEBUG-----
	/**
	 * The <code>Constructor</code> of the Engine class
	 * 
	 */
	public Engine(){
		fps = 0;
		workingFps = 0;
		maxFps = 60;
		lastFps = getTime();
	}
	/**
	 * Gets an instance of <code>Window</code>, creating one if <code>Engine</code> doesn't have a child <code>Window</code> object already.
	 * @param mode The mode
	 * @return
	 */
	public Window getWindowInstance(Window.SCREEN_CONFIG mode, int width, int height){
		if(window == null)
			window = new Window(mode, width, height);
		return window;
	}
	/**
	 * Ticks the <code>Engine</code>, updating everything
	 */
	private void tick(){
		
		//Calculate the current fps
		if(getTime() - lastFps > 1000){
			fps = workingFps;
			workingFps = 0;
			lastFps += 1000;
			System.out.println("FPS: " + fps);
		}
		workingFps++;
		
		window.repaint();
		
	}
	
	/**
	 * Returns the current time in milliseconds based on the System nanoTime 
	 * @return The current time in mills
	 * 
	 **/
	private long getTime(){
		return System.nanoTime() / 1000000;
	}

	@Override
	public void run() {
		while(true){
			tick();
		}
	}
	
	/**
	 * Returns the current frames per second the application is running at.
	 * @return The current frames per second
	 **/
	public int getCurrentFps(){
		return fps;
	}
	
	/**
	 * Starts the engine, creating a new thread and invoking it. 
	 * 
	 **/
	public void startEngine(){
		new Thread(this).start();
	}
	
}
