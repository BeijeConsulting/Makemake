package it.beije.makemake.exercises.stringutil;

import java.util.Scanner;

public class SoloVocali {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0;
		String vocal = "";
		Scanner s = new Scanner(System.in);
		System.out.print("Inserire una stringa: ");
		String word = s.next();
		s.close();
		for(i=0; i<word.length(); i++) {
			if(word.charAt(i) == 'a' ||  word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u') {
				vocal += word.charAt(i);
			}
		}
		System.out.println(vocal);
		
	}
}
