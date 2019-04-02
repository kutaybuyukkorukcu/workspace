package com.kutay.oylesine.thread;

public class SleepTest implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				System.out.println("Tik");
			} else {
				System.out.println("Tak");
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
		}
	}
	
	public static void main(String[] args) {
		SleepTest test = new SleepTest();
		Thread t = new Thread(test);
		t.start();
		System.out.println("Thread begins");
	}
}
