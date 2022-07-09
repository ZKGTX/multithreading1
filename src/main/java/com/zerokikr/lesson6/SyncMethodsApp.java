package com.zerokikr.lesson6;

public class SyncMethodsApp {

	public static void main(String[] args) {
		
		SyncMethodsApp e1 = new SyncMethodsApp();
		SyncMethodsApp e2 = new SyncMethodsApp();
		
		new Thread(() -> e1.method1()).start();
		new Thread(() -> e2.method2()).start();

	}
	
	public synchronized void method1 () {
		System.out.println("Method 1 start");
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Method 1 end");
	}
	
	public synchronized void method2 () {
		System.out.println("Method 2 start");
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Method 2 end");
	}
	
	public void method3 () {
		System.out.println("Method 3 start");
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Method 3 end");
	}

}
