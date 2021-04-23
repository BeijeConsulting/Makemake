package it.beije.makemake.RubricaScann;

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
		//caricaRubrica(contatti,"C:\\Users\\Padawan02\\Desktop\\rubrica1.csv");
		//mergeRubriche("C:\\Users\\Padawan02\\Desktop\\rubrica1.csv","C:\\Users\\Padawan02\\Desktop\\rubrica2.csv","C:\\Users\\Padawan02\\Desktop\\rubrica_nuova.txt");
		//nameOrder(contatti);
		//cognomeOrder(contatti);
		//Contatto c=cercaContatto(contatti,attributo,p);
		//System.out.println(c.toString());
		
		cercaDuplicati(contatti);
		
		
		
	}
	
		
	public static void caricaRubrica(List<Contatto> contatti , String pathFile) throws Exception {
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile));
		boolean flag=false;
		while (bufferedReader.ready()) {
			String row = bufferedReader.readLine();
			//System.out.println(row);
			String[] rowParts = row.split(";");
			Contatto contatto = new Contatto();
			contatto.setNome(rowParts[0]);
			contatto.setCognome(rowParts[1]);
			contatto.setTelefono(rowParts[2]);
			if (rowParts.length == 4)
				contatto.setEmail(rowParts[3]);
			
			for(Contatto contac : contatti) {
				if(contatto.equals(contatto,contac)) {
					flag = true;
				}
			}
			if(!flag)
				contatti.add(contatto);
			
		}
		
		/*for(Contatto c : contatti) {
			System.out.println(c.toString());
		}*/
		
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
		
		Collections.sort(contatti, (c1,c2)->c1.getNome().toLowerCase().compareTo(c2.getNome().toLowerCase()));
		
		/*for(Contatto c : contatti) {
			System.out.println(c.toString());
		}
	*/
	}
	
	public static void cognomeOrder(List<Contatto> contatti) {
		Collections.sort(contatti,(c1,c2)->c1.getCognome().toLowerCase().compareTo(c2.getCognome().toLowerCase()));
		
		for(Contatto c : contatti) {
			System.out.println(c.toString());
		}
	}
	
	public static List<Contatto> cercaContatto(List<Contatto> contatti, String attributo,String p) {
		List<Contatto> omonimi = new ArrayList<>();
		switch(attributo) {
		case "nome" : 
			for(Contatto c : contatti) {
				if(c.getNome().equalsIgnoreCase(p)){
					omonimi.add(c);
				}
			}
			break;
		case "cognome" : 
			for(Contatto c : contatti) {
				if(c.getCognome().equalsIgnoreCase(p)) {
					 omonimi.add(c);
					 }
			}
			break;
		case "email" : 
			for(Contatto c : contatti) {
				if(c.getEmail().equalsIgnoreCase(p)) {
					omonimi.add(c);				
					}
			}
			break;

		}
		
	return omonimi;
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
