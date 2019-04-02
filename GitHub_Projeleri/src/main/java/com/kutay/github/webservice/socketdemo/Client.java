package com.kutay.github.webservice.socketdemo;

import java.net.*;
import java.io.*;

public class Client {
	private Socket socket = null;
	private DataInputStream input = null;
	private DataOutputStream output = null;

	public Client(String address, int port) {
		try {
			socket = new Socket(address, port);
			System.out.println("Connected");

			input = new DataInputStream(System.in);
			output = new DataOutputStream(socket.getOutputStream());

			String line = "";
			while (!line.equals("Kapat")) {
				try {
					line = input.readLine();
					output.writeUTF(line);
				} catch (IOException i) {
					System.out.println(i);
				}
			}
			
			System.err.println("closed");

			socket.close();
			input.close();
			output.close();
		} catch (IOException i) {
			System.out.println(i);
		}

	}

	public static void main(String args[]) {
		Client client = new Client("127.0.0.1", 5000);
	}
}