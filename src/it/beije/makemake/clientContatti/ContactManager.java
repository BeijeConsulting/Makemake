package it.beije.makemake.clientContatti;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.beije.makemake.file.Manager;
import it.beije.makemake.rubrica.Contatto;

public class ContactManager {
	private static List<Contatto> rubrica = new ArrayList<>();
	private static Scanner tastiera = new Scanner(System.in);
	private static String path = "C:\\Users\\Padawan06\\Desktop\\rubrica1.csv";

	public static void main(String[] args) throws Exception {
		File f = new File(path);
		rubrica = Manager.convertRubricaToList(f);
		boolean ciclo = true;
		
		do {
			menu();
			System.out.println("Cosa vuoi fare?");
			int scelta = tastiera.nextInt();
			tastiera.nextLine();
			switch (scelta) {
			case 1:
				visualizza();
				break;
			case 2:
				addContact();
				break;
			case 3:
				searchContact();
				break;
			case 4:
			
				editContact();
				break;
			case 5:
				removeContact();
				break;
			case 6:
				saveChanges(f);
				break;
			case 7:
				System.out.println("Hai premuto exit!");
				System.out.println("Ciao!");
				ciclo=false;
				break;
			}
		} while (ciclo);
		tastiera.close();
	}

	public static void menu() {
		System.out.println();
		System.out.println("---------Menu---------");
		System.out.println("1) Visualizza rubrica");
		System.out.println("2) Inserisci un nuovo contatto");
		System.out.println("3) Ricerca contatto");
		System.out.println("4) Modifica un contatto");
		System.out.println("5) Rimuovi un contatto");
		System.out.println("6) Salva modifiche");
		System.out.println("7) Exit");

	}

	public static void visualizza() {
		for (int i=0;i<rubrica.size();i++) {
			System.out.println((i+1)+")");
			System.out.println("Nome: "+rubrica.get(i).getNome()+" ");
			System.out.println("Cognome: "+rubrica.get(i).getCognome()+" ");
			System.out.println("Telefono: "+rubrica.get(i).getTelefono()+" ");
			if (rubrica.get(i).getEmail() != null) {
				System.out.println("Email: "+rubrica.get(i).getEmail()+" ");
			}

		}
	}

	public static void addContact() {
		String nome, cognome, telefono;
		System.out.println("nome: ");
		nome = tastiera.nextLine();
		System.out.println("cognome: ");
		cognome = tastiera.nextLine();
		System.out.println("telefono: ");
		telefono = tastiera.nextLine();
		String email = null;
		if (isPresent(nome, cognome)) {
			System.out.println("Contatto già presente, inserire un contatto diverso!");
			addContact();
		} else {
			System.out.println("Vuoi inserire anche il l'email?[S/N]");
			String scelta = tastiera.nextLine();
			if (scelta.equalsIgnoreCase("s")) {
				System.out.println("Inserire email: ");
				email = tastiera.nextLine();
			}
			rubrica.add(new Contatto(nome, cognome, telefono, email));
			Manager.ordina(rubrica);
		}
	}

	public static void searchContact() {
		System.out.println("nome: ");
		String nome = tastiera.nextLine();
		System.out.println("cognome: ");
		String cognome = tastiera.nextLine();
		if (isPresent(nome, cognome)) {
			for (Contatto c : rubrica) {
				if (c.getNome().equalsIgnoreCase(nome) && c.getCognome().equalsIgnoreCase(cognome)) {
					c.toString();
					break;
				}
			}
		} else {
			System.out.println("Contatto non presente");
		}
	}

	public static boolean isPresent(String nome, String cognome) {
		boolean flag = false;
		for (Contatto c : rubrica) {
			if (c.getNome().equalsIgnoreCase(nome) && c.getCognome().equalsIgnoreCase(cognome)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public static void editContact() {
		System.out.println("nome: ");
		String nome = tastiera.nextLine();
		System.out.println("cognome: ");
		String cognome = tastiera.nextLine();
		if (isPresent(nome, cognome)) {
			int i = getIndexOfContact(nome, cognome);
			System.out.println("Inserire nuovo nome: ");
			String newName = tastiera.nextLine();
			rubrica.get(i).setNome(newName);
			System.out.println("Inserire nuovo cognome: ");
			String newSurname = tastiera.nextLine();
			rubrica.get(i).setCognome(newSurname);
			System.out.println("Inserire nuovo cognome: ");
			String newNumber = tastiera.nextLine();
			rubrica.get(i).setTelefono(newNumber);
			System.out.println("Vuoi modificare anche l'email?[S/N]");
			String answer = tastiera.nextLine();
			if (answer.equalsIgnoreCase("S")) {
				System.out.println("Inserire nuovo email ");
				String newEmail = tastiera.nextLine();
				rubrica.get(i).setTelefono(newEmail);
			}
			Manager.ordina(rubrica);
			System.out.println("Modifica effettuata!");
		} else {
			System.out.println("Contatto non presente!");
		}
	}

	public static void removeContact() {
		System.out.println("nome: ");
		String nome = tastiera.nextLine();
		System.out.println("cognome: ");
		String cognome = tastiera.nextLine();
		if (isPresent(nome, cognome)) {
			int index = getIndexOfContact(nome, cognome);
			rubrica.remove(index);
			System.out.println("Contatto rimosso");
		} else {
			System.out.println("Contatto non rimosso, non esiste nella rubrica");
		}
	}

	public static int getIndexOfContact(String nome, String cognome) {
		int index = -1;
		if (isPresent(nome, cognome)) {
			for (int i = 0; i < rubrica.size(); i++) {
				if (rubrica.get(i).getNome().equalsIgnoreCase(nome)
						&& rubrica.get(i).getCognome().equalsIgnoreCase(cognome)) {
					index = i;
					break;
				}
			}
		}

		return index;
	}

	public static List<Contatto> searchDuplicates(String nome, String cognome) {
		List<Contatto> duplicati = new ArrayList<>();
		for (Contatto c : rubrica) {
			if (c.toString().contains(nome) || c.toString().contains(cognome)) {
				duplicati.add(c);
			}
		}
		return duplicati;
	}

	// salvare eventuali modifiche nella lista sul file
	public static void saveChanges(File f) throws IOException {
		FileWriter writer = new FileWriter(f);
		for (int i=0;i<rubrica.size();i++) {
			writer.write(rubrica.get(i).getNome());
			writer.write(';');
			writer.write(rubrica.get(i).getCognome());
			writer.write(';');
			writer.write(rubrica.get(i).getTelefono());
			writer.write(';');
			if (rubrica.get(i).getEmail() != null) {
				writer.write(rubrica.get(i).getEmail());
				writer.write('\n');
			}
			
		}
		writer.flush();
		writer.close();
	}

}
