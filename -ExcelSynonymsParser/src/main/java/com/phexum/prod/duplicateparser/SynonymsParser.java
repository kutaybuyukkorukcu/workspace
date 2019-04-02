package com.phexum.prod.duplicateparser;

import java.util.ArrayList;

public class SynonymsParser {

	public static void main(String[] args) {
		ArrayListDefinitions cells = new ArrayListDefinitions();
		ArrayList<String> temp = new ArrayList<>();
		ArrayList<String> temp0 = cells.synonyms();
		ArrayList<String> temp1 = cells.polarityLabel();

		
		for (String key : temp0) {
			String[] array = key.split(",");
			for (String a : array) {
				temp.add((a.trim()));
			}
			
		}
		
		for (int i = 0; i < temp.size(); i++) {
			System.out.println(temp + "\n");
		}
	}
}
