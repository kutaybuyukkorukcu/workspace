package com.kutay.oylesine.dosya;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ScanTopla {

	public static void main(String[] args) {
		Scanner s = null;
		double sum = 0;
		try {
			s = new Scanner(new BufferedReader(new FileReader("./files/TextDeneme.txt")));
		
			while(s.hasNext()) {
				if(s.hasNextDouble()) {
					sum += s.nextDouble();
				} else {
					s.next();
				}
			}
		} catch (IOException e) {
		} finally {
			s.close();
		}
		System.out.println(sum);
	}
}
