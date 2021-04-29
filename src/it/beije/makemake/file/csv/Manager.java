package it.beije.makemake.file.csv;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import it.beije.makemake.file.rubrica.*;

public class Manager {
	
	public static BufferedReader openFileToRead(String path) throws FileNotFoundException {
		File file = new File(path);
		FileReader reader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(reader);
		
		return buffer;
	}
		
	public static void addContact(String path, Contatto contatto) throws IOException{
		File file = new File(path);
		FileWriter writer = new FileWriter(file, true);
		

		writer.write(contatto.getNome());
		writer.write(';');
		writer.write(contatto.getCognome());
		writer.write(';');
		writer.write(contatto.getTelefono());
		writer.write(';');
		writer.write(contatto.getEmail());
		writer.write('\n');
		
		writer.flush();
		writer.close();
		
	}
	
	public static void openFileToWrite(String path, ArrayList<Contatto> list) throws IOException {
		File file = new File(path);
		FileWriter writer = new FileWriter(file);
		
		writer.write("NOME;COGNOME;TELEFONO;EMAIL;\n");
		
		for(Contatto contatto : list) {
			writer.write(contatto.getNome());
			writer.write(';');
			writer.write(contatto.getCognome());
			writer.write(';');
			writer.write(contatto.getTelefono());
			writer.write(';');
			writer.write(contatto.getEmail());
			writer.write('\n');
		}
		
		writer.flush();
		writer.close();
	}
	
	public static void searchContact(String path) throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Scanner in = new Scanner(System.in);
		BufferedReader buffer = openFileToRead(path);
		ArrayList<Contatto> cont = convertRubricaToList(buffer);
	
		System.out.println("Forniscimi il parametro per trovare il contatto : ");
		boolean flag = true;
		String value = null;
		
		do {
			value = in.next();
			
			switch(value) {
				case "Nome":
				case "Cognome":
				case "Telefono":
				case "Email" :
					flag = false;
					break;
				default:
					System.out.println("Hai cannato il parametro forniscimene uno valido!");
					break;
					
			}
		}while(flag);
		
		for(Contatto c : cont) {
			Method method = c.getClass().getMethod("get"+value, new Class[]{});
			String returnValue = (String)method.invoke(c, null);
			System.out.println(returnValue);
		}
		
		in.close();
		
		
	}
	
	public static void mergeFile(String pathA, String pathB, String destPath) throws IOException {
		BufferedReader bufferA = openFileToRead(pathA);
		BufferedReader bufferB = openFileToRead(pathB);
		
		ArrayList<Contatto> listA = convertRubricaToList(bufferA);
		ArrayList<Contatto> listB = convertRubricaToList(bufferB);
		
		for(Contatto cont: listB) {
			listA.add(cont);
		}
		//ho salvato tutti i contatti in listB
		
		openFileToWrite(destPath, listA);
		
	}
	
	public static ArrayList<Contatto> convertRubricaToList(BufferedReader bufferedReader) throws IOException{
		
		ArrayList<Contatto> contatti = new ArrayList<>();
		
		while(bufferedReader.ready()) {
			String line = bufferedReader.readLine();
			String values[] = line.split(";");
			contatti.add(new Contatto(values[0], values[1], values[2], values[3]));
		}
		bufferedReader.close();
		//tolgo la prima riga che è inutile in quanto contiene solo
		//il NOME, COGNOME, TELEGONO, EMAIL
//		contatti.remove(0);
		return contatti;
	}
	
	public static void searchForDuplicates(ArrayList<Contatto> list) {
		
		for(int i = 0; i< list.size(); i++) {
			for(int j= i+1; j <list.size(); j++ )
				if(list.get(i).equals(list.get(j)))
					System.out.println("Duplicato trovato : "+list.get(i).toString());
		}
	}

	public static void orderRubricaNome(String path) throws Exception{
		BufferedReader buffer = openFileToRead(path);
		ArrayList<Contatto> contatti = convertRubricaToList(buffer);
		ArrayList<Contatto> newContatti = new ArrayList<>();
		
		ArrayList<String> nomi = new ArrayList<>();
		
		for(Contatto c : contatti) {
			nomi.add(c.getNome());		
		}
		
		Collections.sort(nomi);
		OUTER_LOOP:for(String str : nomi) {
					 for(Contatto c : contatti) {
						if(c.getNome().equals(str)) {
							newContatti.add(c);
							contatti.remove(c);
							continue OUTER_LOOP;
						}
					}
				}
		for(Contatto c : newContatti) {
			System.out.println(c);
		}
	}
	
}
