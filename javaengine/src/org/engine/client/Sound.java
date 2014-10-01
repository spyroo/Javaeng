package org.engine.client;


import java.applet.*;
import java.net.*;

public class Sound implements Runnable {

	private String pathAndFileName;
	private AudioClip clip;
	
	public Sound(String pathAndFileName){
		this.pathAndFileName = pathAndFileName;
		try {
			clip = Applet.newAudioClip(new URL("file:" + pathAndFileName));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public String getPathAndFileName(){
		return pathAndFileName;
	}
	
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