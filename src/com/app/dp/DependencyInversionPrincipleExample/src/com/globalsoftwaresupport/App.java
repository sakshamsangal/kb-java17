package com.app.dp.DependencyInversionPrincipleExample.src.com.globalsoftwaresupport;

public class App {

	public static void main(String[] args) {
		
		WebStore store = new WebStore();
		store.purchaseItem();
		
	}
}
