package com.phexum.prod.duplicateparser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class Value {

	public static void main(String[] args) throws IOException, InvalidFormatException {

		FileInputStream file = new FileInputStream(new File("./files/word_sentiment.xls"));
		HSSFWorkbook wb = new HSSFWorkbook(file);
		HSSFSheet sheet = wb.getSheetAt(0);

		Iterator<Row> rowIterator = sheet.iterator();
		ArrayList<String> deneme = new ArrayList<String>();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				String cell = cellIterator.next().toString();
				deneme.add(cell);
			}
			int a = deneme.toString().indexOf("0");
			int b = deneme.toString().indexOf("]");
			System.out.println(deneme.toString().substring(a - 6, b - 1));
			deneme.removeAll(deneme);
		}
	}
	
}