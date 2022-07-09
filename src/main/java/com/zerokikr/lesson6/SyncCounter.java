package com.zerokikr.lesson6;

public class SyncCounter {
	
	private int c;

	public int value() {
		return c;
	}
	
	public SyncCounter() {
		c = 0;
	}
	
	public synchronized void inc() {
		c++;
	}
	
	public synchronized void dec() {
		c--;
	}
	
	

}
