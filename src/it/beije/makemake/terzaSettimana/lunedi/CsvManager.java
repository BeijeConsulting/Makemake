package it.beije.makemake.terzaSettimana.lunedi;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import it.beije.makemake.terzaSettimana.lunedi.Rubrica.Contatto;
/**
 * Scaletta generale:
 * 	1-Creao un oggetto File(filePath);
 * 	2-Creo un oggetto FileReadre(file);
 * 	3-Per leggere i caratteri faccio il cast (char)fileReader.read()
 * @author Padawan11
 *
 */
public class CsvManager {
	public static void cloneFile(File orig, File dest) throws Exception {
		//voglio fare la copia esatta di unn file in un altro file
		FileReader fileReader = new FileReader(orig);
		FileWriter fileWriter = new FileWriter(dest);
		
		while(fileReader.ready()) {
				fileWriter.write(fileReader.read());
		}
		fileReader.close();
		fileWriter.close();
	}
	public static void main(String[] arg) throws Exception {
		//ha 4 diversi costruttori noi usiamo quello base
		//in cui mettiamo il percorso in cui trovare il file
		File file = new File("C:/Users/Padawan11/Desktop/Rubrica.txt");
		//attenzione ho creato un oggetto file in java questo però potrebbe non 
		//esistere sul mio computer
		System.out.println("File : "+ file.exists());
		System.out.println("E un file: "+ file.isFile());
		System.out.println("E una directiory: "+ file.isDirectory());
		
		//Come faccio a leggere da un file?
		//ATTENZIONE e pensata per leggere file di testo 
		FileReader fileReader = new FileReader(file);
		//se uso read() leggo carattere per carattere
		int  c = fileReader.read();
		
		while(c >= 0) {
			System.out.print((char)c);
			c = fileReader.read();
		}
		
		System.out.println("\n------------------------------\n");
		//se invece voglio leggere tutta la prima riga e non 
		//carattere per carattere al posto di implementarlo a mano mi 
		//conviene usare la classe BufferedReader
		//ho già letto tutto il file quindi sono arrivato alla fine se
		//voglio rileggerlo devo aprire un nuovo fileReade
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader("C:/Users/Padawan11/Desktop/Rubrica.txt"));
		
		while(bufferedReader.ready()) {
			System.out.println(bufferedReader.readLine());
		}
		//Vediamo come andare ad estrapolare file di tipo CSW
	
		bufferedReader = new BufferedReader(new FileReader("C:/Users/Padawan11/Desktop/Rubrica.txt"));
		
		while(bufferedReader.ready()) {
			String line = bufferedReader.readLine();
			System.out.println(line);
			String[] separatedValues = line.split(";");
			System.out.println("Nome : "+ separatedValues[0]);
			System.out.println("Cognomee : "+ separatedValues[1]);
			System.out.println("Telefono : "+ separatedValues[2]);

		}
		//ATTENZIONE è  buona pratica chiamare il metodo .cloes() sul bufferedReader
		bufferedReader.close();
		//Se voglio scriver su un file devo usare il fileWrriter
		FileWriter fileWriter = new FileWriter("C:/Users/Padawan11/Desktop/prova.txt");
		fileWriter.write("Ciao MakeMake");
		//finche non chiamo flush() il file non viene modificato
		fileWriter.flush();
		//quando poi ho finito di usare la risorsa chiamo .close()
		fileWriter.close();
		cloneFile(new File("C:/Users/Padawan11/Desktop/Rubrica.txt"), new File("C:/Users/Padawan11/Desktop/prova.txt"));	
		//Voglio invertire nome e cognome all'interno del file
		//per fare ciò devo crearmi una classe aggiuntiva atta a memorizzare i contatti
		List<Contatto> lista = new ArrayList<>();
		
		bufferedReader = new BufferedReader(new FileReader("C:/Users/Padawan11/Desktop/Rubrica.txt"));
		
		while(bufferedReader.ready()) {
			String line = bufferedReader.readLine();
			System.out.println(line);
			String[] separatedValues = line.split(";");
			Contatto cont = new Contatto(separatedValues[0], separatedValues[1], separatedValues[2]);
			lista.add(cont);

		}
		appendRubrica(lista, "C:/Users/Padawan11/Desktop/prova.txt");
	}
	
	public static void appendRubrica(List<Contatto> contatti, String pathFile) throws Exception{
		File f = new File(pathFile);
		FileWriter fileWriter = new FileWriter(f);
		for(Contatto c : contatti) {
			fileWriter.write(c.getCognome());
			fileWriter.write(",");
			fileWriter.write(c.getNome());;
			fileWriter.write(",");
			fileWriter.write(c.getTelefono());
			fileWriter.write(",");
			fileWriter.flush();
		}
		fileWriter.close();
	}

}
