package it.beije.RubricaCraiteria;


import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import it.beije.RubricaCraiteria.*;

public class AddressBookInput {



    private AddressBook addressBook = new AddressBook();
    Scanner sc = new Scanner(System.in);
    private static String[] optionsStrings = { "Crea da file XML",
            "Crea da file CSV", "Stampa rubrica", "Inserisci", "Cerca", "Rimuovi", "Carica su database", "Scarica da database",
            "Salva in formato XML", "Salva in formato CSV"
    };
    private static String[] dataFields = {
            "Nome", "Cognome", "Telefono", "Mail", "Indirizzo"
    };


    public static void main(String[] args) {

        AddressBookInput addressBookInput = new AddressBookInput();
        addressBookInput.getMenuString();

    }

    private void getMenuString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Seleziona un'opzione dal menu usando il numero corrispondente:\n");
        for (int i = 0; i < optionsStrings.length; i++) {
            sb.append(i+1 + ")" + optionsStrings[i] + "\n");
        }
        sb.append("\n").append("Scrivi \"exit\" per uscire").append("\n");
        System.out.println(sb.toString());
        getUserInput();
    }

    private void getUserInput() {
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("exit")) break;
            int option = Integer.parseInt(input);
            processInput(option);
            getMenuString();
        }
    }

    private void processInput(int option) {
        switch (option) {
            case 1: case 2: askFilePath(option);
                break;
            case 3:
                System.out.println(addressBook);
                break;
            case 4:
                addressBook.addContact(askDataInput());
                break;
            case 5:
                searchContact();
                break;
            case 6:
                addressBook.remove(askDataInput());
                break;
            case 7: addressBook.insertIntoDatabase2();
                break;
            case 8: addressBook = AddressBook.createFromDatabase2();
                break;
            case 9:
                saveToXML();
                break;
            case 10:
                saveToCSV();
                break;
        }
    }

    private void askFilePath(int option) {
        System.out.println("Inserisci il path del file:\n");
        Scanner sc = new Scanner(System.in);
        boolean wrongPath = false;
        do {
            String path = sc.nextLine();
            if (path.equalsIgnoreCase("exit")) break;
            try {
                if (option == 1) {
                    addressBook = AddressBook.createFromXML(path);
                    wrongPath = false;
                } else {
                    addressBook = createFromCSV(path);
                    wrongPath = false;
                }
            } catch (FileNotFoundException e) {
                System.out.println("Il file specificato non esiste!\n");
                wrongPath = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while(wrongPath);
    }

    private void saveToXML() {
        System.out.println("Inserisci percorso del file di output:");
        try {
            addressBook.toXMLFile(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Salvataggio in XML fallito");
            e.printStackTrace();
        }
    }

    private void saveToCSV() {
        System.out.println("Inserisci carattere di separazione:\n");
        String delim = sc.nextLine();
        System.out.println("Inserisci percorso del file di output:");
        try {
            addressBook.toFile(sc.nextLine(), delim);
        } catch (Exception e) {
            System.out.println("Salvataggio in CSV fallito");
            e.printStackTrace();
        }
    }

    private void searchContact() {
        Contact contact = askDataInput();
        List<Contact> contactList = addressBook.search(contact);
        for (Contact c :
                contactList) {
            System.out.println(c);
        }
    }

    public AddressBook createFromCSV(String path) throws Exception {
        Scanner sc = new Scanner(System.in);
        String delim = ";";
        boolean useQuotes = false;
        System.out.println("Inserisci carattere di separazione:\n");
        delim = sc.nextLine();
        System.out.println("Il contenuto dei campi è racchiuso tra apici? Y/N");
        String answer = sc.nextLine();
        if (answer.equalsIgnoreCase("y"))
            useQuotes = true;
        return AddressBook.createFromCSV(path, delim, useQuotes);
    }

    private Contact askDataInput() {
        String[] fields = new String[dataFields.length];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < dataFields.length; i++) {
            System.out.println(dataFields[i] + "\n");
            String input = sc.nextLine();
            fields[i] = input;
        }
        return new Contact(fields);
    }



}