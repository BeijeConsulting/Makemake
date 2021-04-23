package it.beije.makemake.rubrica;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import it.beije.makemake.file.CsvManager;
import it.beije.makemake.file.XmlManager;

public class GestisciRubrica {

	public static String file = "C:/Users/Padawan07/Desktop/rubrica/rubrica.txt";
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		boolean flag = false;
		System.out.println("RUBRICA:");
		List<Contatto> contatti = CsvManager.leggiCsv(file);
		// stampaContatti(contatti);
		System.out.println("Cosa vuoi fare? " + "\n 1) Aggiungere contatto" + "\n 2) Rimuovere contatto"
				+ "\n 3) Cercare contatto" + "\n 4) Visualizzare contatti duplicati");

		do {
			String s = in.nextLine();
			flag = true;
			switch (s) {
			case "1":
				contatti.add(leggiContatto(in));
				aggiungiContatto(contatti, file);
				flag = false;
				break;
			case "2":

				break;
			case "3":
				break;
			case "4":
				duplicateContact(contatti);
				break;

			default:
				break;
			}
		} while (flag);

	}

	private static Contatto leggiContatto(Scanner in) {
		System.out.println("Nome?");
		String Nome = in.nextLine();
		System.out.println("Cognome?");
		String Cognome = in.nextLine();
		System.out.println("Telefono?");
		String Telefono = in.nextLine();
		System.out.println("Email?");
		String Email = in.nextLine();
		Contatto contatto = new Contatto(Nome, Cognome, Telefono, Email);
		return contatto;
	}

	public static void aggiungiContatto(List<Contatto> contatti, String pathFile) throws Exception {
		FileWriter writer = new FileWriter(new File(pathFile));
		for (Contatto contatto : contatti) {
			writer.write(contatto.getNome());
			writer.write(';');
			writer.write(contatto.getCognome());
			writer.write(';');
			writer.write(contatto.getTelefono());
			writer.write(';');
			writer.write(contatto.getEmail());
			writer.write('\n');
		}

		writer.flush();
		writer.close();
	}

	public static void duplicateContact(List<Contatto> contatti) {
		List<Contatto> duplicati = new ArrayList<Contatto>();
		boolean flag = false;
		for (int i = 0; i < contatti.size(); i++) {
			flag = false;
			for (int j = i + 1; j < contatti.size(); j++) {
				if (contatti.get(i).equals(contatti.get(j))) {
					if (duplicati.contains(contatti.get(i)))
						continue;
					flag = true;
					break;
				}
			}
			if (flag)
				duplicati.add(contatti.get(i));
		}
		for (int i = 0; i < duplicati.size(); i++) {
//			for (int j = i + 1; j < duplicati.size(); j++) {
//				if(duplicati.get(i).equals(duplicati.get(j)))
//					duplicati.remove(i);
//				
//			}

			System.out.println(duplicati.get(i).toString() + " è un duplicato");
		}
	}

	public static String searchContact(List<Contatto> contatti, String nome, String cognome, String telefono,
			String email) {
		for (int i = 0; i < contatti.size(); i++) {
			if (contatti.get(i).getNome().equals(nome) || contatti.get(i).getCognome().equals(cognome)
					|| contatti.get(i).getTelefono().equals(telefono) || contatti.get(i).getEmail().equals(email))
				return contatti.get(i).toString();
		}
		return "Il contatto non è presente nella lista";

	}

	public static void sortByName(List<Contatto> contatti) throws Exception {
		
		Collections.sort(contatti, (o1, o2) -> o1.getNome().compareTo(o2.getNome()));
		//writeList(contatti, file);
	}

	public static void stampaContatti(List<Contatto> contatti) {
		for (int i = 0; i < contatti.size(); i++) {
			System.out.println(contatti.get(i).toString());
		}
	}
	
}
