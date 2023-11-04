package com.app.dp.BuilderPattern;


public class App {

	public static void main(String[] args) {
		
		
		CSVParser machineLearningParser = new MachineLearningDataParser();
		CSVParser realEstateParser = new RealEstateMarketDataParser();
		CSVParser stockMarketParser = new StockMarketAdapter(new StockMarketDataParser());
		
		machineLearningParser.parseCSV();
		realEstateParser.parseCSV();
		stockMarketParser.parseCSV();
	}
}
