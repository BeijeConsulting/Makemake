package it.beije.makemake.addressBook.test;

import it.beije.makemake.addressBook.AddressBook;

public class Test {

    public static void main(String[] args) throws Exception {

        //testing AddressBook toString

        AddressBook addressBook = AddressBook.createFromCSV(
                "C:\\Users\\Padawan08\\IdeaProjects\\Makemake\\src\\it\\beije\\makemake\\addressBook\\test\\address_book.csv",
                ";", false);
        System.out.println(addressBook.toString());


        //testing address book merge
        addressBook.merge("C:\\Users\\Padawan08\\IdeaProjects\\Makemake\\src\\it\\beije\\makemake\\addressBook\\test\\address_book2.csv",
                ";", false);

        //testing sort
        addressBook.sort();

        //testing AddressBook toFile
        addressBook.toFile("C:\\Users\\Padawan08\\IdeaProjects\\Makemake\\src\\it\\beije\\makemake\\addressBook\\test\\out.csv",
                ",");
    }
}
