package it.beije.makemake.db;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import it.beije.makemake.rubrica.ContattoRubrica;

public class HDBManager {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		SessionManager.getSessionManager();
	
		
		boolean f = true;		
		
		while (f) {
			System.out.println("vuoi modificare il db? s/n");
			String t = in.nextLine();
			switch (t.toUpperCase()) {
			case "N":
				
				
				System.out.println("arrivederci");
				f = false;
				break;
			default:
				System.out.println("comando non valido");
				break;
			case "S":
				Session s = SessionManager.getSession();
				System.out.println("sessioni aperte: "+s);
				
			Query<ContattoRubrica> query = s.createQuery("SELECT c FROM ContattoRubrica as c");
			List<ContattoRubrica> contatti = query.list();
			
			ContattoRubrica contatto = null;
			for (ContattoRubrica c : contatti) {
				System.out.println(c);
				contatto = c;
			}
			
			
			Transaction transaction = s.beginTransaction();
			

				// INSERT
				ContattoRubrica newContatto = new ContattoRubrica();
				System.out.println(" inserisci cognome");
				String surname=in.nextLine();
				newContatto.setCognome(surname);
				
				System.out.println(" inserisci nome");
				String name=in.nextLine();
				newContatto.setNome(name);
				
				System.out.println(" inserisci mail");
				String mail=in.nextLine();
				newContatto.setEmail(mail);
				
				System.out.println("contatto PRE : " + newContatto);
				s.save(newContatto);
				System.out.println("contatto POST : " + newContatto);
				System.out.println("operazione effettuata");
				transaction.commit();
//				SessionManager.closeSession(s);
				System.out.println("sessioni aperte: "+s);
				break;

			}

		}

	}
}
