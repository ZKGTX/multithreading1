package com.zerokikr.lesson6;

public class RunnableExample implements Runnable {

	
	
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(i);
			try {
				Thread.sleep(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Thread t = new Thread(new RunnableExample());
		t.start();
	
	}

}
