package org.engine.client;

public class Engine implements Runnable{
	
	private long lastFps;
	private int fps;
	private int maxFps;
	
	public static void main(String[] args){
		new Engine().startEngine();
	}
	
	public Engine(){
		fps = 0;
		maxFps = 60;
		lastFps = getTime();
	}
	
	public static Window getWindowInstance(){
		return new Window();
	}
	
	private void tick(){
		
		//Calculate the current fps
		if(getTime() - lastFps > 1000){
			fps = 0;
			lastFps += 1000;
		}
		if(fps > maxFps)
			return;
		fps++;
		System.out.println("FPS: " + fps);
	}
	
	private long getTime(){
		return System.nanoTime() / 1000000;
	}

	@Override
	public void run() {
		while(true){
			tick();
		}
	}
	
	public int getCurrentFps(){
		return fps;
	}
	
	public void startEngine(){
		new Thread(this).start();
	}
	
}
