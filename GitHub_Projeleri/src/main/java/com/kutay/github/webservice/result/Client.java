package com.kutay.github.webservice.result;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Random;

public class Client {

	private static Socket socket = null;
	private static BufferedReader input = null;
	private static DataOutputStream output = null;
	private final int MAX = 100;
	private static int numberGuessedC;
	private int foo = 0;
	private int bar = 100;
	
	public Client(String address, int port) {
		try {
			socket = new Socket(address, port);
			System.out.println("Connected");
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new DataOutputStream(socket.getOutputStream());
			//Random random = new Random();
			//numberGuessedC = random.nextInt(MAX -1) + 1;
			

			
			do {
				try {
					numberGuessedC = randomWithRange(foo, bar);
					
					int x = (bar + foo) / 2;
					int y = (bar - foo) / 2;
					
					Thread.sleep(1000);
					
					if (numberGuessedC >= bar/2 && bar >= numberGuessedC) {
						foo = 50;
						bar = 100;
						if (foo <= numberGuessedC && numberGuessedC <= (bar + foo) / 2) {
							foo = 50;
							bar = (bar + foo) / 2; // 75
							if (foo <= numberGuessedC && numberGuessedC <= (bar + foo) / 2) {
								foo = 50;
								bar = (bar + foo) / 2; // 62
								if (foo <= numberGuessedC && numberGuessedC <= (bar + foo) / 2) {
									foo = 50;
									bar = (bar + foo) / 2; // 56
								} else {
									foo = (bar + foo) / 2; // 56
									bar = 62;
								}
							} else {
								foo = (bar + foo) / 2; // 62
								bar = 75;
								if (foo <= numberGuessedC && numberGuessedC <= (bar + foo) / 2) {
									foo = 62;
									bar = (bar + foo) / 2; // 68
								} else {
									foo = (bar + foo) / 2; // 68
									bar = 75;
								}
							}
						} else {
							foo = (bar + foo) / 2; // 75
							bar = 100;
							if (foo <= numberGuessedC && numberGuessedC <= (bar + foo) / 2) {
								foo = 75;
								bar = (bar + foo) / 2; // 87
								if (foo <= numberGuessedC && numberGuessedC <= (bar + foo) / 2) {
									foo = 75;
									bar = (bar + foo) / 2; // 82
								} else {
									foo = (bar + foo) / 2; // 82
									bar = 87;
								}
							} else {
								foo = (bar + foo) / 2; // 87
								bar = 100;
								if (foo <= numberGuessedC && numberGuessedC <= (bar + foo) / 2) {
									foo = 87;
									bar = (bar + foo) / 2;
								} else {
									foo = (bar + foo) / 2;
									bar = 100;
								}
							}
						}
					} else {
						foo = 0;
						bar = 50;
						if (foo <= numberGuessedC && numberGuessedC <= (bar + foo) / 2) {
							foo = 0;
							bar = (bar - foo) / 2; // 25
							if (foo <= numberGuessedC && numberGuessedC <= (bar + foo) / 2) {
								foo = 0;
								bar = (bar - foo) / 2; // 12
								if (foo <= numberGuessedC && numberGuessedC <= (bar + foo) / 2) {
									foo = 0;
									bar = (bar - foo) / 2; // 6
								} else {
									foo = (bar - foo) / 2; // 6
									bar = 12;
								}
							} else {
								foo = (bar - foo) / 2; // 12
								bar = 25;
								if (foo <= numberGuessedC && numberGuessedC <= (bar + foo) / 2) {
									foo = 12; 
									bar = (bar + foo) / 2; // 18
								} else {
									foo = (bar + foo) / 2;
									bar = 25;
								}
							}
						} else {
							foo = (bar - foo) / 2; // 25
							bar = 50;
							if (foo <= numberGuessedC && numberGuessedC <= (bar + foo) / 2) {
								foo = 25;
								bar = (bar + foo) / 2; // 37
								if (foo <= numberGuessedC && numberGuessedC <= (bar + foo) / 2) {
									foo = 25;
									bar = (bar + foo) / 2; // 31
								} else {
									foo = (bar + foo) / 2; // 31
									bar = 37;
								}
							} else {
								foo = (bar + foo) / 2;
								bar = 50;
								if (foo <= numberGuessedC && numberGuessedC <= (bar + foo) / 2) {
									foo = 37;
									bar = (bar + foo) / 2; // 43
								} else {
									foo = (bar + foo) / 2; // 43
									bar = 50;
								}
							}
						}
					}
					output.writeInt(numberGuessedC);
					if (Server.numberGuessedS == numberGuessedC)
						break;
					output.flush();
				} catch (Exception e) {
					e.printStackTrace();
				} 
			} while (socket.isConnected());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int randomWithRange(int min, int max)
	{
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
	}
	
	public static void main(String[] args) {
		Client client = new Client("127.0.0.1", 2346);
	}

	/*if (foo < numberGuessedC && numberGuessedC < (bar + foo) / 2) {
		foo = 50;
		bar = (bar + foo) / 2; // 56
	} else if (){
		foo = (bar + foo) / 2; // 56
		bar = 62;
	}*/
}
