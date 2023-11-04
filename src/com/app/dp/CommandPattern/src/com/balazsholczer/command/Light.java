package com.app.dp.CommandPattern.src.com.balazsholczer.command;

// receiver
public class Light {

	public void turnOn(){
		System.out.println("Lights are on...");
	}
	
	public void turnOff(){
		System.out.println("Lights are off...");
	}
}
