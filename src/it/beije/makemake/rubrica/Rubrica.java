package it.beije.makemake.rubrica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Rubrica {
	static List<Contatto> contatti=new ArrayList<Contatto>();
	
	public static void main(String[] args ) throws Exception{
		
		caricaRubrica(contatti,"C:\\Users\\Padawan02\\Desktop\\rubrica1.csv");
		//mergeRubriche("C:\\Users\\Padawan02\\Desktop\\rubrica1.csv","C:\\Users\\Padawan02\\Desktop\\rubrica2.csv","C:\\Users\\Padawan02\\Desktop\\rubrica_nuova.txt");
		//nameOrder(contatti);
		cognomeOrder(contatti);
	}
	
		
	public static void caricaRubrica(List<Contatto> contatti , String pathFile) throws Exception {
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile));
		
		while (bufferedReader.ready()) {
			String row = bufferedReader.readLine();
			//System.out.println(row);
			String[] rowParts = row.split(";");
			Contatto contatto = new Contatto();
			contatto.setNome(rowParts[0]);
			contatto.setCognome(rowParts[1]);
			contatto.setTelefono(rowParts[2]);
			contatto.setEmail(rowParts[3]);
			contatti.add(contatto);
		}
		
		//for(Contatto c : contatti) {
		//	System.out.println(c.toString());
		//}
		
		bufferedReader.close();
	}
	
	
	public static void mergeRubriche(String pathFile1,String pathFile2,String pathFile3) throws Exception{
		List<Contatto> contatti1=new ArrayList<Contatto>();
		
		
		caricaRubrica(contatti1,pathFile1);
		caricaRubrica(contatti1,pathFile2);
		
		FileWriter writer = new FileWriter(new File(pathFile3),true);
		for ( Contatto contatto : contatti1) {
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
	
	
	public static void nameOrder(List<Contatto> contatti ) {
		
		Collections.sort(contatti, (c1,c2)->c1.getNome().compareTo(c2.getNome()));
		
		for(Contatto c : contatti) {
			System.out.println(c.toString());
		}
	
	}
	
	public static void cognomeOrder(List<Contatto> contatti) {
		Collections.sort(contatti,(c1,c2)->c1.getCognome().compareTo(c2.getCognome()));
		for(Contatto c : contatti) {
			System.out.println(c.toString());
		}
	}
	
	public static void cercaContatto(List<Contatto> contatti, String attributo) {
		
		
	}
}
