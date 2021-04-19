package it.beije.makemake.rubrica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Rubrica {
	static ArrayList<Contatto> cont = new ArrayList<Contatto>();

	public static void main(String[] args) throws Exception {
		caricaContatti(cont, "C:/Users/Padawan09/git/Makemake/src/it/beije/makemake/rubrica/rubrica1.csv");
		scriviLista("C:/Users/Padawan09/git/Makemake/src/it/beije/makemake/rubrica/rubrica1.csv","C:/Users/Padawan09/git/Makemake/src/it/beije/makemake/rubrica/contatti.txt");
	}

	public static void caricaContatti(List<Contatto> contatti, String path) throws Exception {
		FileReader fileReader = new FileReader(path);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		while (bufferedReader.ready()) {
			String row = bufferedReader.readLine();

			String[] rowParts = row.split(";");
			Contatto c = new Contatto();
			c.setNome(rowParts[0]);
			c.setCognome(rowParts[1]);
			c.setTelefono(rowParts[2]);
			c.setEmail(rowParts[3]);
			contatti.add(c);
			
		}
		for (Contatto c : contatti) {
			System.out.println(c.toString());
		}
	}
	
	
	
	public static void scriviLista(File orig, File clone) throws Exception {
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
