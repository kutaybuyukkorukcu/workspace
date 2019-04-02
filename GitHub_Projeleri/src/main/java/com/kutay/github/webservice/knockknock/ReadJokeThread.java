package com.kutay.github.webservice.knockknock;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class ReadJokeThread implements Runnable {

	private String ReadFile = null;

	private int rows_in_file = 0;
	
	private String response1;
	private String response2;

	// @param inFile file to have words counted
	public ReadJokeThread(String inFile) throws Exception {
		ReadFile = inFile;
	}

	public void run() {
		try {
			File file = new File(ReadFile);
			Scanner get_joke = new Scanner(new FileInputStream(file));
			// for counting lines in joke file
			Scanner count = new Scanner(new FileInputStream(file));

			// get total number of jokes in file
			while (count.hasNextLine()) {
				String line = count.nextLine();
				rows_in_file++;
			}
			// use lines in file to get a random line and knock knock joke.
			Random random_joke_index = new Random();
			int rand_joke = random_joke_index.nextInt((rows_in_file - 1) + 1) + 1;
			// rand_joke now holds a random line number for obtaining a joke
			// from the readfile.

			// get joke from row rand_joke
			String line = null;
			for (int i = 0; i < rand_joke; i++) {
				line = get_joke.nextLine();
			}
			line = get_joke.nextLine();
			// line should hold a random joke now.

			String[] joke = line.split(":"); // : is what separate three parts
												// of joke.
			
			doThejoke(joke);
			
			System.out.println(joke[1]); // test
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void doThejoke(String[] inJoke){
		JOptionPane.showMessageDialog(null, inJoke[0]);
		JOptionPane.showInputDialog(response1);
		JOptionPane.showMessageDialog(null, inJoke[1]);
		JOptionPane.showInputDialog(response2);
		JOptionPane.showMessageDialog(null, inJoke[2]);
	}
	
	
}
