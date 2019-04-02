package com.kutay.oylesine;

public class TryingEqualsOnString {

	public static void main(String[] args) {
		
		String str1 = "Camlibelden";
		String str2 = "ciktim yayan ";
		String str3 = "dayan dizlerim dayan. ";
		
		String str4 = "Camlibelden " + "ciktim yayan. ";
		String str5 = str1 + str2;
		
		String str6 = str1 + str2 + str3;
		String str7 = str4 + str3;
		String str8 = str5 + str3;
		String str9 = "oh boi";
		String str10 = "oh boi oh boi";
		String str11 = str9 + " oh boi";
		
		str11 = str10;
		
		System.out.println(str10.equals(str11));
		System.out.println(str10 == str11);
		
		System.out.println(str6.equals(str7));
		System.out.println(str6 == str7);

		System.out.println(str6.equals(str8));
		System.out.println(str6 == str8);

		System.out.println(str7.equals(str8));
		System.out.println(str7 == str8);
	}
}
