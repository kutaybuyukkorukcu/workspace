package com.kutay.oylesine.thread;

public class ThreadTest extends Thread {

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(" " + i);
		}
	}

	public static void main(String[] args) {
		ThreadTest test = new ThreadTest();
		test.start();
		System.out.println("Thread basliyor : ");
	}
}
