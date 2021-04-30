package it.beije.makemake.addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.beije.makemake.rubrica.Contatto;

public class AddressBookMain {

	public static void main(String[] args) {
		
		int scelta = 0;
		Contatto contact = new Contatto();
		List<Contatto> contacts = new ArrayList<Contatto>();
		AddressBookCRUD newOperation = new AddressBookCRUD();
		
		System.out.println("##############################################");
		System.out.println("#####                                    #####");
		System.out.println("#####                 MENU'              #####");
		System.out.println("#####                                    #####");
		System.out.println("##### 1) Visualizza contatti.            #####");
		System.out.println("##### 2) Aggiungi un contatto.           #####");
		System.out.println("##### 3) Modifica un contatto.           #####");
		System.out.println("##### 4) Elimina un contatto.            #####");
		System.out.println("##### 5) Importa i contatti da un file   #####");
		System.out.println("##### 6) Esporta i contatti in un file   #####");
		System.out.println("#####                                    #####");
		System.out.println("##############################################");
		System.out.print("Digita il numero: ");
		Scanner input = new Scanner(System.in);
		scelta = input.nextInt();
		System.out.println();
		
		switch(scelta) {
			case 1:
				contacts = newOperation.getContactList();
				for(Contatto c : contacts) {
					System.out.println(c.toString());
				}
				break;
			case 2:
				System.out.print("Inserisci il cognome: ");
				Scanner inputSurname = new Scanner(System.in);
				String surname = inputSurname.nextLine();
				contact.setCognome(surname);
				System.out.print("Inserisci il nome: ");
				Scanner inputName = new Scanner(System.in);
				String name = inputName.nextLine();
				contact.setNome(name);
				System.out.print("Inserisci il numero di telefono: ");
				Scanner inputPhoneNumber = new Scanner(System.in);
				String phoneNumber = inputPhoneNumber.nextLine();
				contact.setTelefono(phoneNumber);
				System.out.print("Inserisci l'email: ");
				Scanner inputEmail = new Scanner(System.in);
				String email = inputEmail.nextLine();
				contact.setEmail(email);
				newOperation.addContact(contact);
				System.out.println("Fatto.");
				break;
			case 3:
				String update = "";
				do {
					System.out.print("Quale dato vuoi modificare? ");
					Scanner inputUpdate = new Scanner(System.in);
					update = inputUpdate.nextLine();
					if((update != "cognome") && (update != "nome") && (update != "telefono") && (update != "email")) {
						System.out.println("Errore! Dato non valido.");
					}
				}while((update != "cognome") && (update != "nome") && (update != "telefono") && (update != "email"));
				break;
			case 4:
				System.out.print("Inserisci nome e cognome del contatto che vuoi eliminare: ");
				Scanner inputDelete = new Scanner(System.in);
				String delete = inputDelete.nextLine();
				String[] person = delete.split(" ");
				newOperation.deleteContact(person[0], person[1]);
				break;
			case 5:
				break;
			case 6:
				break;
			default:
				System.out.println("Il numero che hai digitato non corrisponde a nessuna operazione.");
				break;			
		}
	}
}
