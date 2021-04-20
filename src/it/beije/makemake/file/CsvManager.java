package it.beije.makemake.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import it.beije.makemake.rubrica.Contatto;

public class CsvManager {
	
public static void main(String[] args) throws Exception {
	
		
		List<Contatto> contatti = new ArrayList<Contatto>();
		BufferedReader bufferedReader = new BufferedReader(new FileReader("C:/Users/Padawan07/Desktop/rubrica/rubrica.txt"));
		bufferedReader.readLine();
		
		while (bufferedReader.ready()) {
			String row = bufferedReader.readLine();
			String[] rowParts = row.split(";");
			Contatto contatto = new Contatto();
			contatto.setNome(rowParts[0]);
			contatto.setCognome(rowParts[1]);
			contatto.setTelefono(rowParts[2]);
			contatto.setEmail(rowParts[3]);
			contatti.add(contatto);
		}
		
		bufferedReader.close();
		
		System.out.println("Quanti contatti ci sono? \ncontatti : " + contatti.size());
		//	appendInRubrica(contatti, "C:/Users/Padawan07/Desktop/rubrica/rubrica_makemake.txt");
		System.out.println("----------------");
		duplicateContacs(contatti);
		System.out.println("----------------");
		System.out.println("cerca contatto con numero di ttelfono = 3433432444");
		System.out.println(searchContact(contatti, "","","3433432444",""));
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

	public static void duplicateContacs(List<Contatto> contatti ) {
		List<Contatto> duplicato = new ArrayList<Contatto>();
		
		for(int i = 0; i< contatti.size(); i++) {
			for(int j= i+1; j <contatti.size(); j++ )
				if(contatti.get(i).toString().equals(contatti.get(j).toString())) {
					
						duplicato.add(contatti.get(i));
				}
					
			}
		for (int i = 0; i < duplicato.size(); i++) {
			System.out.println(duplicato.toString() + " è un duplicato");
			}		
		}

	
	
	public static String searchContact(List<Contatto> contatti, String nome, String cognome, String telefono, String email) {
		for(int i = 0; i < contatti.size();i++) {
			if (contatti.get(i).getNome().equals(nome) || contatti.get(i).getCognome().equals(cognome) || contatti.get(i).getTelefono().equals(telefono) || contatti.get(i).getEmail().equals(email) )
				return contatti.get(i).toString();
		}
		return "Il contatto non è presente nella lista";

	}
	
	public static void sortContact(List<Contatto> contatti) {
		//contatti.sort();
	}
}
