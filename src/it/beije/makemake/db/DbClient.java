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
			System.out.println("6) mostra tutti i contatti");
			System.out.println("7) importa un file nel db");
			System.out.println("8) esci");
			System.out.println("---------------------------------------------------");
			s = in.nextLine();
			switch (s) {
			
			case "1":
				System.out.println("quale campo vuoi cercare?");
				String camp = in.nextLine();
				System.out.println("inserisci il valore");
				String value = in.nextLine();
				MyDbManagerCriteria.selectBy(camp, value);

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
				System.out.println("inserisci il vecchio contatto: ");
				ContattoRubrica oldcont = new ContattoRubrica();
				System.out.println("nome");
				String name = in.nextLine();
				oldcont.setNome(name);
				System.out.println("cognome");
				String surname = in.nextLine();
				oldcont.setCognome(surname);
				System.out.println("telefono");
				String cell = in.nextLine();
				oldcont.setTelefono(cell);
				System.out.println("email");
				String mail = in.nextLine();
				oldcont.setEmail(mail);
				System.out.println("inserisci il nuovo contatto: ");
				ContattoRubrica newcont = new ContattoRubrica();
				System.out.println("nome");
				String n = in.nextLine();
				newcont.setNome(n);
				System.out.println("cognome");
				String c = in.nextLine();
				newcont.setCognome(c);
				System.out.println("telefono");
				String t = in.nextLine();
				newcont.setTelefono(t);
				System.out.println("email");
				String m = in.nextLine();
				newcont.setEmail(m);
				MyDbManagerCriteria.update(oldcont,newcont);
				System.out.println("operazione effettuata");
				break;
			case "4":
				System.out.println("inserisci campo e valore da rimuovere");
				String campo = in.nextLine();
				String valore = in.nextLine();
				System.out.println(MyDbManagerSession.selectBy(campo, valore));

				MyDbManagerSession.delete(MyDbManagerSession.selectBy(campo, valore));
				break;
			case "5":
				MyDbManagerCriteria.exportToCsv(ContattiManager.dest);
				break;
			case "6":
				MyDbManagerCriteria.selectAll();
				break;
			case "7":
				MyDbManagerSession.insert(ContattiManager.getContactList(new File(ContattiManager.rubricaDir)));
				break;
			case "8":
				System.out.println("arrivederci");
				f = false;
				break;
			}
		} while (f == true);

	}

}
