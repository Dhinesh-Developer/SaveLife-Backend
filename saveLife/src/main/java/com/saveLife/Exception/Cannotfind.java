package com.saveLife.Exception;

public class Cannotfind extends Exception {
	
	@Override
	public String getMessage() {
		
//		return super.getMessage();
		return "Unable to get the data";
	}
}
