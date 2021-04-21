package it.beije.makemake.rubrica;



public class Test {

    public static void main(String[] args) throws Exception {

        //testing AddressBook toString

        AddressBook addressBook = AddressBook.createFromCSV(
        		"C:/Users/Padawan09/git/Makemake/src/it/beije/makemake/rubrica/address_book.csv",
                ";", false);
        System.out.println(addressBook.toString());


        //testing address book merge
        addressBook.merge("C:/Users/Padawan09/git/Makemake/src/it/beije/makemake/rubrica/address_book2.csv",
                ";", false);

        //testing sort
        addressBook.sort();

        //testing AddressBook toFile
        addressBook.toFile("C:/Users/Padawan09/git/Makemake/src/it/beije/makemake/rubrica/out.csv",
                ",");
    }
}

