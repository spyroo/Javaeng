package org.engine.client;

import org.engine.debug.*;

public class Engine implements Runnable{
	
	private long lastFps;
	private int fps;
	private int workingFps;
	private int maxFps;
	
	//-----DEBUG-----
	public static void main(String[] args){
		Engine e = new Engine();
		e.startEngine();
		Window w = e.getWindowInstance();
		RenderFrame f = new CustomRenderFrame(0);
		w.setRenderFrame(f);
	}
	//-----END DEBUG-----
	
	public Engine(){
		fps = 0;
		workingFps = 0;
		maxFps = 60;
		lastFps = getTime();
	}
	
	public Window getWindowInstance(){
		return new Window();
	}
	
	private void tick(){
		
		//Calculate the current fps
		if(getTime() - lastFps > 1000){
			fps = workingFps;
			workingFps = 0;
			lastFps += 1000;
			System.out.println("FPS: " + fps);
		}
		workingFps++;
		
	}
	
	/**
	 * Returns the current time in milliseconds based on the System nanTime 
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
