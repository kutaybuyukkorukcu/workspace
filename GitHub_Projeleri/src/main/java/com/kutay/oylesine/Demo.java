package com.kutay.oylesine;

public class Demo {

	static public class Emekci {
		public void ad() {
			System.out.println("Turgut");
		}
	}
	
	static public class Personel extends Emekci {
		@Override
		public void ad() {
			System.out.println("Melih");
		}
	}
	
	static public class Kadrolu extends Personel {
		@Override
		public void ad() {
			System.out.println("Deniz");
		}
	}
	
	static public class Ucretli extends Personel {
		@Override
		public void ad() {
			System.out.println("Kutay");
		}
	}
	
	static public void adYaz (Emekci Birisi) {
		Birisi.ad();
	}
	
	public static void main(String[] args) {
		Emekci Ari1 = new Emekci();
		Personel Ari2 = new Personel();
		Kadrolu Ari3 = new Kadrolu();
		Ucretli Ari4 = new Ucretli();

		adYaz(Ari1);
		adYaz(Ari2);
		adYaz(Ari3);
		adYaz(Ari4);
	
	}
}
