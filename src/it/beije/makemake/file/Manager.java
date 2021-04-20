package it.beije.makemake.file;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import it.beije.makemake.rubrica.Contatto;

public class Manager {
	/*
	 * metodo per caricare i contatti di una rubrica (che restituisca una lista di
	 * contatti)
	 * 
	 * metodo che scriva questa lista (ve l'ho già
	 * fatto io ma vedete se potete migliorarlo)
	 * 
	 * metodo che effettui la fusione di 2 file rubrica in uno solo
	 * 
	 *  metodo che metta in ordine
	 * alfabetico i contatti (per nome o per cognome)
	 * 
	 * metodo che cerchi un contatto nella rubrica (per uno qualsiasi degli attributi) 16:59 metodo che
	 * individui eventuali contatti duplicati
	 */
	
	
	public static ArrayList<Contatto> carica(String fileName) throws IOException {
		FileReader fileReader = new FileReader(fileName);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		ArrayList<Contatto> rubrica = new ArrayList<Contatto>();
		while(bufferedReader.ready()) {
			String[] line = bufferedReader.readLine().split(";");
			rubrica.add(new Contatto(line[0],line[1],line[2],line[3]));
		}
		bufferedReader.close();
		return rubrica;
	}
	
	
	public static void ordina()
	
	
	
	public static void main(String[] args) {

	}

}
  