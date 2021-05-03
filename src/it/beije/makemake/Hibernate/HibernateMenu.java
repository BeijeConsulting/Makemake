package it.beije.makemake.Hibernate;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.beije.makemake.Hibernate.Contatto;

public class HibernateMenu {
	static List<Contatto> contatti = new ArrayList<>();
	static Scanner tastiera = new Scanner(System.in);
	private static HDBSingleton newSingleton ;


	public static void main(String[] args) throws Exception{
		boolean ciclo = true;
		
		//newSingleton =  HDBSingleton.getHDBSingleton();
		System.out.println("Insert the path file where u want to charge your rubrica");
		String pathIn = tastiera.nextLine();
		System.out.println("Insert the path file where u want to save your rubrica");
		String pathOut = tastiera.nextLine();
		menu();


		do {
			System.out.println("Want you want to do?");
			int var = tastiera.nextInt();
			tastiera.nextLine();
			
			switch(var) {
			case 1 : 
					contatti = HDBSManager.select();
					for(Contatto c : contatti)
						System.out.println(c);
			break;
			case 2 : print();
			break;
			case 3 : 
					Contatto c = createContact();
					HDBSManager.insert(c);
					break;
			case 4 : System.out.println("Insert the name of the contact u want to find");
					 String nameSearch = tastiera.nextLine();
					 System.out.println("Insert the surname of the contact u want to find");
					 String surnameSearch = tastiera.nextLine();
					 
					 HDBSManager.listSearch(nameSearch,surnameSearch);
					 
					 break;
			case 5 : System.out.println("Choose the contact id you want to update");
					 String idx = tastiera.nextLine();
					 int id = Integer.parseInt(idx);
					 System.out.println("Change the name ");

					 String name = tastiera.nextLine();
					 System.out.println("Change the surname ");
					 String surname = tastiera.nextLine();
					 
					 HDBSManager.update(id,name,surname);
					 break;
			case 6 : 
					System.out.println("Choose the contact id you want to remove");
					int inde = tastiera.nextInt();
					HDBSManager.delete(inde);
			case 7 : contatti = HDBSManager.select();
					 salvaModifiche(pathOut);
					 break;
			case 8 : ciclo = false;
					System.out.println("Grazie per aver lavorato con noi!");
					break;
			}

		}while(ciclo);
	}
	public static Contatto createContact() {
		Contatto c = null;
		System.out.println("Insert name");
		String name = tastiera.nextLine();
		System.out.println("Insert surname");
		String surname = tastiera.nextLine();
		System.out.println("Insert number");
		String number = tastiera.nextLine();
		System.out.println("Insert email");
		String email = tastiera.nextLine();

		c = new Contatto ( name,surname,number,email);
		return c;
	}
	public static void print() {
		for(Contatto c : contatti)
			System.out.println(c);
	}

	public static void menu() {
		System.out.println();
		System.out.println("----------Menu----------");
		System.out.println("1) Upload Rubrica from the DB");
		System.out.println("2) Print Rubrica ");
		System.out.println("3) Insert new Contact in the DB");
		System.out.println("4) Search a contact ");
		System.out.println("5) Change a contact");
		System.out.println("6) Remove a contact");
		System.out.println("7) Save your Rubrica");
		System.out.println("8) Exit");
	}
	public static void salvaModifiche(String path) throws Exception {
		FileWriter writer = new FileWriter(new File(path));
		for (Contatto contatto : contatti) {
			writer.write(contatto.getNome());
			writer.write(';');
			writer.write(contatto.getCognome());
			writer.write(';');
			writer.write(contatto.getTelefono());
			writer.write(';');
			if (contatto.getEmail() != null) {
				writer.write(contatto.getEmail());
			}

			writer.write('\n');
		}

		writer.flush();
		writer.close();

	}
}
