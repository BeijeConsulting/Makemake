package it.beije.makemake.db;

import java.io.File;
import java.util.Scanner;

import it.beije.makemake.rubrica.ContattiManager;
import it.beije.makemake.rubrica.ContattoRubrica;

public class DbClient {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		boolean f = true;
		String s;
		do {
			System.out.println("---------------------------------------------------");
			System.out.println("Benvenuto, scegli l operazione che vuoi effettuare?");
			System.out.println("1) ricerca un contatto");
			System.out.println("2) inserisci un contatto");
			System.out.println("3) modifica un contatto");
			System.out.println("4) rimuovi un contatto");
			System.out.println("5) esporta il db in un file");
			System.out.println("7) mostra tutti i contatti");
			System.out.println("8) importa un file nel db");
			System.out.println("9) esci");
			System.out.println("---------------------------------------------------");
			s = in.nextLine();
			switch (s) {
			case "1":
				System.out.println("quale campo vuoi cercare?");
				String camp = in.nextLine();
				System.out.println("inserisci il valore");
				String value = in.nextLine();
				MyDbManagerCriteria.selectBy(camp, value);
				;
				break;
			case "2":
				ContattoRubrica cont = new ContattoRubrica();
				System.out.println("nome");
				String nome = in.nextLine();
				cont.setNome(nome);
				System.out.println("cognome");
				String cognome = in.nextLine();
				cont.setCognome(cognome);
				System.out.println("telefono");
				String telefono = in.nextLine();
				cont.setTelefono(telefono);
				System.out.println("email");
				String email = in.nextLine();
				cont.setEmail(email);

				MyDbManagerSession.insert(cont);
				break;
			case "3":
			case "4":
				System.out.println("inserisci campo e valore da rimuovere");
				String campo=in.nextLine();
				String valore=in.nextLine();
				System.out.println(MyDbManagerSession.selectBy(campo,valore));
				
				MyDbManagerSession.delete(MyDbManagerSession.selectBy(campo,valore));
			case "5":
			case "6":
			case "7":
				MyDbManagerCriteria.selectAll();
				break;
			case "8":
				MyDbManagerSession.insert(ContattiManager.getContactList(new File(ContattiManager.rubricaDir)));
				break;
			case "9":
				System.out.println("arrivederci");
				f = false;
				break;
			}
		} while (f == true);

	}

}
