package it.beije.makemake.secondasettimana.venerdi;

import java.util.Scanner;

public class SoloVocali {
	public static void main(String[] arg) {
		String temp = arg[0].toString();
		
		for(int i = 0; i < temp.length(); i++) {
			
			if(isVocale(temp.charAt(i)))
				System.out.println(temp.charAt(i));
		}
	}

	public static boolean isVocale(char c) {
		if( c == 'a' || c == 'A' || c == 'e' || c == 'E' ||
				c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U')
			return true;
		else
			return false;
	}
	
	public static int contaLettera(char c, String str) {
		int count = 0;
		
		for(int i = 0; i < str.length(); i++) {
			if(c == str.charAt(i))
				count++;
		}
		
		return count;
	}
	
	public static void concatena() {
		
		StringBuilder str = new StringBuilder();
		String temp = "";
		Scanner in = new Scanner(System.in);
		
		
		for(int i = 0; i < 3; i++) {
			temp = in.next();
			str.append(temp);
			if( i != 2)
				str.append('*');
		}
		
		System.out.println(str);
		in.close();
	}
}
