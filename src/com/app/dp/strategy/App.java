package com.app.dp.strategy;

import com.app.dp.strategy.operation.Multiplication;

public class App {

	public static void main(String[] args) {
		
		OperationManagerBAD manager = new OperationManagerBAD();
		manager.execute(new Multiplication(), 10, 5);
		
	}
}
