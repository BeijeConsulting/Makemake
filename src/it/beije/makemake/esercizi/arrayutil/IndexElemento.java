package it.beije.makemake.esercizi.arrayutil;

import java.util.Scanner;

public class IndexElemento {

	public static void main(String[] args) {
		
		int [] elementi = {-2, 99, -3, -12, -2};
		int valore = elementi[elementi.length-1];
		
		boolean flag = true;
		System.out.println("Inserisci 1 per trovare l'indice del MASSIMO elemento");
		System.out.println("Inserisci 2 per trovare l'indice del MINIMO elemento");
		Scanner tastiera = new Scanner(System.in);
		
		
		
		while(flag) {
			
			int inizio = tastiera.nextInt();
			int index=0;
			switch( inizio ) {
				default:
					System.out.println("Valore inserito non corretto!!!");
					System.out.println("Inserisci 1 per trovare l'indice del MASSIMO elemento");
					System.out.println("Inserisci 2 per trovare l'indice del MINIMO elemento");
		
					break;
				case 1:
					
					for( int i=0; i< elementi.length-1 ; i++) {
						
						if( elementi[i] > valore) {
							valore = elementi[i];
							index = i;
						}
						
					}
					
				    System.out.print("L'indice del MASSIMO è " + index);
				    
				    break;
				case 2:
					
					for( int i=0; i< elementi.length-1 ; i++) {
						
						if( elementi[i] < valore) {
							valore = elementi[i];
							index = i;
						}
						
					}
					
				    System.out.print("L'indice del MINIMO è " + index);
				    
				    break;
				    
			}
		}
		tastiera.close();			
			
		
	}
	}
		
