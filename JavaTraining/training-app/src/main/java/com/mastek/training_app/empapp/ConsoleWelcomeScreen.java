package com.mastek.training_app.empapp;

public class ConsoleWelcomeScreen implements WelcomeScreen{

	private String message;
	
	public void showScreen() {
		System.out.println(message);
	}

	public ConsoleWelcomeScreen() {
		System.out.println("Console welcome Screen Created");
	}
	
	public String getMessage() {
		return message;
	}

	// public void <name>(): lifecycle methods
	
	public void start() {
		System.out.println("Screen Started "+getMessage());
	}
	
	public void stop() {
		System.out.println("Screen Stopped: "+getMessage());
	}
	
	
	public void setMessage(String message) {
		System.out.println("Setting Message "+message);
		this.message = message;
	}
	
}
