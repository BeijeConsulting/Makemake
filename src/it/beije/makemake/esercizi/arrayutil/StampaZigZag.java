package it.beije.makemake.esercizi.arrayutil;

public class StampaZigZag {

	public static void main (String [] args) {
		
		int [] numeri = {1, 3, 5, 7, 9, 10, 8, 6, 4, 2};
		
		for (int i=0 ; i<numeri.length-5; i++) {
			System.out.print(numeri[i] + " ");
			System.out.print(numeri [numeri.length-(i+1)] + " ");
			
		}
		
		
		
	}
	
}
