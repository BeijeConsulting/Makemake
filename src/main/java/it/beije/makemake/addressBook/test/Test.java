package it.beije.makemake.addressBook.test;

import it.beije.makemake.addressBook.AddressBook;
import it.beije.makemake.addressBook.Contact;

import java.util.List;

public class Test {

    public static void main(String[] args) throws Exception {
//
//        //testing AddressBook toString
//
        AddressBook addressBook = AddressBook.createFromCSV(
                "C:\\Users\\Padawan08\\IdeaProjects\\Makemake\\src\\main\\java\\it\\beije\\makemake\\addressBook\\test\\address_book.csv",
                ";", false);
////        System.out.println(addressBook.toString());
//
//
//        //testing address book merge
//        addressBook.merge("C:\\Users\\Padawan08\\IdeaProjects\\Makemake\\src\\it\\beije\\makemake\\addressBook\\test\\address_book2.csv",
//                ";", false);
//
//        addressBook.sort();
//
//
//        //testing AddressBook toFile
//        addressBook.toFile("C:\\Users\\Padawan08\\IdeaProjects\\Makemake\\src\\it\\beije\\makemake\\addressBook\\test\\out.csv",
//                ",");
//
//
        //testing search

//

        //testing AddressBook from XML

        AddressBook addressBook2 = AddressBook.createFromXML("C:\\Users\\Padawan08\\IdeaProjects\\Makemake\\my_rubrica.xml");


        //testing sort
//        addressBook2.sort();
//        System.out.println(addressBook2);

        //testing search

//        List<Contact> result = addressBook2.search("camilla");
//        for (Contact c:
//                result) {
//            System.out.println(c);
//        }


        //test create XML file
//        addressBook.toXMLFile("C:\\temp\\aaa");

        //test insert data from AddressBook into DB
        String url = "jdbc:mysql://localhost:3306/makemake?serverTimezone=CET";
        String user = "root";
        String password = "Beije08";
//        addressBook2.insertIntoDatabase(url, user, password);

        //test create from DB
//        AddressBook addressBook3 = AddressBook.createFromDatabase(url, user, password);
//        System.out.println(addressBook3);


        //DB interaction with hibernate test

        //upload to db
        addressBook2.insertIntoDatabase2();

        //create from db
        AddressBook addressBook3 = AddressBook.createFromDatabase2();
        System.out.println(addressBook3);

        //testing update name and db
        addressBook3.updateNameAndDB("Carlo", "Ermenegildo");

        System.out.println();
        System.out.println(addressBook3);

        //test remove and update db
        addressBook3.removeAllAndUpdateDB("Ermenegildo");
        addressBook3.removeAllAndUpdateDB("Carlo");



    }
}
