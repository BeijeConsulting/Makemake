package it.beije.makemake.esercizi.stringhe;

import java.util.Scanner;

public class Concatena {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s, t, l;
		s = in.nextLine();
		t = in.nextLine();
		l = in.nextLine();
		System.out.println(s + "*" + t + "*" + l);
	}
}
