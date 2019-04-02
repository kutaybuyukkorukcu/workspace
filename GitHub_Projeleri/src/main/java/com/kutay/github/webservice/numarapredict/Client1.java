package com.kutay.github.webservice.numarapredict;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {
	private static Socket socket = null;
	private DataInputStream input = null;
	private DataOutputStream output = null;
	private static BufferedReader in = null;
	private static int MIN = 1;
	private static int MAX = 100;
	private static int port;
	private static int PORT;
	private static String IP;
	private static String ip;
	
	public Client1(String address, int port) {
		try {
			socket = new Socket(address, port);
			System.out.println("Connected");
			input = new DataInputStream(System.in);
			output = new DataOutputStream(socket.getOutputStream());
			
			String line = ""; // 0 verince EOFException?!
			String temp = "";
			do {
				try {
					System.out.print(MIN + " ile " + MAX + " arasýnda bir sayý giriniz : ");
					line = input.readLine();
					if (line.equals(temp)) {
						System.out.println("Bu sayi icin tahminde bulunmustunuz!");
						continue;
					}
					temp = line;
					output.writeUTF(line);
					output.flush();
				} catch (IOException i) {
					System.err.println(i);
				} catch (NumberFormatException e) {
					System.err.println(e);
				}
			} while (socket.isConnected());
			

			System.out.println("closed");

			socket.close();
			input.close();
			output.close();
		} catch (IOException e) {
			System.err.println(e);
		} 
	}

	public static void setPort() {
		Scanner in = new Scanner(System.in);
		System.out.print("Server icin ip giriniz : ");
		ip = in.nextLine();
		System.out.print("Server icin port giriniz : ");
		port = in.nextInt();
	}
	
	public static int getPort() {
		return port;
	}
	
	public static String getIP() {
		return ip;
	}
	
	public static void main(String args[]) {
		//setPort();
		PORT = getPort();
		IP = getIP();
		Client1 client = new Client1("127.0.0.1", 2345);
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("Cevap aliniyor");
	        String wowe = in.readLine();
	        System.out.println(wowe);
	        System.out.print("\n");
	        in.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
