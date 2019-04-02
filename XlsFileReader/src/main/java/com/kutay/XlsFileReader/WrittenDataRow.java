package com.kutay.XlsFileReader;

public class WrittenDataRow {

	private String text;
	private String expectedRoot;
	private String expectedVerb;
	private String expectedNegative;
	private String actualRoot;
	private String actualVerb;
	private String actualNegative;

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

	public String getActualRoot() {
		return actualRoot;
	}

	public void setActualRoot(String actualRoot) {
		this.actualRoot = actualRoot;
	}

	public String getActualVerb() {
		return actualVerb;
	}

	public void setActualVerb(String actualVerb) {
		this.actualVerb = actualVerb;
	}

	public String getActualNegative() {
		return actualNegative;
	}

	public void setActualNegative(String actualNegative) {
		this.actualNegative = actualNegative;
	}

	@Override
	public String toString() {
		return "WritedDataRow [text=" + text + ", expectedRoot=" + expectedRoot + ", expectedVerb=" + expectedVerb
				+ ", expectedNegative=" + expectedNegative + ", actualRoot=" + actualRoot + ", actualVerb=" + actualVerb
				+ ", actualNegative=" + actualNegative + "]";
	}

}
