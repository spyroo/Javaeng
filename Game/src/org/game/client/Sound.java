package org.game.client;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

import javax.sound.sampled.*;
import javax.swing.text.Position;

public class Sound implements Runnable {
	private String fileName;
	private Clip clip;

	public Sound(String fileName) {
		this.fileName = fileName;
		try {
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(new File("res/sound/"+ fileName)));
			System.out.println(clip.available());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			System.out.println("a");
			clip.start();
			System.out.println("b");
		} catch (Exception e) {
			System.out.println("c");
			e.printStackTrace();
		}
	}
}
