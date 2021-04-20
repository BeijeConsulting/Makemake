package it.beije.makemake.file;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import it.beije.makemake.file.rubrica.*;

public class Manager {
	public static void main(String[] arg) throws Exception{
		File file = new File("C:/Users/Padawan11/Desktop/rubrica1.csv");
		ArrayList<Contatto> contatti = new ArrayList<>();
		

		contatti = convertRubricaToList(file);
		
		searchForDuplicates(contatti);
		orderRubricaNome(file);
		
	}
	public static void readFile(File file) throws Exception{
		if( !(file.exists() || file.isFile())) {
			System.out.println("Hai cannato qualcosa");
			return ;
		}
			
	
		
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		while(bufferedReader.ready()) {
			System.out.println(bufferedReader.readLine());
		}
		bufferedReader.close();
	}
	
	public static ArrayList<Contatto> convertRubricaToList(File file) throws Exception{
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		ArrayList<Contatto> contatti = new ArrayList<>();
		
		while(bufferedReader.ready()) {
			String line = bufferedReader.readLine();
			String values[] = line.split(";");
			contatti.add(new Contatto(values[0], values[1], values[2], values[3]));
		}
		bufferedReader.close();
		//tolgo la prima riga che è inutile in quanto contiene solo
		//il NOME, COGNOME, TELEGONO, EMAIL
		contatti.remove(0);
		return contatti;
	}
	
	public static void searchForDuplicates(ArrayList<Contatto> list) {
		
		for(int i = 0; i< list.size(); i++) {
			for(int j= i+1; j <list.size(); j++ )
				if(list.get(i).equals(list.get(j)))
					System.out.println("Duplicato trovato : "+list.get(i).toString());
		}
	}

	public static void orderRubricaNome(File file) throws Exception{
		ArrayList<Contatto> contatti = convertRubricaToList(file);
		ArrayList<Contatto> newContatti = new ArrayList<>();
		
		ArrayList<String> nomi = new ArrayList<>();
		for(Contatto c : contatti) {
			nomi.add(c.getNome());		
		}
		
		Collections.sort(nomi);
		OUTER_LOOP:for(String str : nomi) {
					 for(Contatto c : contatti) {
						if(c.getNome().equals(str)) {
							newContatti.add(c);
							contatti.remove(c);
							continue OUTER_LOOP;
						}
					}
				}
		for(Contatto c : newContatti) {
			System.out.println(c);
		}
	}
}
