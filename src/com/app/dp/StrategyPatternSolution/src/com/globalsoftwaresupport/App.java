package com.app.dp.StrategyPatternSolution.src.com.globalsoftwaresupport;

public class App {

	public static void main(String[] args) {
		
		ImageManager manager = new ImageManager();
		manager.setRenderer(new SmartphoneRenderer());
		manager.show();
		
	}
}
