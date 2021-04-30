package it.andrea.esercitazione.contatti.db;

import java.io.IOException;
import java.util.List;

import it.andrea.esercitazione.contatti.csv.CsvManager;
import it.andrea.esercitazione.contatti.entity.Contatto;

public class DBAndFileManager {
	public static void exportToCsv(String filename) {
		List<Contatto> contatti = HDBManager.selectAll();
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
