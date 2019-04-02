package com.kutay.oylesine.dosya;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class DataInputStreamDemo {

	public static void main(String[] args) {

		try {
			FileInputStream fis = new FileInputStream("./files/TextSiir.txt");
			DataInputStream dis = new DataInputStream(fis);

			System.out.println(dis.readBoolean());
			System.out.println(dis.readByte());
			System.out.println(dis.readChar());
			fis.close();
		} catch (Exception e) {
			System.out.println("Exception:" + e);
		}
	}
}
