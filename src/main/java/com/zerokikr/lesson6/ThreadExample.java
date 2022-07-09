package com.zerokikr.lesson6;

public class ThreadExample extends Thread {
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("thread-" + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Thread t = new ThreadExample();
		t.start();
		for (int i = 0; i < 10; i++) {
			System.out.println("main-" + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
