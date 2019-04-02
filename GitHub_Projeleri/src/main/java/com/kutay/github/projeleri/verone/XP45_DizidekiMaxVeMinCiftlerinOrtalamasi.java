package com.kutay.github.projeleri.verone;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class XP45_DizidekiMaxVeMinCiftlerinOrtalamasi {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> ar = new ArrayList<Integer>();
		System.out.println("Kac elementli dizi istiyorsun?");
		int el = input.nextInt();
		for (int i = 0; i < el; i++) {
			System.out.print((i + 1) + ". sayiyi giriniz : ");
			int tmp = input.nextInt();
			ar.add(tmp);
		}
		System.out.println(ar);
		int temp;
		for (Iterator<Integer> iterator = ar.iterator(); iterator.hasNext();) {
			int tmp = iterator.next();
			if (tmp % 2 != 0) {
				iterator.remove();
			}
		}
		System.out.println(ar);
		for (int j = 0; j < ar.size(); j++) {

			boolean flag = true;
			for (int k = ar.size() - 1; k > j; k--) {
				if (ar.get(k - 1) > ar.get(k)) {
					flag = false;
					temp = ar.get(k - 1);
					ar.set(k - 1, ar.get(k));
					ar.set(k, temp);
				}
			}
			if (flag) {
				break;
			}
		}
		System.out.println(ar);
		System.out.println(
				"Dizideki en buyuk ve en kucuk cift sayilarin ortalamasi : " + (ar.get(0) + ar.get(el - 1)) / 2);
		input.close();
	}
}
