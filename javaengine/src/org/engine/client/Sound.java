package org.engine.client;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import java.applet.*;
import java.net.*;

public class Sound implements Runnable {


	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			AudioClip clip = Applet.newAudioClip(
			new URL(Place Location Here));
			clip.play();
			} catch (MalformedURLException murle) {
			System.out.println(murle);
			}	
	}
}

