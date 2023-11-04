package com.app.dp.ObserverPatternTrading.src.com.globalsoftwaresupport;

public class App {

	public static void main(String[] args) {
		
		StockExchange stockExchange = new StockExchange();
		stockExchange.addObserver(new BuyStockListener());
		stockExchange.addObserver(new SellStockListener());
		stockExchange.start();
	}
}
