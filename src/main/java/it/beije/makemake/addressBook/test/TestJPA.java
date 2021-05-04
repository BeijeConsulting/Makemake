package it.beije.makemake.addressBook.test;

import it.beije.makemake.addressBook.AddressBook;

public class TestJPA {




    public static void main(String[] args) {
        //testing database interaction with JPA

        //testing download from db
        AddressBook addressBook = AddressBook.createFromDatabaseJPA();
        System.out.println(addressBook);

        //testing update & merge to db
        addressBook.updateNameAndDBJPA("Pierino", "Alfonso");
        System.out.println(addressBook);

        //testing removal
        addressBook.removeAllAndUpdateDB("Alberto");
        System.out.println(addressBook);
    }
}
