package com.kutay.XlsFileReader;

import java.io.IOException;
import java.io.Writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.phexum.sdk.io.FileWriter;

public class ReadDataRow {

	private String text;
	private String expectedRoot;
	private String expectedVerb;
	private String expectedNegative;

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public String getExpectedRoot() {
		return expectedRoot;
	}

	public void setExpectedRoot(String expectedRoot) {
		this.expectedRoot = expectedRoot;
	}

	public String getExpectedVerb() {
		return expectedVerb;
	}

	public void setExpectedVerb(String expectedVerb) {
		this.expectedVerb = expectedVerb;
	}

	public String getExpectedNegative() {
		return expectedNegative;
	}

	public void setExpectedNegative(String expectedNegative) {
		this.expectedNegative = expectedNegative;
	}

	@Override
	public String toString() {
		return "ReadDataRow [text=" + text + ", expectedRoot=" + expectedRoot + ", expectedVerb=" + expectedVerb
				+ ", expectedNegative=" + expectedNegative + "]";
	}

}
