package com.zerokikr.lesson6.homework;

import java.util.Arrays;

public class MainApp {
	
	static final int SIZE = 10000000;
	static final int HALF = SIZE / 2;

	public static void main(String[] args) {
		
		float [] array = new float[SIZE];
		
		method1 (array);
		
		method2 (array);
						
	}
	
	public static void method1 (float[] array) {
		
		Arrays.fill(array, 1.0f);

		
		long time = System.currentTimeMillis();
		
		for (int i = 0; i < array.length; i++) {
			array[i] = (float) (array[i] * Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5) * Math.cos(0.4f + i / 2));
		}
		
		System.out.println("time: " + (System.currentTimeMillis() - time));
	}
	
	
	public static void method2 (float[] array) {
		
		Arrays.fill(array, 1.0f);

		
		long time = System.currentTimeMillis();
		
		float[] halfArray1 = new float[HALF];
		float[] halfArray2 = new float[HALF];
		System.arraycopy(array, 0, halfArray1, 0, HALF);
		System.arraycopy(array, HALF, halfArray2, 0, HALF);


		
		Thread t1 = new Thread (new Runnable() {
			@Override
			public void run() {
				
				for (int i = 0; i < halfArray1.length; i++) {
					halfArray1[i] = (float) (halfArray1[i] * Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5) * Math.cos(0.4f + i / 2));
				}
			}
		});
		
		Thread t2 = new Thread (new Runnable() {
			@Override
			public void run() {
				
				for (int i = 0, j = HALF; i < halfArray2.length; i++, j++) {
					halfArray2[i] = (float) (halfArray2[i] * Math.sin(0.2f + j/5) * Math.cos(0.2f + j/5) * Math.cos(0.4f + j / 2));
				}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.arraycopy(halfArray1, 0, array, 0, HALF);
		System.arraycopy(halfArray2, 0, array, HALF, HALF);
		
		System.out.println("time: " + (System.currentTimeMillis() - time));

		
		
		
	}

}
