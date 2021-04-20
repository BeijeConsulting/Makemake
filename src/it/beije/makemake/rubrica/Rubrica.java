package it.beije.makemake.rubrica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Rubrica {
	static ArrayList<Contatto> cont = new ArrayList<Contatto>();
	static File f = new File("C:/Users/Padawan09/git/Makemake/src/it/beije/makemake/rubrica/ciao.txt");
	static File g = new File("C:/Users/Padawan09/git/Makemake/src/it/beije/makemake/rubrica/come.txt");
	static File h = new File("C:/Users/Padawan09/git/Makemake/src/it/beije/makemake/rubrica/merge1.txt");
	public static void main(String[] args) throws Exception {
		//caricaContatti(cont, "C:/Users/Padawan09/git/Makemake/src/it/beije/makemake/rubrica/rubrica1.csv");
		//scriviLista(f, g);
		fusioneFile(f,g,h);
	}

	public static void caricaContatti(List<Contatto> contatti, String path) throws Exception {
		FileReader fileReader = new FileReader(path);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		while (bufferedReader.ready()) {
			String row = bufferedReader.readLine();

			String[] rowParts = row.split(";");
			Contatto c = new Contatto();
			c.setNome(rowParts[0]);
			c.setCognome(rowParts[1]);
			c.setTelefono(rowParts[2]);
			c.setEmail(rowParts[3]);
			contatti.add(c);

		}
		for (Contatto c : contatti) {
			System.out.println(c.toString());
		}
	}

	public static void scriviLista(File orig, File clone) throws Exception {
		
		if (!orig.exists()) {
			System.out.println("File origine non trovato!!");
			return;
		}
		if (clone.exists()) {
			System.out.println("File destinazione già esistente!");
			
		}

		FileReader fileReader = new FileReader(orig);
		FileWriter fileWriter = new FileWriter(clone);
		int length;
		while((length=fileReader.read())>0){
			fileWriter.write(length);
		}
		
		fileWriter.close();
		fileReader.close();
	}
	
	public static void fusioneFile(File f1,File f2, File f3) throws Exception {
		
		 FileReader a=new FileReader(f1);
		 FileReader b=new FileReader(f2);	
		 FileWriter fw1 = new FileWriter(f3);
		
		
			while (a.ready()) { // ready restituisce boolean se c è carattere da leggere
				fw1.write(a.read()); // .read prende carattere successivo

			}
			fw1.close();
			FileWriter fw2 = new FileWriter(f3, true); // con il true appende il risultato

			while (b.ready()) { // ready restituisce boolean se c è carattere da leggere
				fw2.write(b.read()); // .read prende carattere successivo

			}
			fw2.close();
			a.close();
			b.close();
		}

	}
