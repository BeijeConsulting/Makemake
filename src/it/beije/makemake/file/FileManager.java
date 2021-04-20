package it.beije.makemake.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import it.beije.makemake.rubrica.Contatto;

public class FileManager {
	public static void main(String[] args) throws Exception {
		File file = new File("C:/Users/Padawan06/Desktop/rubrica1.csv");

		if (!(file.exists() || file.isFile())) {
			System.out.println("File non trovato");
			return;
		}
		// Leggere da file
		FileReader fileReader = new FileReader(file);

		int ch = fileReader.read();
		while (ch >= 0) {
			System.out.print((char) ch);
			ch = fileReader.read();
		}
		fileReader.close();
		System.out.println("-------------------------");

		// 2 metodo
		fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		while (bufferedReader.ready()) {
			System.out.println(bufferedReader.readLine());
		}
		bufferedReader.close();
		System.out.println("-------------------------");

		// 3 come separare i valori in ingresso

		fileReader = new FileReader(file);
		bufferedReader = new BufferedReader(fileReader);
		List<Contatto> contatti = new ArrayList<>();
		while (bufferedReader.ready()) {
			String line = bufferedReader.readLine();
			String[] values = line.split(";");
			contatti.add(new Contatto(values[0], values[1], values[2], values[3]));
		}
		bufferedReader.close();

		FileWriter fileWriter = new FileWriter(file, true);

		for (Contatto c : contatti) {
			fileWriter.write(c.getNome() + ";" + c.getCognome() + ";" + c.getTelefono() + ";" + c.getEmail() + ";\n");
		}

		fileWriter.close();

	}
}
