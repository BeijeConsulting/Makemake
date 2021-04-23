package it.beije.makemake.RubricaScann;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RubricaScanner {

	static List<Contatto> contatti = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		Scanner tastiera = new Scanner(System.in);
		boolean ciclo = true;
		System.out.println("Inserisci il nome del file da cui caricare la rubrica");
		String path = tastiera.nextLine();
		menu();

		do {
			System.out.println("Che cosa vuoi fare?");
			int var = tastiera.nextInt();
			tastiera.nextLine();
			switch (var) {
			case 1:

				initRubrica(path);
				break;
			case 2:
				stampaContatti(contatti);
				break;
			case 3:
				System.out.println("Inserisci : Nome,cognome,telefono,email(opzionale)");
				String contact = tastiera.nextLine();
				newContact(contact);
				break;
			case 4:
				System.out.println("Inserisci il nome del contatto da cercare");
				String cont = tastiera.nextLine();
				search(cont);
				break;
			case 5:
				System.out.println("Cosa vuoi fare modificare o rimuovere ? ");
				String choise = tastiera.nextLine();
				if (choise.equalsIgnoreCase("modificare")) {
					System.out.println("Inserisci nome e cognome del contatto da modificare");
					String elim = tastiera.nextLine();
					System.out.println("Come vuoi modificarlo?");
					String modifica = tastiera.nextLine();
					change(elim, modifica);
					break;
				} else if (choise.equalsIgnoreCase("rimuovere")) {
					System.out.println("Inserisci nome e cognome del contatto da rimuovere");
					String elim = tastiera.nextLine();
					elimina(elim);
					break;
				}

				System.out.println("Non hai inserito un opzione valida");
				break;
			case 6:
				System.out.println("");
				salvaModifiche(path);
				break;
			case 7:
				ciclo = false;
				System.out.println("Grazie per aver lavorato con noi!");
				break;

			}

		} while (ciclo);

	}

	public static void menu() {
		System.out.println();
		System.out.println("----------Menu----------");
		System.out.println("1) Carica rubrica");
		System.out.println("2) Visualizza rubrica ");
		System.out.println("3) Inserisci un nuovo contatto ");
		System.out.println("4) Ricerca contatto ");
		System.out.println("5) Modifica o rimuovi un contatto");
		System.out.println("6) Salva modifiche della rubrica");
		System.out.println("7) Exit");
	}

	public static void stampaContatti(List<Contatto> campo) {
		Rubrica.nameOrder(campo);
		for (Contatto c : campo) {
			System.out.println(c.toString());
		}
	}

	public static void initRubrica(String path) throws Exception {
		if (path.contains(".csv")) {
			Rubrica.caricaRubrica(contatti, path);
		} else {
			path += ".csv";
			Rubrica.caricaRubrica(contatti, path);
		}
	}

	public static void newContact(String contact) {
		String[] parts = contact.split(",");
		Contatto c = new Contatto();
		boolean flag = false;
		c.setNome(parts[0]);
		c.setCognome(parts[1]);
		c.setTelefono(parts[2]);
		if (parts.length == 4)
			c.setEmail(parts[3]);

		for (Contatto contac : contatti) {
			if (c.equals(c, contac)) {
				flag = true;
			}
		}
		if (!flag)
			contatti.add(c);

	}

	public static void search(String name) {
		Rubrica.nameOrder(contatti);
		List<Contatto> c = Rubrica.cercaContatto(contatti, "nome", name);
		stampaContatti(c);
	}

	public static void change(String scelta, String mod) {
		String[] dati = scelta.split(" ");
		String[] datiMod = mod.split(";");
		List<Contatto> myC = Rubrica.cercaContatto(contatti, "nome", dati[0]);
		boolean flag = false;
		int index = 0;
		myC = Rubrica.cercaContatto(myC, "cognome", dati[1]);
	

		for (int i = 0; i < contatti.size(); i++) {
			if (contatti.get(i).equals(contatti.get(i), myC.get(0))) {
				flag = true;
				index = i;
				break;
			}
		}

		contatti.get(index).setNome(datiMod[0]);
		contatti.get(index).setCognome(datiMod[1]);
		contatti.get(index).setTelefono(datiMod[2]);
		if (datiMod.length == 4) {
			contatti.get(index).setEmail(datiMod[3]);
		} else {
			contatti.get(index).setEmail(null);
		}

	}

	public static void elimina(String scelta) {
		String[] dati = scelta.split(" ");
		List<Contatto> myC = Rubrica.cercaContatto(contatti, "nome", dati[0]);
		boolean flag = false;
		int index = 0;
		myC = Rubrica.cercaContatto(myC, "cognome", dati[1]);

		for (int i = 0; i < contatti.size(); i++) {
			if (contatti.get(i).equals(contatti.get(i), myC.get(0))) {
				flag = true;
				index = i;
				break;
			}
		}
		contatti.remove(index);
	}

	public static void salvaModifiche(String path) throws Exception {
		FileWriter writer = new FileWriter(new File(path));
		for (Contatto contatto : contatti) {
			writer.write(contatto.getCognome());
			writer.write(';');
			writer.write(contatto.getNome());
			writer.write(';');
			writer.write(contatto.getTelefono());
			writer.write(';');
			writer.write(contatto.getEmail());
			writer.write('\n');
		}

		writer.flush();
		writer.close();

	}

}
