package com.kutay.oylesine;

import java.util.Scanner;

public class ParseYerineValueOf {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Bir tamsayi giriniz: ");
		String aString = input.nextLine();
		input.close();
		int pInt = Integer.parseInt(aString);
		System.out.println(pInt);
		int vInt = Integer.valueOf(aString);
		System.out.println(vInt);

	}
}
