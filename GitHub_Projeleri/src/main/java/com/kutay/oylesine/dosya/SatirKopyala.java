package com.kutay.oylesine.dosya;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SatirKopyala {

	public static void main(String[] args) throws IOException {

		BufferedReader giris = null;
		PrintWriter cikis = null;

		try {
			giris = new BufferedReader(new FileReader("./files/TextDeneme.txt"));
			cikis = new PrintWriter(new FileWriter("c:/users/kutay/desktop/output2.txt"));

			String l;
			while ((l = giris.readLine()) != null) {
				cikis.println(l);
			}
		} finally {
			if (giris != null) {
				giris.close();
			}
			if (cikis != null) {
				cikis.close();
			}
		}

	}
}
