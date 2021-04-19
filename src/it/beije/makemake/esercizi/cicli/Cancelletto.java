package it.beije.makemake.esercizi.cicli;

import java.util.Scanner;

public class Cancelletto {

	public static void main(String[] args) {
		char a = '#';
		
		Scanner tastiera = new Scanner(System.in);
		
		System.out.println("Fino a quanti cancelletti vuoi arrivare?");
		
		
			
		System.out.println("Inserisci un numero maggiore di 0.");
		
		int index = tastiera.nextInt();
		
		
			while(index<=0) {
		
				System.out.println("ERRORE!!Hai inserito un numero minore di 0!!!");
				System.out.println("Inserisci un numero maggiore di 0.");
				index = tastiera.nextInt();
			
			
		    }
			
			for( int i=index ; i>0 ; i--) {
				int conta=i;
				while(conta<index+1) {
					System.out.print(a);
					conta++;
				}
				System.out.println("");
				
				
			}
			
		tastiera.close();
}
}