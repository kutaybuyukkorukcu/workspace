package com.kutay.oylesine;

public class PersonTest {

	public static void main(String[] args) {
		Person person = new Person("Genel Mudur", 10,50);
		Mudur mudur = new Mudur("Mudur",10,40);
		Teknisyen teknisyen = new Teknisyen("Teknisyen",10,30);
		Sekreter sekreter = new Sekreter("Sekreter", 10, 20);
		System.out.println("GM" + person.mesaiHesapla());
		System.out.println("M" + mudur.mesaiHesapla());
		System.out.println("T" + teknisyen.mesaiHesapla());
		System.out.println("S" + sekreter.mesaiHesapla());
	}
}

class Person {
	String name;
	double saat;
	double saatUcreti;

	public Person(String name, double saat, double saatUcreti) {
		this.name = name;
		this.saat = saat;
		this.saatUcreti = saatUcreti;
	}

	public double mesaiHesapla() {
		return saat * saatUcreti * 2;
	}
}

class Mudur extends Person {
	
	public Mudur(String name, double saat, double saatUcreti) {
		super(name, saat, saatUcreti);
	}
	
	public double mesaiHesapla() {
		return super.mesaiHesapla(); // super ile inherit ettigim classin fonksiyonunu cagirdim
	}
}

class Teknisyen extends Person {
	
	public Teknisyen(String name, double saat, double saatUcreti) {
		super(name, saat, saatUcreti);
	}
	
	public double mesaiHesapla() {
		return saat * saatUcreti;
	}
}

class Sekreter extends Person {
	
	public Sekreter(String name, double saat, double saatUcreti) {
		super(name, saat, saatUcreti);
	}
	
	public double mesaiHesapla() {
		return saat * saatUcreti;
	}
}