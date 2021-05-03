package it.beije.makemake.addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.beije.makemake.rubrica.Contatto;

public class AddressBookMain {

	public static void main(String[] args) {
		
		int scelta = 0, id = 0;
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
//				contacts = newOperation.getContactList();
//				for(Contatto c : contacts) {
//					System.out.println(c.toString());
//				}
				newOperation.listaContatti();
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
				//newOperation.addContact(contact);
				newOperation.aggiungiContatto(contact);
				System.out.println("Fatto.");
				break;
			case 3:
				String update = "";
				System.out.print("Inserisci nome e cognome del contatto che vuoi modificare: ");
				Scanner inputInsert = new Scanner(System.in);
				String answer = inputInsert.nextLine();
				String[] modify = answer.split(" ");
				id = newOperation.getContact(modify[0], modify[1]);
				System.out.println();
				do {
					System.out.print("Quale dato vuoi modificare? ");
					System.out.println();
					Scanner inputUpdate = new Scanner(System.in);
					update = inputUpdate.nextLine();
					if((!update.equals("cognome")) && (!update.equals("nome")) && (!update.equals("telefono")) && (!update.equals("email"))) {
						System.out.println("Errore! Dato non valido.");
					}
				}while((!update.equals("cognome")) && (!update.equals("nome")) && (!update.equals("telefono")) && (!update.equals("email")));
				System.out.print("Inserisci il nuovo dato da inserire: ");
				Scanner inputNew = new Scanner(System.in);
				String newData = inputNew.nextLine();
				//newOperation.updateContact(id, update, newData);
				newOperation.modificaContatto(id, update, newData);
				System.out.println("fatto.");
				break;
			case 4:
				System.out.print("Inserisci nome e cognome del contatto che vuoi eliminare: ");
				Scanner inputDelete = new Scanner(System.in);
				String delete = inputDelete.nextLine();
				String[] person = delete.split(" ");
				id = newOperation.getContact(person[0], person[1]);
				//newOperation.deleteContact(person[0], person[1]);
				newOperation.eliminaContatto(id);
				System.out.println("Fatto.");
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
