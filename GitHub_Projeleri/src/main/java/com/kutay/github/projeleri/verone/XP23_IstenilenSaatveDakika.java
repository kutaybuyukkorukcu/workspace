package com.kutay.github.projeleri.verone;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

class StaticDemo {

	static int a = 87;
	static float b = 35.8f;

	void sayiYaz() {
		System.out.println("a : " + a + " b : " + b);
	}

}

public class XP23_IstenilenSaatveDakika{
	public static void main(String[] args) {
		StaticDemo ar = new StaticDemo();
		ar.sayiYaz();
	}
}