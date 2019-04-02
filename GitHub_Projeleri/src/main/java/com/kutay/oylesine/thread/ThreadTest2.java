package com.kutay.oylesine.thread;

public class ThreadTest2 {

	public static void main(String[] args) {

		SayiYaz A = new SayiYaz(10);
		SayiYaz B = new SayiYaz(20);
		SayiYaz C = new SayiYaz(30);
		SayiYaz D = new SayiYaz(40);

		A.start();
		B.start();
		C.start();
		D.start();

	}
}

class SayiYaz extends Thread {
	int sayi;


	public SayiYaz(int x) {
		sayi = x;
		System.out.println();
	}

	@Override
	public void run() {
		int j = 0;
		while (j <= 3) {
			yaz();
			j++;
		}
	}

	public void yaz() {
		System.out.print(" " + sayi);
	}
}