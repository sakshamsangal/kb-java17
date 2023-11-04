package com.app.dp.PrototypePattern.src.com.globalsoftwaresupport;

public abstract class Shape {

	protected int width;
	protected int height;
	
	public Shape(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public abstract void draw();
	public abstract com.app.design_patt.design_patterns.FlyweightPattern.Shape cloneObject();
}
