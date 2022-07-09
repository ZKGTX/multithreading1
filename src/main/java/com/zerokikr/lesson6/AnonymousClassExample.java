package com.zerokikr.lesson6;

public class AnonymousClassExample {
	
	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() { //��������� ���������� ����� ��������� ��������� ����� ���� ����� �� main
			
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		});
		
		t.start(); //��������� ������ �����
		
	
		try {
			
			t.join(); //main ���� ���� ���� ���� t ���������� ���� ������
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("END");
	}

}
