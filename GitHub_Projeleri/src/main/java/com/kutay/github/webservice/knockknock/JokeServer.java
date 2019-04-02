package com.kutay.github.webservice.knockknock;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class JokeServer {

	public static void main(String[] args) throws Exception {		
		ServerSocket listen_for_connect = new ServerSocket(9069);
		 try {
	            while (true) {
	                Socket socket = listen_for_connect.accept();
	                try {
	                    PrintWriter connect_message = new PrintWriter(socket.getOutputStream(), true);
	                    connect_message.println("Uhm, I think your connected on port :" + listen_for_connect.getLocalPort() );
	                    Runnable run_this = new ReadJokeThread("c:/users/kutay/desktop/jokes.txt");
	                    Thread new_joke_thread = new Thread(run_this);
	                    new_joke_thread.start();
	                } finally {
	                    socket.close();
	                }
	            }
	        }
	        finally {
	            listen_for_connect.close();
	        }

	}

}

