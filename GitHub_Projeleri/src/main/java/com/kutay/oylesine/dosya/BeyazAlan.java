package com.kutay.oylesine.dosya;

import java.util.Scanner;

public class BeyazAlan {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Lutfen bir metin giriniz : ");
		while (input.hasNext()) {
			String str = input.next();
			System.out.println(str);
		}
		input.close();
	}
}
