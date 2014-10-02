package org.javaeng.core;



public class Engine implements Runnable{
	
	private Window window;
	private int framesPerSecond;
	private int ticksToSkip;
	private long nextGameTick;
	private int sleepTime;
	
	
	/**
	 * The Constructor of the <code>Engine</code> class
	 * 
	 */
	public Engine(){

		framesPerSecond = 60;
		ticksToSkip = 1000/framesPerSecond;
		nextGameTick = getTime();
		sleepTime = 0;
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
		if(window.getRenderFrame() != null){
			window.getRenderFrame().updateFrame();
		}
		
		nextGameTick += ticksToSkip;
		sleepTime = (int) (nextGameTick - getTime());
		if(sleepTime >= 0){
			try{
				Thread.currentThread().sleep(sleepTime);
			}catch(Exception e){
				System.out.println("I was stopped but thats okay");
			}
		}else{
			//we are behind
		}
		
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
	 * Starts the engine, creating a new thread and invoking it. 
	 * 
	 **/
	public void startEngine(){
		new Thread(this).start();
	}
	
}
