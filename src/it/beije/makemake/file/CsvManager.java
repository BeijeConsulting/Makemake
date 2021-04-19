package it.beije.makemake.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import it.beije.makemake.rubrica.Contatto;

public class CsvManager {

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
			// fileWriter.write(fileReader.read());
			fileWriter.write(bufferedReader.readLine());
		}
		fileWriter.close();
		fileReader.close();
	}

	public static void appendInRubrica(List<Contatto> contatti, String pathFile) throws Exception {
		
		FileWriter writer = new FileWriter(new File(pathFile), true);
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

	public static void main(String[] args) throws Exception {

		File f = new File("C:/Users/Padawan09/git/Makemake/src/it/beije/makemake/rubrica/rubrica1.csv");
		System.out.println("file exists ? " + f.exists());
		System.out.println("file isFile ? " + f.isFile());
		System.out.println("file isDirectory ? " + f.isDirectory());

//		System.out.println("-------------------\n");
//		
//		FileReader fileReader = new FileReader(f);
//		int c = fileReader.read();
//		while (c >= 0) {
//			System.out.print((char) c);
//			c = fileReader.read();
//		}

		System.out.println("-------------------\n");

		List<Contatto> contatti = new ArrayList<Contatto>();
		BufferedReader bufferedReader = new BufferedReader(new FileReader("C:/Users/Padawan09/git/Makemake/src/it/beije/makemake/rubrica/contatti.txt"));
		// BufferedReader bufferedReader = new BufferedReader(fileReader);
		while (bufferedReader.ready()) {
			String row = bufferedReader.readLine();
			// System.out.println(row);
			String[] rowParts = row.split(";");
			Contatto contatto = new Contatto();
			contatto.setNome(rowParts[0]);
			contatto.setCognome(rowParts[1]);
			contatto.setTelefono(rowParts[2]);
			contatto.setEmail(rowParts[3]);
			contatti.add(contatto);
			System.out.println("nome : " + rowParts[0]);
			System.out.println("cognome : " + rowParts[1]);
			System.out.println("telefono : " + rowParts[2]);
			System.out.println("email : " + rowParts[3]);
			System.out.println("---------");

//			StringTokenizer tokenizer = new StringTokenizer(row, ";");
//			System.out.println("nome : " + tokenizer.nextToken());
//			System.out.println("cognome : " + tokenizer.nextToken());
//			System.out.println("telefono : " + tokenizer.nextToken());
//			System.out.println("email : " + tokenizer.nextToken());
//			System.out.println("-------------------");
		}
		
		bufferedReader.close();
		System.out.println("contatti : " + contatti.size());

		appendInRubrica(contatti, "C:/Users/Padawan09/git/Makemake/src/it/beije/makemake/rubrica/rubrica1.csv");

//		FileWriter fileWriter = new FileWriter(f);
//		FileWriter fileWriter = new FileWriter(f, true);
//		fileWriter.write("ciao Makemake1\n");
//		fileWriter.flush();
//		fileWriter.write("ciao Makemake2");
//		fileWriter.close();
//		fileWriter.write("ciao Makemake3");

//		cloneTxtFile(new File("C:/Users/Padawan09/git/Makemake/src/it/beije/makemake/rubrica/rubrica1.csv"), new File("C:/temp/new_prova.txt"));
		
	}

}

