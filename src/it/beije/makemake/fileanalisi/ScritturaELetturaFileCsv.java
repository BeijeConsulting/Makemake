package it.beije.makemake.fileanalisi;

import java.io.File;
import java.io.FileReader;
import java.io.*;

public class ScritturaELetturaFileCsv {

	public static void main(String[] args) throws Exception{
		File f = new File("C:/Users/jacopo/Desktop/java/jacopopazzo.csv");
		System.out.println(" il file esiste?"+ f.exists());
		System.out.println(" è una directori?"+ f.isDirectory());
		System.out.println(" è un file?"+ f.isFile());
		System.out.println("-------------------------------------");
		

		FileWriter fileWriter= new FileWriter(f);
		fileWriter.write("jacopo ; campagnoli; 3319019527\n");
		fileWriter.write("ivo ; mosca ; 3319019527\n");
		fileWriter.write("riccardo ; dibella; 3319019527\n");
		fileWriter.flush();
		fileWriter.close();
		
		
		FileReader filereader =new FileReader(f);
		BufferedReader bufferedReader = new BufferedReader(filereader);
		while (bufferedReader.ready()) {
			String row =bufferedReader.readLine();
			
			String[] rowParts = row.split(";");
			System.out.println("Nome: " +rowParts[0]);
			System.out.println("cognome: " +rowParts[1]);
			System.out.println("telefono: " +rowParts[2]);
			
		}
		
		
		bufferedReader.close();
		
		
	}
	

}
