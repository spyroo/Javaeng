package org.engine.client;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;

public class Sound implements Runnable {
	private String SOUND_FILENAME;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		playSound();
	}
	private void playSound() 
	{
	  try
	  {
	    // get the sound file as a resource out of my jar file;
	    // the sound file must be in the same directory as this class file.
	    // the input stream portion of this recipe comes from a javaworld.com article.
	    InputStream inputStream = getClass().getResourceAsStream(SOUND_FILENAME);
	    AudioInputStream audioStream = new AudioInputStream(inputStream);
	    AudioPlayer.player.start(audioStream);
	  }
	  catch (Exception e)
	  {
	    // a special way i'm handling logging in this application
	    if (debugFileWriter!=null) e.printStackTrace(debugFileWriter);
	  }
	}
}

