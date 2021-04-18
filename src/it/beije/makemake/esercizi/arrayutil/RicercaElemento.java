package it.beije.makemake.esercizi.arrayutil;
import  java.util.Scanner;

// SENZA USARE IL SORT
public class RicercaElemento {

	public static void main(String[] args) {
		
		int [] elementi = {-2, 99, -3, -12, -2};
		int valore = elementi[elementi.length-1];
		
		boolean flag = true;
		System.out.println("Inserisci 1 per trovare il valore MASSIMO");
		System.out.println("Inserisci 2 per trovare il valore MINIMO");
		Scanner tastiera = new Scanner(System.in);
		
		
		
		while(flag) {
			int index = tastiera.nextInt();
			switch( index ) {
				default:
					System.out.println("Valore inserito non corretto!!!");
					System.out.println("Inserisci 1 per trovare il valore MASSIMO");
					System.out.println("Inserisci 2 per trovare il valore MINIMO");
		
					break;
				case 1:
					for( int ricerca : elementi) {
						
						if( ricerca > valore) {
							valore = ricerca;
						}
						
					}
				    System.out.print("Il valore MASSIMO trovato è:" + valore);
				    flag=false;
				    break;
				case 2:
						for( int ricerca : elementi) {
						
							if( ricerca < valore) {
							valore = ricerca;
							}
						
						}
				    System.out.print("Il valore MINIMO trovato è:" + valore);
				    flag=false;
				    break;
				    
			}
		}
		tastiera.close();			
			
		
	}
	}
		
		
		
	


