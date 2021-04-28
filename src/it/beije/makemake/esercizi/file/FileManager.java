package it.beije.makemake.esercizi.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import it.beije.makemake.rubrica.Contatto;

public class FileManager {
	/*
	 * metodo per caricare i contatti di una rubrica (che restituisca una lista di
	 * contatti)
	 * 
	 * metodo che scriva questa lista (ve l'ho già fatto io ma vedete se potete
	 * migliorarlo)
	 * 
	 * metodo che effettui la fusione di 2 file rubrica in uno solo
	 * 
	 * metodo che metta in ordine alfabetico i contatti (per nome o per cognome)
	 * 
	 * metodo che cerchi un contatto nella rubrica (per uno qualsiasi degli
	 * attributi)
	 * 
	 * metodo che individui eventuali contatti duplicati
	 */
	
	public static void fushion(File file1,File file2) throws IOException {
		FileWriter fileWriter = new FileWriter(file1);
		BufferedReader bufferedReader= new BufferedReader(new FileReader(file2));
		
		while(bufferedReader.ready()) {
			fileWriter.append(bufferedReader.readLine());
		}
		
		fileWriter.close();
		bufferedReader.close();
		
	}

	public static ArrayList<Contatto> convertRubricaToList(File file) throws Exception {
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		ArrayList<Contatto> contatti = new ArrayList<>();
		
		Contatto c = new Contatto();
		while (bufferedReader.ready()) {
			String line = bufferedReader.readLine();
			String values[] = line.split(";");
			
			c.setNome(values[0]);
			c.setCognome(values[1]);
			c.setTelefono(values[2]);
			c.setEmail(values[3]);
			
			contatti.add(c);
		}
		
		bufferedReader.close();

		return contatti;
	}
	
	public static void searchForDuplicates(ArrayList<Contatto> list) {

		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++)
				if (list.get(i).equals(list.get(j)))
					System.out.println("Duplicato trovato : " + list.get(i).toString());
		}
	}

	
	
	public static ArrayList<Contatto> carica(File file) throws IOException {
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		ArrayList<Contatto> rubrica = new ArrayList<Contatto>();
		Contatto c = new Contatto();
		while (bufferedReader.ready()) {
			String[] line = bufferedReader.readLine().split(";");
			
			c.setNome(line[0]);
			c.setCognome(line[1]);
			c.setTelefono(line[2]);
			c.setEmail(line[3]);
			
			rubrica.add(c);
		}
		bufferedReader.close();

		return rubrica;
	}

	public static void ordina(File fileName, ArrayList<Contatto> rubrica) throws IOException {
		for (int i = 0; i < rubrica.size(); i++) {
			for (int j = i + 1; j < rubrica.size(); j++) {
				if (((String) rubrica.get(i).getNome()).compareTo((String) rubrica.get(j).getNome()) > 0) {
					Collections.swap(rubrica, i, j);
				}
			}
		}
		FileWriter fileWriter = new FileWriter(fileName);
		for (Contatto c : rubrica) {
			fileWriter.write(c.getNome() + ";" + c.getCognome() + ";" + c.getTelefono() + ";" + c.getEmail());
			fileWriter.write("\n");
		}
		fileWriter.flush();
		fileWriter.close();

	}

	public static void main(String[] args) throws IOException {
		File file = new File("C:/Users/Padawan04/Desktop/rubrica1.txt");
		ArrayList<Contatto> rubrica = carica(file);
		ordina(file, rubrica);
		for (Contatto c : rubrica) {
			System.out.println(c);
		}

	}

}

