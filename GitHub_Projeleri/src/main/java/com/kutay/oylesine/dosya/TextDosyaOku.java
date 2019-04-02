package com.kutay.oylesine.dosya;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextDosyaOku {

	public static void main(String[] args) {
		File file = new File("./files/TextSiir.txt");
		StringBuffer contents = new StringBuffer();
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader(file));
			String text = null;
			while((text = reader.readLine()) != null) {
				contents.append(text).append(" "); // append(System.getProperty("line seperator"); ne ise yariyor bilmiyorum
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(contents.toString());
	}
}
