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

		while (bufferedReader.ready()) {
			String row = bufferedReader.readLine();
			String[] rowParts = row.split(";");
			Contatto contatto = new Contatto(rowParts[0],rowParts[1],rowParts[2],rowParts[3]);
			contatti.add(contatto);
		}

		bufferedReader.close();
		return contatti;
	}

	public static void scriviListaInCsv(List<Contatto> contatti, String pathFile) throws Exception {
		FileWriter writer = new FileWriter(new File(pathFile));
		for (int i = 0; i < contatti.size(); i++) {
			writer.write(contatti.get(i).getNome());
			writer.write(';');
			writer.write(contatti.get(i).getCognome());
			writer.write(';');
			writer.write(contatti.get(i).getTelefono());
			writer.write(';');
			writer.write(contatti.get(i).getEmail());
			writer.write('\n');
		}
		writer.flush();
		writer.close();
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
