package com.kutay.oylesine.tatlis.math.uygulamalari;

import java.util.Scanner;

public class Ebob {

	static int n, m, ebob;
	
	static int ebobBul (int a, int b) {
		int kalan;
		
		while (b != 0) {
			kalan = a % b;
			a = b;
			b = kalan;
		}
		return a;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("ebob'u bulunacak sayilarin ilkini giriniz : ");
		n = input.nextInt();
		System.out.println("ebob'u bulunacak sayilarin ikincisini giriniz : ");
		m = input.nextInt();
		input.close();
		System.out.println(ebobBul(n, m));
	}
}
