package it.beije.makemake.file;


import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import org.w3c.dom.Document;

import it.beije.makemake.file.rubrica.Contatto;
import it.beije.makemake.file.xml.ManagerXML;
import it.beije.makemake.file.csv.Manager;

public class ContactsHandler {
	private static final String desktopPath = "C:/Users/Padawan11/OneDrive/Desktop/";
	private static final Scanner in = new Scanner(System.in);
	private static boolean flag = true;
	
	public static void main(String arg[]) {
		menu();
	}
	
	public static void menu() {
		System.out.println("Benvenuto, se vuoi iniziare ad inserire i contatti nella tua rubrica");
		String input = "";

		do {
			System.out.println("---------------------------------------------------------------------------------");
			System.out.println("Cosa vuoi fare?"
					+ "(r:read , c:change, w:write q:quit, s:search, i:importFromDataBase, e:exportToDataBase)");
			System.out.println("----------------------------------------------------------------------------------");
			input = in.nextLine();
			switch(input) {
				case "r":
					read();
					break;
				case "w":
					//write();
					break;
				case "i":
					//import();
					break;
				case "e":
					//export();
					break;
				case "c":
					change();
					break;
				case "q":
					quit();
					flag=false;
					break;
				default :
					System.out.println("Inserisci un valore accettabile!");
					break;
					
			}
		}while(flag);
	}
	
	private static Contatto createContact() {
		String nome, cognome, telefono, email;
		System.out.println("Inserisci il Nome : ");
		nome = in.nextLine();
		System.out.println("Inserisci il Cognome : ");
		cognome = in.nextLine();
		System.out.println("Inserisci il Telefono : ");
		telefono = in.nextLine();
		System.out.println("Inserisci il email : ");
		email = in.nextLine();
		
		return  new Contatto(nome, cognome, telefono, email);
	}
	
	public static void read() {
		File file = null;
		String path, exten;
		
		do{
			System.out.println("Forniscimi il nome di un  file valido che vuoi leggere(ti trovi sul desktop) ?");
			path = in.nextLine();
			file =new File(path);
		}while(file.isFile());
		
		int i = path.lastIndexOf('.');
		
		
		exten = path.substring(i+1);
		
		try {
			if(exten.equals("xml")) {
				Document doc = ManagerXML.openFileToRead(path);
				ArrayList<Contatto> contList = ManagerXML.retriveContactTags(doc);
				ManagerXML.printXmlDocument(contList);
			}else {
				BufferedReader buffer = Manager.openFileToRead(path);
				ArrayList<Contatto> contList = Manager.convertRubricaToList(buffer);
				System.out.println(contList);
			}
		}catch(Exception e) {
			e.getStackTrace();
		}		
		
	}
	
	public static void change() {
		File file = null;
		String path, exten;
		do{
			System.out.println("Forniscimi il nome di un  file valido che vuoi modificare(ti trovi sul desktop) ?");
			path = in.nextLine();
			file =new File(path);
		}while(file.isFile());
		
		
		Contatto cont = createContact();

		
		int i = path.lastIndexOf('.');
		
		
		exten = path.substring(i+1);
		
		try {
			if(exten.equals("xml")) {
				ManagerXML.addContact(path, cont);
			}else {
				Manager.addContact(path , cont);
			}
		}catch(Exception e) {
			e.getStackTrace();
		}		
		
	}
	
	public static void quit() {
		flag = true;
		System.out.println("Sto chiudendo il programma!");
	}
}
