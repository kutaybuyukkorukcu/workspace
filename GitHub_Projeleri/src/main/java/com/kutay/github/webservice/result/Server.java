package com.kutay.github.webservice.result;

import java.io.DataInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Server {

	private Socket socket = null;
	private ServerSocket server = null;
	private DataInputStream input = null;
	private PrintWriter output = null;
	private final int MIN = 1;
	private final int MAX = 100;
	public static int numberGuessedS;
	//private static int PORT;
	//private static int port;
	private static int guessesTaken = 0;
	
	
	public Server(int port) {
		try {
			server = new ServerSocket(port);
			System.out.println("Server started");
			
			socket = server.accept();
			System.out.println("Client accepted");
			
			input = new DataInputStream(socket.getInputStream());
			output = new PrintWriter(socket.getOutputStream());
			
			Random random = new Random();
			numberGuessedS = random.nextInt(MAX -1) + 1;
			
			int guess = 0;
			do {
				try {
					guess = input.readInt();
					guessesTaken += 1;
					if (numberGuessedS == guess) {
						String cevap = ("Tebrikler! " + numberGuessedS + " tahmin ettiðim numarayý " + guessesTaken + ". denemende buldun!");
						System.out.println("Cevap yollaniyor" + "\n");
						output.print(cevap);
						break;
					} else {
						if (numberGuessedS > guess) {
							String cevap = ("Numaram " + guess + "'den daha yukarýda." + "\n");
							System.out.println("Cevap yollaniyor" + "\n");
							output.print(cevap);
						} else {
							String cevap = ("Numaram " + guess + "'den daha aþaðýda." + "\n");
							System.out.println("Cevap yollaniyor" + "\n");
							output.print(cevap);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} while (guess != -1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Server server = new Server(2346);
	}
}
