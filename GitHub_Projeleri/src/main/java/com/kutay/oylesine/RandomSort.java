package com.kutay.oylesine;

public class RandomSort {

	void sort(int arr[]) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}

	public static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = n-1; i > 0; --i)
			System.out.print(arr[i] + ",");

		System.out.println();
	}

	public static void main(String args[]) {

		int[] dizi = new int[100];

		for (int i = 0; i < 100; i++) {
			dizi[i] = (int) (Math.random() * 100);
		}
		RandomSort rDizi = new RandomSort();
		rDizi.sort(dizi);
		printArray(dizi);
	}
}