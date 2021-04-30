package it.beije.makemake.database;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import it.beije.makemake.rubrica.Contatto;
import it.beije.makemake.rubrica.ListaContatti;

public class FromHBToFile {
	
	public static void main(String[] args) {
			
		//String riga;
		String percorsoFile = "C:\\JavaFile\\";
		//String readFile = "AddressBook.csv";
		String writeFile = "rubrica.txt";
		Session session = null;
		ListaContatti contacts = new ListaContatti();
		
		session = HDBConnection.getConnection();	
		Query<Contatto> query = session.createQuery("SELECT c FROM Contatto as c");
		for(Contatto c : query.list()) {
			contacts.caricaLista(c);
		}
		session.close();
		
		try {
			PrintStream write = new PrintStream(new FileOutputStream(percorsoFile + writeFile));
			write.println(contacts.toString());
			
		}catch(IOException e) {
			System.out.println("Errore nell'input.");
		}
	}
}
