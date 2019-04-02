package com.kutay.oylesine.dosya;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Text {

	private static void readFile(String fileName) {
		try {
			File file = new File("./files/TextDeneme.txt");
			Scanner input = new Scanner(file);
			while (input.hasNext()) {
				System.out.println(input.next());
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Calistirma : java TextScanner " + "okunacak dosya"); // err ile println ne farki var bakarsin
		}
		// readFile(args[0]);
	}
}
