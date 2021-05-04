package it.andrea.esercitazione.contatti.db.hibernate;

import java.io.IOException;
import java.util.List;

import it.andrea.esercitazione.contatti.csv.CsvManager;
import it.andrea.esercitazione.contatti.entity.Contatto;

public class DBAndFileManager {
	private static HDBManager hdbManager = new HDBManager();
	public static void exportToCsv(String filename) {
		List<Contatto> contatti = hdbManager.selectAll();
		try {
			CsvManager.writeList(contatti, filename);
		} catch (IOException e) {
			System.out.println("Errore nella scrittura del file");
			e.printStackTrace();
		}
	}

	public static void importFromCsv() {

	}

	public static void exportToXml() {

	}

	public static void importFromXml() {

	}
}
