package it.beije.makemake.exercises.stringutil;

import java.util.Scanner;

public class StampaMaiuscole {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		String str;
		StringBuilder sb = new StringBuilder();
		System.out.println();
		System.out.println("Inserire almeno due stringhe:");
		Scanner s = new Scanner(System.in);
		for(i=0; i<3; i++) {
			str = s.nextLine();
			if (str.charAt(0)>='A' && str.charAt(0)<='Z') {
				sb.append(str);
			}
		}
		s.close();
		System.out.println(sb.toString());
	}
}
