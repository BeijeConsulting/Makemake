package it.beije.makemake.esercizi.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import it.beije.makemake.rubrica.ContattoAnnotation;

public class FileUtils {

public static void main(String[] args) throws Exception {
		
		File f = new File("C:/temp/vincitori.txt");
		System.out.println("file exists ? " + f.exists());
		System.out.println("file isFile ? " + f.isFile());
		System.out.println("file isDirectory ? " + f.isDirectory());

		
		
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader("C:/temp/vincitori.txt"));
		
		while (bufferedReader.ready()) {
			String linea = bufferedReader.readLine();
			
			
			String [] separati = linea.split(";");
			System.out.println(Arrays.toString(separati));
			



		}
		
		bufferedReader.close();

}
}
