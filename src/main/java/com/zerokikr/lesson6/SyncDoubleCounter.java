package com.zerokikr.lesson6;

public class SyncDoubleCounter {
	
	private long c1 = 0;
	private long c2 = 0;
	
	private Object monitor1 = new Object();
	private Object monitor2 = new Object();
	
	public long value1 () {
		return c1;
	}
	
	public long value2 () {
		return c2;
	}
	
	public void inc1 () {
		synchronized (monitor1) {
			c1++;
		}
	}
	
	public void inc2 () {
		synchronized (monitor2) {
			c2++;
		}
	}
	
	public void dec1 () {
		synchronized (monitor1) {
			c1--;
		}
	}
	
	public void dec2 () {
		synchronized (monitor2) {
			c2--;
		}
	}
}
