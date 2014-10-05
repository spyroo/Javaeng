package org.javaeng.core;

import java.util.ArrayList;

public class UserInputListener {
	
	private static ArrayList<Integer> keysDown;
	
	public UserInputListener(){
		keysDown = new ArrayList<Integer>();
	}
	
	public synchronized void addKeyDown(int key){
		if(!keysDown.contains((Object) key))
				keysDown.add(key);
	}
	
	public synchronized void removeKeyDown(int key){
		keysDown.remove((Object) key);
	}
	
	public static boolean isKeyDown(int key){
		return keysDown.contains(key);
	}
	
}
