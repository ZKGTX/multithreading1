package com.zerokikr.lesson6.homework;

import java.util.Arrays;

public class MainApp2 {
	
	public static void main(String[] args) {
		oneThreadTask();
		twoThreadTask();
	}
	
	public static void oneThreadTask() {
		
		final int ARRAY_LENGTH = 10000000;
		float[] arr = new float[ARRAY_LENGTH];
		
		Arrays.fill(arr, 1.0f);
		
		long time = System.currentTimeMillis();
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (float) (arr[i] * Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5) * Math.cos(0.4f + i / 2));
		}
		
		System.out.println("time: " + (System.currentTimeMillis() - time));
	}
	
	public static void twoThreadTask() {
		
		final int ARRAY_LENGTH = 10000000;
		final int HALF_ARRAY_LENGTH = ARRAY_LENGTH/2;
		float[] arr = new float[ARRAY_LENGTH];
		
		Arrays.fill(arr, 1.0f);
		
		long time = System.currentTimeMillis();
		
		float[]leftArr = new float[HALF_ARRAY_LENGTH];
		float[]rightArr = new float[HALF_ARRAY_LENGTH];
		
		System.arraycopy(arr, 0, leftArr, 0, HALF_ARRAY_LENGTH);
		System.arraycopy(arr, HALF_ARRAY_LENGTH, rightArr, 0, HALF_ARRAY_LENGTH);


		Thread leftThread = new Thread(() -> {
		for (int i = 0; i < leftArr.length; i++) {
			leftArr[i] = (float) (leftArr[i] * Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5) * Math.cos(0.4f + i / 2));
		}});
		
		Thread rightThread = new Thread(() -> {
			for (int i = 0, j = HALF_ARRAY_LENGTH; i < rightArr.length; i++, j++) {
				rightArr[i] = (float) (rightArr[i] * Math.sin(0.2f + j/5) * Math.cos(0.2f + j/5) * Math.cos(0.4f + j / 2));
			}});
		
		leftThread.start();
		rightThread.start();
		
		try {
			leftThread.join();
			rightThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.arraycopy(leftArr, 0, arr, 0, HALF_ARRAY_LENGTH);
		System.arraycopy(rightArr, 0, arr, HALF_ARRAY_LENGTH, HALF_ARRAY_LENGTH);
		
		System.out.println("time: " + (System.currentTimeMillis() - time));
	}
} 
