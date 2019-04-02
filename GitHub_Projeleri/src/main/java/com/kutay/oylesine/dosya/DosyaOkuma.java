package com.kutay.oylesine.dosya;

import java.io.FileReader;
import java.io.IOException;

public class DosyaOkuma {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("./files/TextSiir.txt");
		int count;
		char chrs[] = new char[80];

		do {
			count = fr.read(chrs);
			for (int i = 0; i < count; i++) {
				System.out.println(chrs[i]);
			}
		} while (count != -1);
		fr.close();
	}
}
