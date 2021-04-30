package it.beije.makemake.rubrica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Scanner;

import it.beije.makemake.database.JdbcExample;
import it.beije.makemake.file.*;

public class Main {
	
	public static String file = "C:/Users/Padawan07/Desktop/rubrica/rubrica.txt";

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/makemake?serverTimezone=CET", "root", "Beije07");
		
		Scanner in = new Scanner(System.in);
		boolean flag = false;

		System.out.println("RUBRICA:");
		List<Contatto> contatti = CsvManager.leggiCsv(file);
		//stampaContatti(contatti);
		
		CICLO: do {
			GestisciRubrica.stampaMenu();
			String s = (String)in.nextLine().trim();
			flag = true;
			switch (s) {
			case "1": //Aggiungi
				contatti.add(GestisciRubrica.leggiContatto(in));
				System.out.println(contatti.size());
				CsvManager.scriviListaInCsv(contatti, file);
				flag = false;
				break;
			case "2": //Rimuovi
				GestisciRubrica.stampaContatti(contatti);
				contatti.remove(GestisciRubrica.leggiContatto(in));
				CsvManager.scriviListaInCsv(contatti, file);
				flag = false;

				break;
			case "3"://Cerca
				GestisciRubrica.stampaContatti(contatti);
				System.out.println(GestisciRubrica.searchContact(contatti, GestisciRubrica.leggiContatto(in)));
				break;
			case "4"://Duplicati
				GestisciRubrica.duplicateContact(contatti);
				break;
			case "5"://RIordina
				GestisciRubrica.sortByName(contatti);
				GestisciRubrica.stampaContatti(contatti);
				break;
			case "6"://Modifica
				//modificaContatto(contatti);
			case "7": //unisci contatti da DB a csv
				List<Contatto> a =(JdbcExample.select(connection));
				for(int i=0;i<a.size();i++) {
					if(!(GestisciRubrica.searchContact(contatti, a.get(i), 0))) {
						contatti.add(a.get(i));
					}
				}
				CsvManager.scriviListaInCsv(contatti,file);
				break;
			case "8"://metti csv in db
				for(int i=0;i<contatti.size();i++) {
					JdbcExample.insert(connection, contatti.get(i));
				}
				break;
				
			default:
				break CICLO;
			}
		} while (flag);
		System.out.println("fine");
	}
}
