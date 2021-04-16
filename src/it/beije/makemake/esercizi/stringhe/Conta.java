package it.beije.makemake.esercizi.stringhe;

import java.util.Scanner;

public class Conta {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String s =in.nextLine();
		System.out.println(contaLettera('a', s));
	}

	public static int contaLettera(char c, String str) {
		int cont = 0;
		for (int i = 0; i < str.length() ; i++) {
			if (str.charAt(i) == c)
				cont++;
		}
		return cont;
	}

}
