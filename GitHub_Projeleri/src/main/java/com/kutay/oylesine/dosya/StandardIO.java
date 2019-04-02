package com.kutay.oylesine.dosya;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StandardIO {

	public static void main(String[] args) throws IOException {
		
		// Duz scannerdan ne farki var ?! Stream ve bufferin anlamlarini biliyorum da ondan dolayi mi yoksa farkli bir olayi mi var
		InputStreamReader inp = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(inp);

		System.out.print("Bir text giriniz : ");

		String str = br.readLine();

		System.out.print("Girdiginiz text : " + str);
	}
}
