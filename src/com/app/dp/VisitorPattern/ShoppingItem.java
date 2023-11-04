package com.app.dp.VisitorPattern;

public interface ShoppingItem {
	public double accept(ShoppingCartVisitor visitor);
}
