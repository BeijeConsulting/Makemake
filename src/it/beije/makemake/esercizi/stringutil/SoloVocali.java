package it.beije.makemake.esercizi.stringutil;

import java.util.Scanner;

public class SoloVocali  {

	public static void main(String[] args) {
		Scanner tastiera = new Scanner (System.in);
		String s1 = tastiera.next();
		tastiera.close();
		
		for(int i=0 ; i < s1.length() ; i++ ) {
			switch (s1.charAt(i) ) {
			default:
				break;
			case 'a':
				System.out.print(s1.charAt(i));
				break;
			case 'e':
				System.out.print(s1.charAt(i));
				break;
			case 'i':
				System.out.print(s1.charAt(i));
				break;
			case 'o':
				System.out.print(s1.charAt(i));
				break;
			case 'u':
				System.out.print(s1.charAt(i));
				break;
			
			}
			
		}
		
		

	}

}