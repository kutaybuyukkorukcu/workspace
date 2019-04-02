package com.kutay.github.webservice.knockknock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JOptionPane;

public class KnockClient {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("localhost", 9069 );
		BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String get_connect_string = input.readLine();
		JOptionPane.showMessageDialog(null, get_connect_string);
		System.exit(0);
	}

}
