package it.beije.makemake.rubrica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Rubrica {
	static List<Contatto> contatti=new ArrayList<Contatto>();
	
	public static void main(String[] args ) throws Exception{
		
		
		caricaRubrica(contatti,"C:\\Users\\Padawan02\\Desktop\\rubrica1.csv");
	
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
			
		for(Contatto c : contatti) {
			System.out.println(c.toString());
		}
		bufferedReader.close();
	}
	
	
}
