package com.kutay.oylesine;

import java.util.Scanner;

public class VergiHesapla {

	double brutGelir;
	
	double brutGelirGir() {
		Scanner input = new Scanner(System.in);
		System.out.println("Brut geliri giriniz : ");
		brutGelir = input.nextDouble();
		input.close();
		return brutGelir;
	}
	
	double vergiHesapla() {
		return brutGelirGir() * 40 / 100;
	}
	
	void vergiYaz() {
		System.out.println(vergiHesapla());
	}
	
	public static void main(String[] args) {
		VergiHesapla vergi = new VergiHesapla();
		vergi.vergiYaz();
	}
}
