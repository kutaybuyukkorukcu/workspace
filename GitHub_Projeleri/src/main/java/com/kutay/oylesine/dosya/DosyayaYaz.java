package com.kutay.oylesine.dosya;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class DosyayaYaz {

	public static void main(String[] args) throws IOException {
		Writer output = null;
		String test = "4Head LOOOOOOOOOOOOOOOOOOOL";
		File file = new File("C:/users/kutay/desktop/output6.txt");
		output = new BufferedWriter(new FileWriter(file));
		output.write(test);
		output.close();
		System.out.println("Dosyaya yazildi");
	}
}
