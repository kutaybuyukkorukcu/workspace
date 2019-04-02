package com.phexum.prod.duplicateparser;

import java.util.ArrayList;

import com.phexum.sdk.io.ExcelFileReader;

public class ArrayListDefinitions {

	public ArrayList<String> synonyms(){

		ExcelFileReader<String> file = new ExcelFileReader<>("./files/word_sentiment.xls");
		ArrayList<String> key = new ArrayList<>();
		for (int i = 0; i<13520; i++) {
			key.add(file.next().get("synonyms"));
		}
		return key;
	}
	
	public ArrayList<String> polarityLabel(){

		ExcelFileReader<String> file = new ExcelFileReader<>("./files/word_sentiment.xls");
		ArrayList<String> polarity = new ArrayList<>();
		for (int i = 0; i<13520; i++) {
			polarity.add(file.next().get("Polarity Label"));
		}
		return polarity;
	}
	
	public ArrayList<String> posTag(){

		ExcelFileReader<String> file = new ExcelFileReader<>("./files/word_sentiment.xls");
		ArrayList<String> postag = new ArrayList<>();
		for (int i = 0; i<13520; i++) {
			postag.add(file.next().get("POS tag"));
		}
		return postag;
	}
	
	public ArrayList<String> negValue(){

		ExcelFileReader<String> file = new ExcelFileReader<>("./files/word_sentiment.xls");
		ArrayList<String> negvalue = new ArrayList<>();
		for (int i = 0; i<13520; i++) {
			negvalue.add(file.next().get("neg value"));
		}
		return negvalue;
	}
	
	public ArrayList<String> objValue(){

		ExcelFileReader<String> file = new ExcelFileReader<>("./files/word_sentiment.xls");
		ArrayList<String> objvalue = new ArrayList<>();
		for (int i = 0; i<13520; i++) {
			objvalue.add(file.next().get("obj value"));
		}
		return objvalue;
	}
	
	public ArrayList<String> posValue(){

		ExcelFileReader<String> file = new ExcelFileReader<>("./files/word_sentiment.xls");
		ArrayList<String> posvalue = new ArrayList<>();
		for (int i = 0; i<13520; i++) {
			posvalue.add(file.next().get("pos value"));
		}
		return posvalue;
	}
	
	public ArrayList<String> engSynonyms(){

		ExcelFileReader<String> file = new ExcelFileReader<>("./files/word_sentiment.xls");
		ArrayList<String> engsynonyms = new ArrayList<>();
		for (int i = 0; i<13520; i++) {
			engsynonyms.add(file.next().get("Eng Synonyms"));
		}
		return engsynonyms;
	}
	
	public ArrayList<String> englishGloss(){

		ExcelFileReader<String> file = new ExcelFileReader<>("./files/word_sentiment.xls");
		ArrayList<String> englishgloss = new ArrayList<>();
		for (int i = 0; i<13520; i++) {
			englishgloss.add(file.next().get("English Gloss"));
		}
		return englishgloss;
	}

	public ArrayList<String> swnPos(){

		ExcelFileReader<String> file = new ExcelFileReader<>("./files/word_sentiment.xls");
		ArrayList<String> swnpos = new ArrayList<>();
		for (int i = 0; i<13520; i++) {
			swnpos.add(file.next().get("SWNpos"));
		}
		return swnpos;
	}
	
	public ArrayList<String> swnNeg(){

		ExcelFileReader<String> file = new ExcelFileReader<>("./files/word_sentiment.xls");
		ArrayList<String> swnneg = new ArrayList<>();
		for (int i = 0; i<13520; i++) {
			swnneg.add(file.next().get("Eng Synonyms") + "\n");
		}
		return swnneg;
	}

}
