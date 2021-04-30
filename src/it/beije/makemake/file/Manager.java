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
			
		}}
	
	
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
		/*for (int i = 0; i < rubrica.size(); i++) { -- codice ordinamento bubblesort
			for (int j = i + 1; j < rubrica.size(); j++) {
				if ((rubrica.get(i).getNome()).compareTo(rubrica.get(j).getNome()) > 0) {
					Collections.swap(rubrica, i, j);
				}
			}
		}*/

		//Collections.sort((List<T>) rubrica);

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
