package it.beije.makemake.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JPAMenu {
	//Variabili
	static Scanner input = new Scanner(System.in);
	static List<Contatto> rubrica = new ArrayList<>();
	
	
	public static void main(String[] args) {
		boolean ciclo = true;
		
		menu();
		
		do {
			System.out.println("Want you want to do?");
			int var = input.nextInt();
			input.nextLine();
			
			switch(var) {
			//Select with JPA Criteria
			case 1 : 
				rubrica = JPAManager.select();
				break;
			//Print all elements
			case 2 : 
				print();
				break;
			//Insert new contact
			case 3 : 
				Contatto c = createContact();
				JPAManager.insert(c);
				break;
			case 4 : 
				int id = input.nextInt();
				System.out.println(JPAManager.findContatto(id));
				break;
			case 5 :
				 System.out.println("Insert the name of the contact u want to find");
				 String nameSearch = input.nextLine();
				 System.out.println("Insert the surname of the contact u want to find");
				 String surnameSearch = input.nextLine();
				 JPAManager.search(nameSearch, surnameSearch);
				 break;
			case 6 :  
				System.out.println("Choose the contact id you want to update");
				String idex = input.nextLine();
				int idx = Integer.parseInt(idex);
				
				System.out.println("Change the name ");
				String name = input.nextLine();
				
				System.out.println("Change the surname ");
				String surname = input.nextLine();
				JPAManager.update(idx, name, surname);
				break;
			case 7 : 
				System.out.println("Choose the contact id you want to remove");
				int inde = input.nextInt();
				JPAManager.remove(inde);
				
			}
		}while(ciclo);

	}

	
	public static void menu() {
		System.out.println();
		System.out.println("----------Menu----------");
		System.out.println("1) Upload Rubrica from the DB");
		System.out.println("2) Print Rubrica ");
		System.out.println("3) Insert new Contact in the DB");
		System.out.println("4) Search a contact by id ");
		System.out.println("5) Search a contact by name and surname");
		System.out.println("6) Change a contact");
		System.out.println("7) Remove a contact");
		System.out.println("8) Save your Rubrica");
		System.out.println("9) Exit");
	}
	
	public static void print() {
		for(Contatto c : rubrica)
			System.out.println(c);
	}

	public static Contatto createContact() {
		Contatto c = null;
		
		System.out.println("Insert name");
		String name = input.nextLine();
		
		System.out.println("Insert surname");
		String surname = input.nextLine();
		
		System.out.println("Insert number");
		String number = input.nextLine();
		
		System.out.println("Insert email");
		String email = input.nextLine();

		c = new Contatto ( name,surname,number,email);
		return c;
}
}
