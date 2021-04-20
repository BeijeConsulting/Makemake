package it.beije.makemake.rubrica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Rubrica {
	static List<Contatto> contatti=new ArrayList<Contatto>();
	
	public static void main(String[] args ) throws Exception{
		Scanner tastiera=new Scanner(System.in);
		System.out.println("In base a cosa vuoi cercare ?");
		String attributo=tastiera.nextLine().toLowerCase();
		System.out.println("Inserisci " + attributo + " : ");
		String p=tastiera.nextLine();		
		caricaRubrica(contatti,"C:\\Users\\Padawan02\\Desktop\\rubrica1.csv");
		//mergeRubriche("C:\\Users\\Padawan02\\Desktop\\rubrica1.csv","C:\\Users\\Padawan02\\Desktop\\rubrica2.csv","C:\\Users\\Padawan02\\Desktop\\rubrica_nuova.txt");
		//nameOrder(contatti);
		//cognomeOrder(contatti);
		Contatto c=cercaContatto(contatti,attributo,p);
		System.out.println(c.toString());
		
		cercaDuplicati(contatti);
		
		
		
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
	
	public static Contatto cercaContatto(List<Contatto> contatti, String attributo,String p) {
		switch(attributo) {
		case "nome" : 
			for(Contatto c : contatti) {
				if(c.getNome().equalsIgnoreCase(p)){
					return c;
				}
			}
			break;
		case "cognome" : 
			for(Contatto c : contatti) {
				if(c.getCognome().equalsIgnoreCase(p)) {
					return c;				}
			}
			break;
		case "email" : 
			for(Contatto c : contatti) {
				if(c.getEmail().equalsIgnoreCase(p)) {
					return c;				}
			}
			break;

		}
		
	return null;
	}
	
	public static void cercaDuplicati(List<Contatto> contatti) {
		int num=0;
		for(int i =0 ; i<contatti.size(); i++) {
			Contatto c= contatti.get(i);
			for(int j=i+1 ; j<contatti.size(); j++) {
				if(c.getNome().equalsIgnoreCase(contatti.get(j).getNome())) 
					if(c.getCognome().equalsIgnoreCase(contatti.get(j).getCognome()))
						if(c.getTelefono().equalsIgnoreCase(contatti.get(j).getTelefono()))
							if(c.getEmail().equalsIgnoreCase(contatti.get(j).getEmail()))
								num++;

		}
		
		
	}
		System.out.println("Ci sono " + num + " contatti duplicati ");
	}
}
