package com.kutay.oylesine.tatlis.math.uygulamalari;

import java.util.Scanner;

public class Ekok {

	static int n, m, ekok;

	static int ekokBul (int a, int b) {
		int n;
		for (n=1;;n++) {
			if(n % a == 0 && n % b == 0){
				return n;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("ekok'u bulunacak sayilarin ilkini giriniz: ");
		n = input.nextInt();

		System.out.println("ekok'u bulunacak sayilarin ikincisini giriniz: ");
		m = input.nextInt();
		
		input.close();
		System.out.println(ekokBul(n, m));
	}
}
