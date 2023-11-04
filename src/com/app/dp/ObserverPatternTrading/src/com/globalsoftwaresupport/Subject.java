package com.app.dp.ObserverPatternTrading.src.com.globalsoftwaresupport;

public interface Subject {
	public void addObserver(Observer o);
	public void notifyAllObserver();
}
