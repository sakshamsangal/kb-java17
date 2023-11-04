package com.app.dp.strategy.operation;

import com.app.dp.strategy.Strategy;

public class Multiplication implements Strategy {

	@Override
	public void execute(int num1, int num2) {
		System.out.println(num1 * num2);
	}
}
