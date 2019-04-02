package com.kutay.oylesine.dosya;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberTest {

	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		
		String str;
		int num;
		
		System.out.println("Bir tam sayi giriniz : ");
		str = stdin.readLine();
		num = Integer.parseInt(str); 
		
		if (num < 0) {
			System.out.println(num + " sayisi negatiftir");
		} else {
			System.out.println(num + " sayisi pozitiftir");
		}
		System.out.println("son!");
		
	}
}
