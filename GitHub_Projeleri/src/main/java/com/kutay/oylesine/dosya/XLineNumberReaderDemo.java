package com.kutay.oylesine.dosya;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class XLineNumberReaderDemo {

	public static void main(String[] args) throws Exception {
		File file = null;
		FileReader freader = null;
		LineNumberReader lnreader = null;
	
		try {
			file = new File("c:/users/kutay/desktop/output5.txt");
			freader = new FileReader(file);
			lnreader = new LineNumberReader(freader);
			String line = "";
			while ((line = lnreader.readLine()) != null) {
				System.out.println("Line : " + lnreader.getLineNumber() + ": " + line);
			}
		} finally {
			freader.close();
			lnreader.close();
		}
	}
}
