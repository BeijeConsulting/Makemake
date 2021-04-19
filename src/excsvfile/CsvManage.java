package excsvfile;
import java.io.*;

public class CsvManage {
	public static void main(String[] args) throws Exception{
	
	File f = new File("C:\\Users\\Padawan13\\Desktop\\rubrica1.csv");
	System.out.println("file exists ? " + f.exists());
	System.out.println("file isFile ? " + f.isFile());
	System.out.println("file isDirectory ? " + f.isDirectory());
	
	System.out.println("Prova stampa del file con FileReader!");
	System.out.println("-------------------\n");
	
	// Stampa del file con fileReader
	FileReader fileReader = new FileReader(f);
	int c = fileReader.read();
	while (c >= 0) {
		System.out.print((char) c);
		c = fileReader.read();
	}
	fileReader.close();
	
	
	// Provare metodo di scrittura del file con FileWriter
	FileWriter fileWriter = new FileWriter(f);
//	FileWriter fileWriter = new FileWriter(f, true);
	fileWriter.write("ciao Makemake1\n");
	fileWriter.flush();
	fileWriter.write("ciao Makemake2\n");
	fileWriter.write("ciao Makemake3\n");
	fileWriter.close();
	
	File f1 = new File("C:\\Users\\Padawan13\\Desktop\\rubrica1.csv");
	System.out.println("Prova stampa del file modificato con FileWriter!");
	System.out.println("-------------------\n");
	
	// Stampa del file modificato con fileWriter
	FileReader fileReader1 = new FileReader(f1);
	int c1 = fileReader1.read();
	while (c1 >= 0) {
		System.out.print((char) c1);
		c1 = fileReader1.read();
	}
	fileReader1.close();
	
	
	//Provare metodo di clonazione

	
	
	}
}
