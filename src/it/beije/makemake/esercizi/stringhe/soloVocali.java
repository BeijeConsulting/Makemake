package it.beije.makemake.esercizi.stringhe;

import java.util.Scanner;

public class soloVocali {

	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		
		System.out.println("inserisci una parola:  ");
		String s=in.nextLine();
		String t="";
		
		for (int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u')
				t=t+s.charAt(i);
		}
		System.out.println(t);	
		
	}

}
