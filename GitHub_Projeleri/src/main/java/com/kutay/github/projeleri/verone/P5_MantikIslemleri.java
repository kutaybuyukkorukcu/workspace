package com.kutay.github.projeleri.verone;

import java.util.Scanner;

public class P5_MantikIslemleri {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int x = input.nextInt();
		int y = input.nextInt();
        if(x!=y){
            System.out.println("Sayilar esit degildir");
        }
        if(x==y){
            System.out.println("Sayilar esittir");
        }
        if(x>y){
            System.out.println("Ilk sayi buyuktur");
        }
        if(x<y){
            System.out.println("Ikinci sayi buyuktur");
        }
        if(x>=y){
        	System.out.println("Birinci say� b�y�k e�ittir");
        }
        if(x<=y){
            System.out.println("Ikinci sayi kucuk esittir");
        }
        
        input.close();
	}
}
