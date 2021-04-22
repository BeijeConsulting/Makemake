package it.beije.makemake.addressBook.test;

import it.beije.makemake.addressBook.AddressBook;
import it.beije.makemake.addressBook.Contact;

import java.util.List;

public class Test {

    public static void main(String[] args) throws Exception {

        //testing AddressBook toString

        AddressBook addressBook = AddressBook.createFromCSV(
                "C:\\Users\\Padawan08\\IdeaProjects\\Makemake\\src\\it\\beije\\makemake\\addressBook\\test\\address_book.csv",
                ";", false);
//        System.out.println(addressBook.toString());


        //testing address book merge
        addressBook.merge("C:\\Users\\Padawan08\\IdeaProjects\\Makemake\\src\\it\\beije\\makemake\\addressBook\\test\\address_book2.csv",
                ";", false);

        addressBook.sort();


        //testing AddressBook toFile
        addressBook.toFile("C:\\Users\\Padawan08\\IdeaProjects\\Makemake\\src\\it\\beije\\makemake\\addressBook\\test\\out.csv",
                ",");


        //testing search
        List<Contact> result = addressBook.search("mario");
        for (Contact c:
             result) {
            System.out.println(c);
        }


        //testing AddressBook from XML

        AddressBook addressBook2 = AddressBook.createFromXML("C:\\Users\\Padawan08\\IdeaProjects\\Makemake\\rubrica.xml");
        System.out.println(addressBook);
    }
}
