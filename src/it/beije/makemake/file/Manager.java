package it.beije.makemake.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.beije.makemake.rubrica.Contatto;

public class Manager {
//	/*
//	 * metodo per caricare i contatti di una rubrica (che restituisca una lista di
//	 * contatti)
//	 * 
//	 * metodo che scriva questa lista (ve l'ho già fatto io ma vedete se potete
//	 * migliorarlo)
//	 * 
//	 * metodo che effettui la fusione di 2 file rubrica in uno solo
//	 * 
//	 * metodo che metta in ordine alfabetico i contatti (per nome o per cognome)
//	 * 
//	 * metodo che cerchi un contatto nella rubrica (per uno qualsiasi degli
//	 * attributi)
//	 * 
//	 * metodo che individui eventuali contatti duplicati
	
	public static void fushion(File file1,File file2) throws IOException {
		FileWriter fileWriter = new FileWriter(file1);
		BufferedReader bufferedReader= new BufferedReader(new FileReader(file2));
		
		while(bufferedReader.ready()) {
			fileWriter.append(bufferedReader.readLine());
		}
		
		fileWriter.close();
		bufferedReader.close();
		
	}

	public static List<Contatto> convertRubricaToList(File file) throws Exception {
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<Contatto> contatti = new ArrayList<>();

		while (bufferedReader.ready()) {
			String line = bufferedReader.readLine();
			String values[] = line.split(";");
			Contatto c = new Contatto();
			c.setNome(values[0]);
			c.setCognome(values[1]);
			c.setTelefono(values[2]);
			if(values.length>3) {
				c.setEmail(values[3]);
			}
			contatti.add(c);
		}
		
		bufferedReader.close();

		return contatti;
	}
	
	public static void searchForDuplicates(List<Contatto> list) {

		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++)
				if (list.get(i).equals(list.get(j)))
					System.out.println("Duplicato trovato : " + list.get(i).toString());
		}
//		
//		for (int i = 0; i < list.size(); i++) {
//			for (int j = i + 1; j < list.size(); j++)
//				if (list.get(i).getNome().equals(list.get(j).getNome())) {
//					if (list.get(i).getCognome().equals(list.get(j).getCognome())) {
//						System.out.println("Duplicato trovato : " + list.get(i).toString());
//					}
//				}
//
//		}
	}

	
	
	public static ArrayList<Contatto> carica(File file) throws IOException {
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		ArrayList<Contatto> rubrica = new ArrayList<Contatto>();
		while (bufferedReader.ready()) {
			String[] line = bufferedReader.readLine().split(";");
			rubrica.add(new Contatto(line[0], line[1], line[2], line[3]));
		}
		bufferedReader.close();

		return rubrica;
	}

	public static void ordina(List<Contatto> rubrica){
		for (int i = 0; i < rubrica.size(); i++) {
			for (int j = i + 1; j < rubrica.size(); j++) {
				if (((String) rubrica.get(i).getNome()).compareTo((String) rubrica.get(j).getNome()) > 0) {
					Collections.swap(rubrica, i, j);
				}
			}
		}
//		FileWriter fileWriter = new FileWriter(fileName);
//		for (Contatto c : rubrica) {
//			fileWriter.write(c.getNome() + ";" + c.getCognome() + ";" + c.getTelefono() + ";" + c.getEmail());
//			fileWriter.write("\n");
//		}
//		fileWriter.flush();
//		fileWriter.close();

	}

	public static void main(String[] args) throws IOException {
//		File file = new File("C:/Users/Padawan06/Desktop/rubrica1.csv");
//		ArrayList<Contatto> rubrica = carica(file);
//		ordina(file, rubrica);
//		for (Contatto c : rubrica) {
//			System.out.println(c);
//		}

	}

}
