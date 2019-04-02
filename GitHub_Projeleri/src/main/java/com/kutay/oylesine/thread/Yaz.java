package com.kutay.oylesine.thread;

import java.util.Date;

public class Yaz {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Harf());
		t1.start();
		Thread t2 = new Thread(new Zaman());
		t2.start();

	}
}

class Harf implements Runnable {
	
	public void run() {
		for (int i = 0; i < 3; i++) {
			char c = (char) (65+i);
			System.out.println(c);
		}
	}
}

class Zaman implements Runnable {
	
	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println(new Date());
		}
	}
}