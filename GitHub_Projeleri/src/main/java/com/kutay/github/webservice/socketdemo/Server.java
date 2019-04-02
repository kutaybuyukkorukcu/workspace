package com.kutay.github.webservice.socketdemo;

import java.net.*;
import java.io.*;

public class Server {
	private Socket socket = null;
	private ServerSocket server = null;
	private DataInputStream input = null;

	public Server(int port) {
		try {
			server = new ServerSocket(port);
			System.out.println("Server started");
			
			socket = server.accept();
			System.out.println("Client accepted");
			
			// new BufferedInputStream necessary?
			input = new DataInputStream(socket.getInputStream());

			String line = "";
			while (!line.equals("Kapat")) {
				try {
					line = input.readLine();
					System.out.println(line);

				} catch (IOException i) {
					System.out.println(i);
				}
			}
			System.out.println("Closing connection");

			socket.close();
			input.close();
		} catch (IOException i) {
			System.out.println(i);
		}
	}

	public static void main(String args[]) {
		Server server = new Server(5000);
	}
}