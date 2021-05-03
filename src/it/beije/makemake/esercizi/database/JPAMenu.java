package it.beije.makemake.esercizi.database;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;

import it.beije.makemake.rubrica.ContattoAnnotation;

public class JPAMenu {
	static Scanner tastiera = new Scanner(System.in);

	public static void main(String[] args) {

		boolean flag = true;
		
		
		while(flag) {
		menu();
		int scelta= tastiera.nextInt();
		
//		tastiera.nextLine(); Pulisco la linea
		
		switch(scelta) {
		
			default:
				System.out.println("ERRORE!!!");
				System.out.println("INSERISCI UN NUMERO VALIDO!!!");
				break;
			case 1:
				
				break;
			case 2:
				stampa();
				break;
				
			case 4:
				cerca();
				
			case 6:
				modifica();
				
				break;
		
		}
		
		}

	}
	
	public static void menu () {
		
		System.out.println("__________MENU__________");
		System.out.println("1) Upload Rubrica dal DataBase");
		System.out.println("2) Stampa Rubrica");
		System.out.println("3) Inserisci un nuovo contatto nel DataBase");
		System.out.println("4) Cerca contatto per id");
		System.out.println("5) Cerca contatto per nome e cognome");
		System.out.println("6) Modifica un contatto");
		System.out.println("7) Rimuovi un contatto");
		System.out.println("9) Exit");
		System.out.println("__________MENU__________");
		
	}
	
	public static void cerca() {
		System.out.println("Inserisci l'id del contatto dal cercare");
		
		int id=tastiera.nextInt();
		
		while(id<0) {
			System.out.println("Inserisci un id positivo!");
			id=tastiera.nextInt();
		}
		
		System.out.print(JPAManager.searchContatto(id));
		System.out.print("\n");
		
	}
	
	public static void stampa() {
		
		for(ContattoAnnotation c : JPAManager.select())
			System.out.println(c);
		
	}
	
	public static void modifica() {
		System.out.println("Inserisci l'id del contatto di cui vuoi modificare il nome e il cognome:");
		int id=tastiera.nextInt();
		String nome;
		String cognome;
		
		while(id<0) {
			System.out.println("Inserisci un id positivo!");
			id=tastiera.nextInt();
		}
		
		System.out.println("Contatto da modificare:");
		System.out.println(JPAManager.searchContatto(id));
		
		
		System.out.println("Inserisci il nuovo Nome:");
		tastiera.nextLine();
		nome =tastiera.nextLine();
		
		System.out.println("Inserisci il nuovo Cognome:");
		cognome =tastiera.nextLine();
		
		
		JPAManager.update(id, nome, cognome);
		
		System.out.println(JPAManager.searchContatto(id));
		System.out.println("Contatto modificato con successo!");
	}

}
