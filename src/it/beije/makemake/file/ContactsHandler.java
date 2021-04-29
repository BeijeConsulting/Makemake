package it.beije.makemake.file;


import java.io.File;
import java.util.Scanner;

import it.beije.makemake.file.rubrica.Contatto;
import it.beije.makemake.file.xml.ManagerXML;

public class ContactsHandler {
	private static final String desktopPath = "C:/Users/Padawan11/OneDrive/Desktop/";
	private static final Scanner in = new Scanner(System.in);
	private static boolean flag = true;
	
//	public static void main(String arg[]) {
//		menu();
//	}
//	
//	public static void menu() {
//		System.out.println("Benvenuto, se vuoi iniziare ad inserire i contatti nella tua rubrica");
//		String input = "";
//
//		do {
//			System.out.println("--------------------------------------------------------------");
//			System.out.println("Cosa vuoi fare?"
//					+ "(r:read , c:change, w:write q:quit, s:search, i:importFromDataBase, e:exportToDataBase)");
//			System.out.println("--------------------------------------------------------------");
//			input = in.nextLine();
//			switch(input) {
//				case "r":
//					//read();
//					break;
//				case "w":
//					//write();
//					break;
//				case "i":
//					//import();
//					break;
//				case "e":
//					//export();
//					break;
//				case "c":
//					change();
//					break;
//				case "q":
//					quit();
//					flag=false;
//					break;
//				default :
//					System.out.println("Inserisci un valore accettabile!");
//					break;
//					
//			}
//		}while(flag);
//	}
//	
//	private static Contatto createContact() {
//		String nome, cognome, telefono, email;
//		System.out.println("Inserisci il Nome : ");
//		nome = in.nextLine();
//		System.out.println("Inserisci il Cognome : ");
//		cognome = in.nextLine();
//		System.out.println("Inserisci il Telefono : ");
//		telefono = in.nextLine();
//		System.out.println("Inserisci il email : ");
//		email = in.nextLine();
//		
//		return  new Contatto(0,nome, cognome, telefono, email);
//	}
//	
//	public static void change() {
//		File file = null;
//		String path, exten;
//		do{
//			System.out.println("Forniscimi il nome di un  file valido che vuoi modificare(ti trovi sul desktop) ?");
//			path = in.nextLine();
//			path = desktopPath+path;
//			file =new File(path);
//		}while(file.exists());
//		
//		
//		Contatto cont = createContact();
//
//		
//		int i = path.lastIndexOf('.');
//		
//		
//		exten = path.substring(i+1);
//		
//		try {
//			if(exten.equals("xml")) {
//				ManagerXML.addContact(path, cont);
//			}else {
//				Manager.addContact(Manager.openFileToWrite(path), cont);
//			}
//		}catch(Exception e) {
//			e.getStackTrace();
//		}		
//		
//	}
//	
//	public static void quit() {
//		flag = true;
//		System.out.println("Sto chiudendo il programma!");
//	}
}
