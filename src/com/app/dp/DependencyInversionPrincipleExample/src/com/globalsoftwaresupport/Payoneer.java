package com.app.dp.DependencyInversionPrincipleExample.src.com.globalsoftwaresupport;

// low level modules
public class Payoneer implements PaymentMethod {

	@Override
	public void pay() {
		System.out.println("Paying with Payoneer...");
	}
}
