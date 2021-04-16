package it.beije.makemake.exercises.stringutil;

import java.util.Scanner;

public class Concatena {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "";
		StringBuilder sb = new StringBuilder();
		Scanner s = new Scanner(System.in);
		System.out.println("Inserisci tre Parole:");
		for(int i=0; i<3; i++) {
			str = s.nextLine();
			sb.append(str);
			sb.append('*');
		}
		s.close();
		System.out.println(sb.toString());
	}

}
