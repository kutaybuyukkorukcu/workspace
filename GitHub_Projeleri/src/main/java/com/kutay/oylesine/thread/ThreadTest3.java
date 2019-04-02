package com.kutay.oylesine.thread;

public class ThreadTest3 {

	public static void main(String[] args) {
		CharYaz printA = new CharYaz('a', 5);
		CharYaz printB = new CharYaz('b', 10);
		SayiYaz1 print10 = new SayiYaz1(10);
		
		printA.start();
		printB.start();
		print10.start();
		
	}
}

class CharYaz extends Thread {
	private char harf;
	private int kacKez;

	public CharYaz(char c, int t) {
		harf = c;
		kacKez = t;
	}

	@Override
	public void run() {
		for (int i = 0; i < kacKez; i++) {
			System.out.print(harf);
		}
	}
}

class SayiYaz1 extends Thread {
	private int sonSayi;

	public SayiYaz1(int n) {
		sonSayi = n;
	}

	@Override
	public void run() {

		for (int i = 1; sonSayi >= i; i++) {
			System.out.print(" " + i);
		}
	}
}