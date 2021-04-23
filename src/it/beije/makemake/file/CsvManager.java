package it.beije.makemake.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import it.beije.makemake.rubrica.Contatto;

public class CsvManager {

	public static List<Contatto> leggiCsv(String percorso) throws Exception {
		List<Contatto> contatti = new ArrayList<Contatto>();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(percorso));
		bufferedReader.readLine();

		while (bufferedReader.ready()) {
			String row = bufferedReader.readLine();
			String[] rowParts = row.split(";");
			Contatto contatto = new Contatto(rowParts[0],rowParts[1],rowParts[2],rowParts[3]);
			contatti.add(contatto);
		}

		bufferedReader.close();
		return contatti;
	}

	public static void cloneTxtFile(File orig, File clone) throws Exception {
		if (!orig.exists()) {
			System.out.println("File origine non trovato!!");
			return;
		}
		if (clone.exists()) {
			System.out.println("File destinazione già esistente!");
			return;
		}

		FileReader fileReader = new FileReader(orig);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		FileWriter fileWriter = new FileWriter(clone);
		while (fileReader.ready()) {
			fileWriter.write(bufferedReader.readLine());
		}
		fileWriter.close();
		fileReader.close();
	}

}
