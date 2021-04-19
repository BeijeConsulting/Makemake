package it.andrea.esercitazionecontatti;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import it.beije.makemake.rubrica.Contatto;

public class ContattiManager {
	private static final String rubricaDir = "C:\\Users\\Padawan10\\git\\Makemake\\src\\it\\andrea\\esercitazionecontatti\\csvfiles\\rubrica1.csv";

	// metodo per caricare i contatti di una rubrica (che restituisca una lista di
	// contatti)
	public static List<Contatto> getContactList(File orig) throws Exception {
		List<Contatto> contactList = new ArrayList<Contatto>();
		FileReader fileReader = new FileReader(orig);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		while (bufferedReader.ready()) {
			String[] contactCsv = bufferedReader.readLine().split(";");
			contactList.add(new Contatto(contactCsv[0], contactCsv[1], contactCsv[2], contactCsv[3]));
		}
		return contactList;
	}

	// metodo che scriva questa lista (ve l'ho già fatto io ma vedete se potete
	// migliorarlo)

	// metodo che effettui la fusione di 2 file rubrica in uno solo

	// metodo che metta in ordine alfabetico i contatti (per nome o per cognome)

	// metodo che cerchi un contatto nella rubrica (per uno qualsiasi degli
	// attributi)

	// metodo che individui eventuali contatti duplicati

	public static void printContactList(List<Contatto> contactList) {
		for (Contatto contatto : contactList) {
			if (!contatto.getNome().equals("NOME")) {
				System.out.println(contatto.toString());
			}
		}
	}

	public static void main(String[] args) throws Exception {
		File file = new File(rubricaDir);
		printContactList(getContactList(file));
	}

}
