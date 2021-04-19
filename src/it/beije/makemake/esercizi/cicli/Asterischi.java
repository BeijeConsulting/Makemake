package it.beije.makemake.esercizi.cicli;

import java.util.Scanner;

public class Asterischi {

	public static void main(String[] args) {
		char a = '*';
		
		Scanner tastiera = new Scanner(System.in);
		
		System.out.println("Da quanti asterischi vuoi partire?");
		
		
			
		System.out.println("Inserisci un numero maggiore di 0.");
		
		int index = tastiera.nextInt();
		
		
			while(index<=0) {
		
				System.out.println("ERRORE!!Hai inserito un numero minore di 0!!!");
				System.out.println("Inserisci un numero maggiore di 0.");
				index = tastiera.nextInt();
			
			
		    }
			
		for( ; index>0;index-- ) {
			int conta= 0;
			while(conta!=index) {
				System.out.print(a);
				conta++;
			}
			System.out.println("");
			
		}
			
		tastiera.close();
}
}