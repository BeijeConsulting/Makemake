package it.beije.makemake.exercises.stringutil;

import java.util.Scanner;

public class Conta {
	
	static int contaLettera(char c, String str) {
		int i, count=0;
		for(i=0; i<str.length(); i++) {
			if(str.charAt(i) == c) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int occ;
		Scanner s = new Scanner(System.in);
		System.out.print("Inserire una stringa: ");
		String input = s.next();
		s.close();
		occ = contaLettera('c', input);
		System.out.println("Il numero delle occorrenze della lettera c e': " + occ);
		
	}

}
