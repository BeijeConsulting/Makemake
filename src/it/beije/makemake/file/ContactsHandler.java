package it.beije.makemake.file;


import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.internal.build.AllowSysOut;
import org.w3c.dom.Document;

import it.beije.makemake.file.rubrica.Contatto;
import it.beije.makemake.file.xml.ManagerXML;
import it.beije.makemake.database.hibernate.HDBexample;
import it.beije.makemake.file.csv.Manager;

public class ContactsHandler {
	private static final Scanner in = new Scanner(System.in);
	private static boolean flag = true;
	
	public static void main(String arg[]) {
		menu();
	}
	
	public static void menu() {
		System.out.println("Benvenuto, se vuoi iniziare ad inserire i contatti nella tua rubrica");
		String input;

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
					write();
					break;
				case "i":
					importFromFileToDB();
					break;
				case "e":
					exportFromDBtoFile();
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
			file = new File(path);
		}while(!file.isFile());
		
		int i = path.lastIndexOf('.');
		
		if(i == -1)
			System.out.println("Errore nella ricerca dell'estensione");
		
		exten = path.substring(i+1);
		
		try {
			if(exten.equals("xml")) {
				Document doc = ManagerXML.openFileToRead(path);
				ArrayList<Contatto> contList = ManagerXML.retriveContactTags(doc);
				ManagerXML.printXmlDocument(contList);
			}else if(exten.equals("csv")) 
			{
				BufferedReader buffer = Manager.openFileToRead(path);
				ArrayList<Contatto> contList = Manager.convertRubricaToList(buffer);
				for(Contatto cont : contList) {
					System.out.println(cont);
				}
			}else {	
				System.out.println("Estensione file non valida!");
			}
		}catch(Exception e) {
			e.getStackTrace();
		}		
		
	}
	
	public static void change() {
		File file = null;
		String path, exten;
		do{
			System.out.println("Forniscimi il nome di un  file valido di cui vuoi modificare un contatto");
			path = in.nextLine();
			file =new File(path);
		}while(!file.isFile());
		
		int i = path.lastIndexOf('.');
		
		if(i == -1)
			System.out.println("Errore nella ricerca dell'estensione");
		
		exten = path.substring(i+1);
		
		try {
			if(exten.equals("xml")) {
				ManagerXML.changeContact(path);
			}else if(exten.equals("csv")) 
			{
				Manager.changeContact(path);
			}else {	
				System.out.println("Estensione file non valida!");
			}
		}catch(Exception e) {
			e.getStackTrace();
		}	
		
	}
	
	public static void write() {
		File file = null;
		String path, exten;
		do{
			System.out.println("Forniscimi il nome di un  file valido in cui vuoi scrivere");
			path = in.nextLine();
			file =new File(path);
		}while(!file.isFile());
		
		
		Contatto cont = createContact();

		int i = path.lastIndexOf('.');
		
		if(i == -1)
			System.out.println("Errore nella ricerca dell'estensione");
		
		exten = path.substring(i+1);
		
		try {
			if(exten.equals("xml")) {
				ManagerXML.addContact(path, cont);
			}else if(exten.equals("csv")) 
			{
				Manager.addContact(path, cont);
			}else {	
				System.out.println("Estensione file non valida!");
			}
		}catch(Exception e) {
			e.getStackTrace();
		}		
		
	}
	
	public static void importFromFileToDB() {
		
		
		System.out.println("Seleziona il file da cui vuoi importare i file nel database");
		File file = null;
		String path, exten;
		
		do{
			System.out.println("Forniscimi il nome di un  file valido che vuoi leggere(ti trovi sul desktop) ?");
			path = in.nextLine();
			file = new File(path);
		}while(!file.isFile());
		
		int i = path.lastIndexOf('.');
		
		if(i == -1)
			System.out.println("Errore nella ricerca dell'estensione");
		
		exten = path.substring(i+1);
		System.out.println("Database before insertion");
		List<Contatto> table = HDBexample.select();
		for(Contatto c : table) {
			System.out.println(c);
		}
		
		try {
			if(exten.equals("xml")) {
				Document doc = ManagerXML.openFileToRead(path);
				ArrayList<Contatto> contList = ManagerXML.retriveContactTags(doc);
				
				for(Contatto c : contList) {
					HDBexample.insert(c);
				}
			}else if(exten.equals("csv")) 
			{
				BufferedReader buffer = Manager.openFileToRead(path);
				ArrayList<Contatto> contList = Manager.convertRubricaToList(buffer);
				for(Contatto c : contList) {
					HDBexample.insert(c);
				}
			}else {	
				System.out.println("Estensione file non valida!");
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
		
		System.out.println("Database after insertion");
		table = HDBexample.select();
		for(Contatto c : table) {
			System.out.println(c);
		}
	}
	
	public static void exportFromDBtoFile() {
		System.out.println("Seleziona il file in cui vuoi importare i contatti salvati nel database");
		
		File file = null;
		String path, exten;
		
		do{
			System.out.println("Forniscimi il nome di un  file valido che vuoi leggere(ti trovi sul desktop) ?");
			path = in.nextLine();
			file = new File(path);
		}while(!file.isFile());
		
		int i = path.lastIndexOf('.');
		
		if(i == -1)
			System.out.println("Errore nella ricerca dell'estensione");
		
		exten = path.substring(i+1);
		System.out.println("Database");
		List<Contatto> table = HDBexample.select();
		for(Contatto c : table) {
			System.out.println(c);
		}
		ArrayList<Contatto> table1 = new ArrayList<>(table);
		
		try {
			if(exten.equals("xml")) {
				ManagerXML.addContactList(path, table1);
			}else if(exten.equals("csv")) 
			{
				Manager.addContactList(path, table1);
			}else {	
				System.out.println("Estensione file non valida!");
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
