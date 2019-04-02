package com.kutay.oylesine.dosya;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputOutputStreamDemo {

	public static void main(String[] args) throws IOException {
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("c:/users/kutay/desktop/output4.txt")));
		out.writeDouble(3.14159);
		out.writeUTF("Bu PI sayisidir.");
		out.close();
		
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("c:/users/kutay/desktop/output4.txt")));
		System.out.println(in.readDouble());
		System.out.println(in.readUTF());
		in.close();
	}
}
