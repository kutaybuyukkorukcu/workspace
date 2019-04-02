package com.kutay.oylesine.dosya;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileScanner {

	public static void main(String[] args) throws IOException {
		File file = new File("./files/TextSiir.txt");
		Scanner input = new Scanner(file);
		while (input.hasNextLine()) {
			String line = input.nextLine();
			System.out.print(line + " ");
		}
		input.close();
	}
}
