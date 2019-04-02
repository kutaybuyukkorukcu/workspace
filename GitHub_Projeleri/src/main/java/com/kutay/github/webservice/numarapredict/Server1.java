package com.kutay.github.webservice.numarapredict;

import java.io.DataInputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class Server1 {
	private Socket socket = null;
	private ServerSocket server = null;
	private DataInputStream input = null;
	private PrintWriter output = null;
	private static int MIN = 1;
	private static int MAX = 100;
	private static int numberGuessed;
	private static int PORT;
	private static int port;
	private static int guessesTaken = 0; 
	
	public Server1(int port) {
		try {
			server = new ServerSocket(port);
			System.out.println("Server started");
			
			socket = server.accept();
			System.out.println("Client accepted");
			
			// new BufferedInputStream gerekli mi bakarsin?
			input = new DataInputStream(socket.getInputStream());
			output = new PrintWriter(socket.getOutputStream());

			Random random = new Random();
			numberGuessed = random.nextInt(MAX - 1) + 1;
			
			int guess = 0;
			String line = "";
			do {
				try {
					line = input.readUTF();
					guess = Integer.parseInt(line);
					guessesTaken += 1; 
					if (numberGuessed == guess) {
						//System.out.println("Tebrikler! " + numberGuessed + " tahmin ettiðim numarayý " + guessesTaken + ". denemende buldun!");
						String cevap = ("Tebrikler! " + numberGuessed + " tahmin ettiðim numarayý " + guessesTaken + ". denemende buldun!");
						System.out.println("Cevap yollaniyor" + "\n");
						output.print(cevap);
						break;
					} else {
						if (numberGuessed > guess) {
							//System.out.println("Numaram " + guess + "'den daha yukarýda.");
							String cevap = ("Numaram " + guess + "'den daha yukarýda." + "\n");
							System.out.println("Cevap yollaniyor" + "\n");
							output.print(cevap);
						} else {
							//System.out.println("Numaram " + guess + "'den daha aþaðýda.");
							String cevap = ("Numaram " + guess + "'den daha aþaðýda." + "\n");
							System.out.println("Cevap yollaniyor" + "\n");
							output.print(cevap);
						}
					}
				} catch (IOException i) {
					System.out.println(i);
				} catch (NumberFormatException e) {
					System.out.println(e);
				} catch (NullPointerException j) {
					j.printStackTrace();
				}
			} while (guess != -1);
			System.out.println("Closing connection");
			socket.close();
			input.close();
			output.close();
		} catch (IOException i) {
			System.out.println(i);
		} catch (NumberFormatException e) {
			System.out.println(e);
		} catch (NullPointerException j) {
			System.out.println(j);
		}
	}

	public static void setPort() {
		Scanner in = new Scanner(System.in);
		System.out.print("Server icin port giriniz : ");
		port = in.nextInt();
		in.close();
	}
	public static int getPort() {
		return port;
	} 
	
	public static void main(String args[]) {
		// setPort();
		PORT = getPort();
		Server1 server = new Server1(2345);
	}
}
