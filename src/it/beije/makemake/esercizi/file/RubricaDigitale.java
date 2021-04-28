package it.beije.makemake.esercizi.file;

import java.util.Scanner;

public class RubricaDigitale {
	
	static Scanner tastiera = new Scanner(System.in);
	
	public static void main(String[] args) {

		boolean flag = true;
		
		int scelta = tastiera.nextInt();
		while(flag) {
			System.out.println("Inserisci un numero:");
			
		switch(scelta) {
			case 0:
				flag= false;
			
				System.out.println("Chiusura programma");
				break;
			
			case 1:
				String[] contatto = creaContatto();
				//lista.caricaLista(contatto[]);
				
				System.out.println("Contatto caricato con successo!!");
				
				break;
			case 2:
				
				break;
		}
		}
	}
	
	public static void menu() {
		System.out.println("___________MENU____________");
		System.out.println("1) Crea contatto.          ");
	}
	
	
	public static String [] creaContatto() {
		String [] contatto = new String [4];
		
		System.out.println("inserisci i dati del contatto:");
		System.out.println();
		
		System.out.println("Nome: ");
		contatto[0] = tastiera.nextLine();
		System.out.println();
		
		System.out.println("Cognome: ");
		contatto[1]  = tastiera.nextLine();
		System.out.println();
		
		System.out.println("Telefono: ");
		contatto[2]  = tastiera.nextLine();
		System.out.println();
		
		System.out.println("Email: ");
		contatto[3]  = tastiera.nextLine();
		System.out.println();
		
		return contatto;
	}
}
