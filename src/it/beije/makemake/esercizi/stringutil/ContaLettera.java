package it.beije.makemake.esercizi.stringutil;

import java.util.Scanner;

public class ContaLettera {
	

	public static void main(String[] args) {
		char search = 'c';
		Scanner tastiera = new Scanner (System.in);
		String s1 = tastiera.next();
		tastiera.close();
		System.out.print(contaLettera(search , s1));
		
		
	}
	
	public static int contaLettera (char c, String str) {
		int i = 0, contatore=0;
		for( ; i<str.length() ; i++)
			if(str.charAt(i) == c )
				contatore++;
				
			
		
	return contatore;
}
	
	
	

}
