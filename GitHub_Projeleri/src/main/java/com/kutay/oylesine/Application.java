package com.kutay.oylesine;

public class Application {

	public static void main(String[] args) {
		Animal cat = new Cat("pamuk");
		Animal dog = new Dog("çomar");
		Animal bird = new Bird("maviþ");

		cat.speak();
		cat.name();
		cat.legsCount();

		dog.speak();
		dog.name();
		dog.legsCount();

		bird.speak();
		bird.name();
		bird.legsCount();

	}
}

class Animal {

	public void name() {
	}

	public void speak() {
	}

	public void legsCount() {
	}
}

class Dog extends Animal {

	private String isim;

	public Dog(String isim) {
		this.isim = isim;
	}

	@Override
	public void name() {
		System.out.println(isim);
	}

	@Override
	public void speak() {
		System.out.println("havhav");
	}

	@Override
	public void legsCount() {
		System.out.println("4");
	}
}

class Cat extends Animal {

	private String isim;

	public Cat(String isim) {
		this.isim = isim;
	}

	@Override
	public void name() {
		System.out.println(isim);
	}

	@Override
	public void speak() {
		System.out.println("miyav");
	}

	@Override
	public void legsCount() {
		System.out.println("4");
	}
}

class Bird extends Animal {

	private String isim;

	public Bird(String isim) {
		this.isim = isim;
	}

	@Override
	public void name() {
		System.out.println(isim);
	}

	@Override
	public void speak() {
		System.out.println("cikcik");
	}

	@Override
	public void legsCount() {
		System.out.println("2");
	}
}
