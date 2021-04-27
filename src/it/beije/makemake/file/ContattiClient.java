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
	
	public static List<Contatto> cercaContatto(File f) throws Exception {
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
			System.out.println("non esiste questo file, arrivederci");
			} 		
		return risultato;

	}

	public static Contatto scegliContatto(List<Contatto> contactList) {
		Scanner in=new Scanner(System.in);
		if (contactList.size() == 0) {
			System.out.println("Non ci sono contatti!");
		} else if (contactList.size() == 1) {
			return contactList.get(0);
		} else {
			System.out.println("Inserisci il numero del contatto su cui intervenire: ");
			return contactList.get(in.nextInt() - 1);
		}
		return null;
	}
	
	public static void modificaContatto(File f) throws Exception {
	Scanner in=new Scanner(System.in);
	System.out.println("Selezione il nome del cotatto da cercare");
	Contatto c= scegliContatto(cercaContatto(f));
	if(c!= null) {
		Contatto nuovocont= new Contatto(c);
		System.out.println(("cosa vuoi modificare? nome, cognome, telefono o email?"));
		String s=in.nextLine();
		switch(s) {
		case "nome":
			System.out.println("inderisc il nuovo nome: ");
			nuovocont.setNome(in.nextLine());
			break;
		case "cognome":
			System.out.println("inderisc il nuovo cognome: ");
			nuovocont.setCognome(in.nextLine());
			break;
		case "telefono":
			System.out.println("inderisc il nuovo telefono: ");
			nuovocont.setTelefono(in.nextLine());
			break;
		case "email":
			System.out.println("inderisc la nuova email: ");
			nuovocont.setEmail(in.nextLine());
			break;
		}
		List<Contatto> contactList = ContattiManager.getContactList(f);
	}
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
				modificaContatto(f);
				break;
			case "q":
				break;
			default:
				System.out.println("comando non riconosciuto");
				break;
			}
		} while (c.equals("q"));
		in.close();
	}

}
