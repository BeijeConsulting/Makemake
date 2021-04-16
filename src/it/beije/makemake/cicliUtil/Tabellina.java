package it.beije.makemake.cicliUtil;

import java.util.Scanner;

public class Tabellina {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Inserire un numero: ");
		int num = s.nextInt();
		for(int i=0; i<=10; i++) {
			System.out.print(num*i + " ");
		}
	}
}
