package it.beije.makemake.fileanalisi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import it.beije.makemake.rubrica.ContattoRubrica; 

public class CreazioneRurica {
	
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
	
	public static void appendInRubrica(List<ContattoRubrica> contatti, String pathFile) throws Exception {
		FileWriter writer = new FileWriter(new File(pathFile), true);
		for (ContattoRubrica contatto : contatti) {
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
		
		File f = new File("C:/Users/jacopo/Desktop/java/jacopopazzo2.csv");
		System.out.println("file exists ? " + f.exists());
		System.out.println("file isFile ? " + f.isFile());
		System.out.println("file isDirectory ? " + f.isDirectory());
 
		System.out.println("-------------------\n");
		
		List<ContattoRubrica> contatti = new ArrayList<ContattoRubrica>();
		BufferedReader bufferedReader = new BufferedReader(new FileReader("C:/Users/jacopo/Desktop/java/jacopopazzo.csv"));
		while (bufferedReader.ready()) {
			String row = bufferedReader.readLine();
			String[] rowParts = row.split(";");
			ContattoRubrica contatto = new ContattoRubrica();
			
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
			
		}
		
		bufferedReader.close();
		System.out.println("contatti : " + contatti.size());
		
		appendInRubrica(contatti, "C:/Users/jacopo/Desktop/java/rubrica_makemake.txt");
	}

}
