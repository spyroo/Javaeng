package org.javaeng.core;


public class Engine implements Runnable{
	
	private Window window;
	private int framesPerSecond;
	private int ticksToSkip;
	private long nextGameTick;
	private int sleepTime;
	private long lastFrame;
	
	
	/**
	 * The Constructor of the <code>Engine</code> class
	 * 
	 */
	public Engine(int framesPerSecond){

		this.framesPerSecond = framesPerSecond;
		ticksToSkip = 1000/framesPerSecond;
		nextGameTick = getTime();
		sleepTime = 0;
		lastFrame = getTime();
	}
	/**
	 * Sets the current target frames per second for the program to operate at
	 * 
	 * @param framesPerSecond
	 */
	public void setFramesPerSecond(int framesPerSecond){
		this.framesPerSecond = framesPerSecond;
		ticksToSkip = 1000/framesPerSecond;
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
	@SuppressWarnings("static-access")
	private void tick(){
		if(window.getRenderFrame() != null){
			window.getRenderFrame().updateFrame(getDelta());
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
		}
		
	}
	
	public int getDelta() {
	    long time = getTime();
	    int delta = (int) (time - lastFrame);
	    lastFrame = time;
	    return delta;
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
