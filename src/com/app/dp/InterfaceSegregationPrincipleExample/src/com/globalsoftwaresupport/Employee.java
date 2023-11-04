package com.app.dp.InterfaceSegregationPrincipleExample.src.com.globalsoftwaresupport;

public class Employee implements IEmployee {

	@Override
	public void salary() {
		System.out.println("Getting the salary...");
	}
}
