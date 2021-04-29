package it.beije.makemake.esercizi.cicli;

import java.util.Scanner;

public class Tartaglia {

	public static void main(String[] args) {
		
		boolean flag = true;
		int check=0;
		Scanner tastiera = new Scanner(System.in);
		
		
		while(flag) {
		System.out.println("Inserisci il numero di righe di cui vuoi visualizzare il Triangolo:");
		 check = tastiera.nextInt();
			if( check > 0) {
				flag = false;
			}else {
				System.out.println("Errore!!");
				System.out.println("Hai inserito un numero minore di 0");
			}

		}
		
		
		
		
		
		
		stampaSerie(check);
		
	tastiera.close();
	}
	
	public static void stampaSerie(int a) {
		String[] serie = new String[] {"1", "\t", "2", "\t", "1"};
		int terzo;
		
		System.out.println("1");
		System.out.println( "1" +"\t" + "1");
		System.out.println("1" + "\t" + "2");
		
		
		for ( int riga=3; riga<a ; riga++) {
			
			StringBuilder nuovaSerie = new StringBuilder("1\t1");
			
//			for (int j=1, posizione=0; j<serie.length() ;j+=2, posizione+=2) {
//				
//				terzo= (int)serie.charAt(posizione) + (int)serie.charAt(posizione+2);
//				nuovaSerie.insert(j , "\t"+terzo);
//				
//				
//				
//				
//			}
//			
//			System.out.println(nuovaSerie);
//			serie= nuovaSerie;
		}
		
		
		
		
		
	}
}
