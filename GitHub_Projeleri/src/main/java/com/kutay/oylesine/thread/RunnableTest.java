package com.kutay.oylesine.thread;

public class RunnableTest implements Runnable {

	@Override
	public void run() {
		for(int i = 1; i <=10;i++) {
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		RunnableTest test = new RunnableTest();
		Thread t = new Thread(test);
		t.start();
		System.out.println("Thread basliyor");
	}
}
