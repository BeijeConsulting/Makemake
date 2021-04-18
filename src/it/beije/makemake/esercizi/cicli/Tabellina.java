package it.beije.makemake.esercizi.cicli;

import java.util.Scanner;

public class Tabellina {

	public static void main(String[] args) {
		boolean flag=true;
		Scanner tastiera = new Scanner(System.in);
		
		
		while(flag) {
			System.out.println("Inserisci un numero intero positivo per saperne la tabellina:");
			int num = tastiera.nextInt();
			if(num>0) {
					for ( int i=0 ; i<11 ; i++) {
					System.out.print(num*i + "\t");
					
					}
				flag=false;
				
			}
			
			
		}
		
		tastiera.close();
		
	}

}
