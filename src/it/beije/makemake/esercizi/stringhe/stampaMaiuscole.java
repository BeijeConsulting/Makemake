package it.beije.makemake.esercizi.stringhe;

import java.util.Scanner;

public class stampaMaiuscole {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] s = {"Uno", "Due", "Tre", "quattro"};
		String c="";

		for (int i = 0; i < s.length; i++) {
			if (s[i].charAt(0) >= 65 && s[i].charAt(0) <= 90)
				c+=s[i]+" ";
		}

		System.out.println(c);
	}

}
