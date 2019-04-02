package com.kutay.github.projeleri.verone;

public class XP63_TarihiYaziyaCevirme {

	public static void main(String[] args) {
		 String unitsMap[] = { "zero", "one", "two", "three", "four", "five","six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
		 String tensMap[] = { "zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };

		 String NumberToWords(int number)
		 {
		  if (number == 0)
		     return "zero";

		 if (number < 0)
		     return "minus " + NumberToWords(Math.abs(number));

		 String words = "";

		 if ((number / 1000000000) > 0)
		 {
		     words += NumberToWords(number / 1000000000) + " billion ";
		     number %= 1000000000;
		 }

		 if ((number / 1000000) > 0)
		 {
		     words += NumberToWords(number / 1000000) + " million ";
		     number %= 1000000;
		 }

		 if ((number / 1000) > 0)
		 {
		     words += NumberToWords(number / 1000) + " thousand ";
		     number %= 1000;
		 }

		 if ((number / 100) > 0)
		 {
		     words += NumberToWords(number / 100) + " hundred ";
		     number %= 100;
		 }

		 if (number > 0)
		 {
		     if (number < 20)
		         words += unitsMap[number];
		     else
		     {
		         words += tensMap[number / 10];
		         if ((number % 10) > 0)
		             words += "-" + unitsMap[number % 10];
		     }
		 }

		 return words;
		  }
	}
}
