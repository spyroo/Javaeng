package org.engine.client;

import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import java.applet.*;
import java.net.*;

public class Sound implements Runnable {

	private String pathAndFileName;
	
	public Sound(String pathAndFileName){
		this.pathAndFileName = pathAndFileName;
	}
	
	@Override
	public void run() {
		playSound();
	}
	
	public void playSound(){
		try {
			AudioClip clip = Applet.newAudioClip(new URL("file:"));
			clip.play();
		} catch (MalformedURLException murle) {
			murle.printStackTrace();
		}
	}
}
