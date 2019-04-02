package com.kutay.oylesine.tatlis.math.uygulamalari;

import java.util.Scanner;

public class RecurisveEkok {

	static int n, m, ekok;

	static int ekokBul(int a, int b) {
		int prod;
		if (b % a == 0) {
			return b;
		} else {
			prod = a * b;
			while (a != b) {
				if (a > b) {
					a = a - b;
				} else {
					b = b - a;
				}
			}
			return ekokBul(b, prod / a); 
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("ekok'u bulunacak sayilarin ilkini giriniz: ");
		int n = input.nextInt();

		System.out.println("ekok'u bulunacak sayilarin ikincisini giriniz: ");
		int m = input.nextInt();
		input.close();
		System.out.println(ekokBul(n, m));

	}
}
