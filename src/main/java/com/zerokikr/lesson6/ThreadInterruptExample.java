package com.zerokikr.lesson6;

public class ThreadInterruptExample {

	public static void main(String[] args) {
		correct();
	}
	
	public static void correct () {
		Thread t = new Thread (new Runnable () {
			public void run () {
				boolean inter = false;
				while (true) {
					if (Thread.currentThread().isInterrupted() || inter) {
						break;
					}
					System.out.println("tick");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						inter = true;
					}
				}
			}
		});
		t.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t.interrupt();
	}

}
