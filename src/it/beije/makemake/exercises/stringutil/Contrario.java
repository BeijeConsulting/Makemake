package it.beije.makemake.exercises.stringutil;

import java.util.Scanner;

public class Contrario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.print("Inserire una stringa: ");
		String input = s.next();
		s.close();
		StringBuilder sb = new StringBuilder(input);
		sb.reverse();
		System.out.println(sb.toString());
	}
}
