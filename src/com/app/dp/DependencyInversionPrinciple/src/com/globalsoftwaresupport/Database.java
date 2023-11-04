package com.app.dp.DependencyInversionPrinciple.src.com.globalsoftwaresupport;

// this is the abstract layer
public interface Database {
	public void connect();
	public void disconnect();
}
