package org.javaeng.core;

public class IncorrectImageScaleException extends Exception{

	private static final long serialVersionUID = 5335507510657571092L;
	
	public IncorrectImageScaleException(){
		super("Incorrect size on image");
	}
	
}
