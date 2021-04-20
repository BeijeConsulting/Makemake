package it.beije.makemake.file;

import java.io.File;
import java.io.IOException;

public class DirectoryUtil {

	public static void main(String[] args) throws IOException {
			File files[] = new File("C:\\Users\\Padawan06\\Desktop\\esercitazioni").listFiles();
			estraiContenuti(files);
	}

	public static void estraiContenuti(File[] files) throws IOException {	
		for(File f: files) {
			if(f.isDirectory()) {
				System.out.println(f.getName());
				estraiContenuti(f.listFiles());
			}else {
				System.out.println(f.getName());
			}
		}
		
	}

}
