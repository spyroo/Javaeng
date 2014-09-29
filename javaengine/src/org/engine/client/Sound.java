package org.engine.client;


import java.applet.*;
import java.net.*;

public class Sound implements Runnable {

	private String pathAndFileName;
	
	public Sound(String pathAndFileName){
		this.pathAndFileName = pathAndFileName;
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
		try {
			AudioClip clip = Applet.newAudioClip(new URL("file:" + pathAndFileName));
			clip.play();
			System.out.println("PLAYED");
		} catch (MalformedURLException murle) {
			murle.printStackTrace();
		}
	}
}
