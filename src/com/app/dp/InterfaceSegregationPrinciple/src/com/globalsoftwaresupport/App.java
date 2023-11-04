package com.app.dp.InterfaceSegregationPrinciple.src.com.globalsoftwaresupport;

public class App {

	public static void main(String[] args) {
		
		RotationTree tree = new BalancedTree();
		
		tree.insert();
		tree.delete();
		tree.traverse();
		tree.leftRotation();
		tree.rightRotation();
		
	}
}
