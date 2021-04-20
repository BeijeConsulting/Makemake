package it.beije.makemake.esercizi.cicli;

import java.util.Scanner;

public class FiguraNumeri {

	public static void main(String[] args) {
		int a = 1;
		
		Scanner tastiera = new Scanner(System.in);
		
		System.out.println("Fino a quanti numeri vuoi arrivare?");
		
		
			
		System.out.println("Inserisci un numero maggiore di 0.");
		
		int index = tastiera.nextInt();
		
		
			while(index<=0) {
		
				System.out.println("ERRORE!!Hai inserito un numero minore di 0!!!");
				System.out.println("Inserisci un numero maggiore di 0.");
				index = tastiera.nextInt();
			
			
		    }
			
			for( int i=index ; i>0 ; i--) {
				int conta=i;
				a=1;
				while(conta<index+1) {
					System.out.print(a);
					conta++;
					a++;
				}
				
				System.out.print("     ");
				
				conta=i;
				a=i;
				while(conta>0) {
					System.out.print(a);
					conta--;	
					a--;
				}	
					
				System.out.println("");
				
				
				
				
			}
			
		tastiera.close();
}
}
