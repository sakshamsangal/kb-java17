package com.app.dp.FactoryPattern.src.com.globalsoftwaresupport;

public class App {

	public static void main(String[] args) {
		
		Animal animal = AnimalFactory.getAnimal(AnimalType.LION);
		animal.eat();
	}
}
