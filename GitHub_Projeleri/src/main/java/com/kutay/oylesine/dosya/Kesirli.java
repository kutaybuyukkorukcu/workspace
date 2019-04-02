package com.kutay.oylesine.dosya;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Kesirli {

	public static void main(String[] args) throws IOException {
		Scanner input = null;
		double sum = 0;

		try {
			input = new Scanner(new BufferedReader(new FileReader("./files/TextDeneme.txt")));

			while (input.hasNext()) {
				if (input.hasNextDouble()) {
					sum += input.nextDouble();
				} else {
					input.next();
				}
			}
		} finally {
			input.close();
		}

		System.out.println(sum);
	}
}
