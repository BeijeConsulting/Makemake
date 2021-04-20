package it.beije.makemake.file;

import java.util.Scanner;
import java.io.*;

public class DirectoryReader {

	
	public static void main(String arg[]) throws Exception{
		Scanner in = new Scanner(System.in);
		String path = null;
		File file = null;
		
		do {
			System.out.println("Inserisci il nome della Directory: ");
			path = in.next();
			file = new File(path);
		}while(!file.isDirectory());
		
		
		String fileName = file.getName();
		path = "C:/Users/Padawan11/Desktop/"+fileName+".txt";
		File destFile = new File(path);
		FileWriter writer = new FileWriter(destFile);
		analyzer(writer, file, "");
		writer.flush();
		writer.close();
		System.out.println("Top ho finito, Vuoi che ti apra il file oppure te lo apri tu?y/n");
		String answer = in.next();
		if(answer.equals("y"))
			Manager.readFile(destFile);
		
	}
	
	public static void analyzer(FileWriter writer, File directory, String indentation) throws Exception{
		String path = "";
		
		
		if(directory.isDirectory()) {
			writer.write(indentation+directory.getName()+"(dir)\n");
			indentation += "   ";
			for(String str : directory.list()) {
				path = directory.getAbsolutePath();
				File file = new File(path+"/"+str);
				analyzer(writer, file, indentation);
			}
		}else {
			writer.write(indentation+directory.getName()+"\n");
		}
	}
}
