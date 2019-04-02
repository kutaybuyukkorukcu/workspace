package com.kutay.oylesine.dosya;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo {

	public static void main(String[] args) throws IOException {

		DataOutputStream out = new DataOutputStream(new FileOutputStream("C:/users/kutay/desktop/output3.txt"));
		double x = 1.0;
		int count = 10;
		out.writeInt(count); // bu satir ne ise yariyor 
		for (int i = 0; i < count; i++) {
			out.writeDouble(x);
			x = x / 9.0;
		}
		out.close();
		
		DataInputStream in = new DataInputStream(new FileInputStream("C:/users/kutay/desktop/output3.txt"));
		count = in.readInt();
		for (int i = 0; i < count; i++) {
			System.out.println(in.readDouble());
		}
		in.close(); 
	}
}
