package it.beije.makemake.file;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

import it.beije.makemake.rubrica.ContattiManager;
import it.beije.makemake.rubrica.Contatto;

public class ContattiClient {

	public static void aggiungiContatto(File file) throws Exception {
		Scanner in = new Scanner(System.in);
		if (file.exists()) {
			
			System.out.println("nome: ");
			String nome= in.nextLine();
			System.out.println("cognome: ");
			String cognome= in.nextLine();
			System.out.println("telefono: ");
			String telefono= in.nextLine();
			System.out.println("email: ");
			String email= in.nextLine();
			Contatto c = new Contatto(nome, cognome, telefono, email);
			FileWriter fr = new FileWriter(file, true);
			fr.append(c.toCsv());
			fr.append("\n");
			fr.close();
		} else {
			System.out.println("non esiste questo file, vuoi crearlo? S, N");
			String s = in.nextLine();
			if (s.equals("s")) {
				System.out.println("nome: ");
				String nome= in.nextLine();
				System.out.println("cognome: ");
				String cognome= in.nextLine();
				System.out.println("telefono: ");
				String telefono= in.nextLine();
				System.out.println("email: ");
				String email= in.nextLine();
				Contatto c = new Contatto(nome, cognome, telefono, email);
				FileWriter fr = new FileWriter(file);
				fr.append(c.toCsv());
				fr.append("\n");
				fr.close();
			} 
		}
		in.close();
		System.out.println("operazione effettuata, arrivederci");

	}
	
	
//	public static void modificaContatto(File f) throws Exception {
//		Scanner in=new Scanner(System.in);
//		if()
//		
//	

	public static void cercaContatto(File f) throws Exception {
		Scanner in = new Scanner(System.in);
		List<Contatto> risultato= ContattiManager.getContactList(f);
		if (f.exists()) {
			System.out.println("nome: ");
			String nome=in.nextLine();
			risultato= ContattiManager.searchBy(risultato, "nome", nome);
			if(risultato.size()==0) {
			System.out.println("nessunc contatto trovato");
			}else {
				System.out.println("trovati " + risultato.size()  + " contatti ");
				System.out.println(risultato);
			}
		} else {
			System.out.println("non esiste questo file");
			} 		
	
		System.out.println("arrivederci");

	}

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		System.out.println(("quale file vuoi modificare?"));
		File f =new File(in.nextLine());
		Boolean flag = true;
		String c;
		do {
			System.out.println("---------------------------");
			System.out.println("Benvenuto, cosa vuoi fare?");
			System.out.println("a: Visualizza rubrica");
			System.out.println("b: Aggiungi un contatto");
			System.out.println("c: Ricerca un contatto");
			System.out.println("d: Modifica un contatto");
			System.out.println("e: Rimuovi un contatto");
			System.out.println("q: Esci");
			System.out.println("---------------------------");
			c = in.nextLine();

			switch (c) {
			case "a"://visualizza la rubrica
				ContattiManager.printContactList(ContattiManager.sortByName(ContattiManager.getContactList(f)));
				
				break;			
			case "b": // aggiungi un contatto.
				aggiungiContatto(f);
				break;
			case "c":// cercare un contatto
				cercaContatto(f);
				break;			
			case "d":// modificare contatto
				
				break;
			case "e":
			}
		} while (c.equals("q"));
		in.close();
	}

}
