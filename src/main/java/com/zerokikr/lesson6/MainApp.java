package com.zerokikr.lesson6;

public class MainApp {

	public static void main(String[] args) {
		final SyncCounter syncCounter = new SyncCounter();
		
		Thread incThread = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 100; i++) {
					syncCounter.inc();
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		Thread decThread = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 100; i++) {
					syncCounter.dec();
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		try {
			incThread.start();
			decThread.start();
			incThread.join();
			decThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Synchronized counter value: " + syncCounter.value());
	}

}
