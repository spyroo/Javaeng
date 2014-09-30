package org.engine.client;


import java.applet.*;
import java.net.*;

public class Sound implements Runnable {

	private String pathAndFileName;
	private AudioClip clip;
	
	/**
	 * The constructor for <code>Sound</code>
	 * <br />
	 * <br />
	 * @param pathAndFileName The path and name of the file
	 */
	public Sound(String pathAndFileName){
		this.pathAndFileName = pathAndFileName;
		try {
			clip = Applet.newAudioClip(new URL("file:" + pathAndFileName));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @return The Path and File name
	 */
	public String getPathAndFileName(){
		return pathAndFileName;
	}
	
	/**
	 * Set the path and file name
	 * @param pathAndFileName The Path and File name
	 */
	public void setPathAndFileName(String pathAndFileName){
		this.pathAndFileName = pathAndFileName;
	}
	
	@Override
	public void run() {
		playSound();
	}

	/**
	 * Plays the sound at the location of <code>pathAndFileName</code>
	 */
	public void playSound(){
		clip.play();
	}
}
