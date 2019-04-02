package com.kutay.oylesine.dosya;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteKopyala_KarakterKopyala {

	public static void main(String[] args) throws IOException {

		FileInputStream in = null;
		FileOutputStream out = null;
	
		try {
			in = new FileInputStream("./files/TextSiir.txt");
			out = new FileOutputStream("c:/users/kutay/desktop/output.txt");
			int c;

			while ((c = in.read()) != -1) {
				out.write(c);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
}
