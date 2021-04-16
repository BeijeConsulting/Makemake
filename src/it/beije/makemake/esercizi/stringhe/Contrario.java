package it.beije.makemake.esercizi.stringhe;

import java.util.Scanner;

public class Contrario {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String t="";
		String s =in.nextLine();
		for(int i=s.length()-1; i>=0; i--) {
			t+=s.charAt(i);
		}
		System.out.println(t);
	}

}
