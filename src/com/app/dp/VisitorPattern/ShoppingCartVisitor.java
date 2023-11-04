package com.app.dp.VisitorPattern;

public interface ShoppingCartVisitor {
	public double visit(Table table);
	public double visit(Chair chair);
}
