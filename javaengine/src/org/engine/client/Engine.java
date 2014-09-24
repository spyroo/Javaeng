package org.engine.client;

public class Engine implements Runnable{
	
	private long lastFps;
	private int fps;
	private int workingFps;
	private int maxFps;
	
	//-----DEBUG-----
	public static void main(String[] args){
		new Engine().startEngine();
	}
	//-----END DEBUG-----
	
	public Engine(){
		fps = 0;
		workingFps = 0;
		maxFps = 60;
		lastFps = getTime();
	}
	
	public static Window getWindowInstance(){
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
