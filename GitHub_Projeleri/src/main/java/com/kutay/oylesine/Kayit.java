package com.kutay.oylesine;

public class Kayit {

	private String ad;
	private String soyAd;
	private int numara;
	
	public Kayit (String ad, String soyAd, int numara) {
		this.ad = ad;
		this.soyAd = soyAd;
		this.numara = numara;
	}
	
	public String adGetir() {
		return ad + " " + soyAd;
	}
	
	public int numaraGetir() {
		return numara;
	}
	
	public String kayitYaz() {
		String s = numaraGetir() + "\n" + adGetir();
		return s;
	}
	
	public static void main(String[] args) {
		Kayit yeni = new Kayit("Kutay", "Buyukkorukcu", 313);
		System.out.println(yeni.adGetir() + " " + yeni.numaraGetir());
		System.out.println(yeni.kayitYaz());
		
	}
}
