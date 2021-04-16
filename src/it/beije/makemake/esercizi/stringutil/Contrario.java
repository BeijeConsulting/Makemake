package it.beije.makemake.esercizi.stringutil;

import java.util.Scanner;

public class Contrario {

	public static void main(String[] args) {
		Scanner tastiera = new Scanner (System.in);
		String s1 = tastiera.nextLine();
		tastiera.close();
		StringBuilder s2 = new StringBuilder(s1);
		s2.reverse();
		s1=s2.toString();
		System.out.print(s1);

	}

}
