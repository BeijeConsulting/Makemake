package it.beije.makemake.addressBook;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddressBook {

    private List<Contact> contactList = new ArrayList<>();
    private Contact header;

    public List<Contact> getContactList() {
        return contactList;
    }

    private AddressBook() {}

    public static AddressBook createFromCSV(String path, String delim, boolean useQuotes) throws Exception {
        AddressBook addressBook = new AddressBook();
        FileReader fileReader = null;
        fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        addressBook.header = Contact.parseContact(bufferedReader.readLine(), delim, useQuotes);
        while (bufferedReader.ready()) {
            String row = bufferedReader.readLine();
            Contact c = Contact.parseContact(row, delim, useQuotes);
            addressBook.contactList.add(c);
        }
        fileReader.close();
        return addressBook;
    }

    @Override
    public String toString() {
        return format(" ");
    }

    public String format(String delim) {
        StringBuilder result = new StringBuilder();
        result.append(header.format(delim));
        for (Contact contact :
                contactList) {
            result.append(contact.format(delim));
        }
        return result.toString();
    }

    public void toFile(String destPath, String delim) throws IOException {
        File file = new File(destPath);
        FileWriter fileWriter = new FileWriter(file);
        String content = format(delim);
        fileWriter.write(content);
        fileWriter.close();
    }

    public AddressBook addContact(Contact contact) {
        contactList.add(contact);
        return this;
    }

    public AddressBook addContact(String contactString, String delim, boolean useQuotes) {
        Contact c = Contact.parseContact(contactString, delim, useQuotes);
        addContact(c);
        return this;
    }

    public AddressBook merge(AddressBook addressBook) {
        for (Contact c :
                addressBook.contactList) {
            this.addContact(c);
        }
        return this;
    }

    public AddressBook merge(String filePath, String delim, boolean useQuotes) throws Exception {
        AddressBook newBook = AddressBook.createFromCSV(filePath, delim, useQuotes);
        return this.merge(newBook);
    }

    public AddressBook sort() {
        Collections.sort(contactList);
        return this;
    }

}
