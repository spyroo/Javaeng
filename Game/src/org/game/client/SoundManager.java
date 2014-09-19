package org.game.client;

import java.util.ArrayList;

public class SoundManager{
	
	private ArrayList<Sound> soundDeck;
	
	public SoundManager(){
		soundDeck = new ArrayList<Sound>();
	}
	
	public void doSounds(){
		for(int i = 0; i < soundDeck.size(); i++){
			new Thread(soundDeck.get(0)).start();
			soundDeck.remove(0);
		}
	}
	
	public synchronized void addSound(Sound s){
		soundDeck.add(s);
	}
	
	public synchronized void removeSound(Sound s){
		soundDeck.remove(s);
	}
	
}
