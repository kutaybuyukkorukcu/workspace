package com.kutay.github.projeleri.verone;

import java.util.Scanner;

public class P55_Fahrenayt {

	public static void main(String[] args) {
		double derece;
		Scanner input = new Scanner(System.in);
		System.out.print("Celcius derecenizi giriniz : ");
		derece = input.nextDouble();

		derece = ((derece * 9) / 5) + 32;

		System.out.println("Girdiginiz derece Fahrenheit formatinda derecesi : " + derece);
		input.close();
	}
}
