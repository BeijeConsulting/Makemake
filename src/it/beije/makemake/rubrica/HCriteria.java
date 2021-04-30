package it.beije.makemake.rubrica;

import java.util.List;
import java.util.Scanner;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import it.beije.makemake.database.SessionManager;

public class HCriteria {

	public static void main(String[] args) throws Exception {

		Session session = SessionManager.getSession();
		// criteria.add(Restrictions.eq("nome", "carlo maria"));
		// criteria.add(Restrictions.gt("id", 12)); //greater than = GT

		Scanner s = new Scanner(System.in);
		boolean flag = true;

		CICLO: do {
			stampaMenu();
			switch (s.nextLine().trim()) {
			case "1": // Aggiungi
				addContact(GestisciRubrica.leggiContatto(s), session);
				continue;
			case "2": // Rimuovi
				deleteContact(new Contatto("ciao", "ciao", "ciao", "ciao"),session);
				flag = false;
				continue;
			case "3":// mostra tutti i contatti
				selectAll(session);
				continue;
			case "4":
				modifyContact(session,GestisciRubrica.leggiContatto(s),s);
			default:
				break CICLO;
			}
		} while (flag);
		System.out.println("fine");

		SessionManager.close(session);

	}

	public static String modifyContact(Session session,Contatto c,Scanner s) throws Exception {
		if(selectContact(c, session) == null)
			return"Il contatto inserito non è nella rubrica";
		else {
			List<Contatto> contatti = selectAll(session);
			try {
			System.out.println(contatti);
			System.out.println("Quale campo vuoi modificare: \n"
					+ "1: NOME\n2: COGNOME\n3: EMAIL\n4: TELEFONO\n");
			String str = s.nextLine();			
			System.out.println("Inserire nuovo valore: ");
			String valore = s.nextLine();
			for (Contatto c1 : contatti) {
				if(c1.equals(c)) {
					Transaction transaction = session.beginTransaction();
					switch (str) {
					case "1":
						c.setNome(valore);
						break;
					case "2":
						c.setCognome(valore);
						break;
					case "3":
						c.setEmail(valore);
						break;
					case "4":
						c.setTelefono(valore);
						break;
					default:
						throw new NumberFormatException();}
					session.save(c1);
					transaction.commit();
					System.out.println("COntatto aggiornato");
				}
				
			}
			}catch (NumberFormatException e) {
				System.out.println("Errore: inserire numero da 1 a 4");
			}
			return null;
		}
		
			
	}

	// mostra tutti i contatti
	public static List<Contatto> selectAll(Session session) throws Exception {

		Criteria criteria = session.createCriteria(Contatto.class);

		List<Contatto> contatti = criteria.list();

		return contatti;

	}
	
	public static List<Contatto> selectContact(Contatto c, Session session) throws Exception {
		
		Criteria criteria = session.createCriteria(Contatto.class);
		criteria.add(Restrictions.eq("nome", c.getNome())).add(Restrictions.eq("cognome", c.getCognome()))
				.add(Restrictions.eq("email", c.getEmail())).add(Restrictions.eq("telefono", c.getTelefono()));
		List<Contatto> contatti = criteria.list();
//		
//		for(Contatto c1 : contatti)
//			System.out.println(c1);
		if(contatti.size()==0)
			return null;
		return contatti;

	}
	public static void stampaMenu() {
		System.out.println("\nCosa vuoi fare? " + "\n 1) Aggiungere contatto" + "\n 2) Rimuovere contatto"
				+ "\n 3) Leggi rubrica" + "\n 4) Modifica contatto\n"+ " 7) unisci db a csv\n");

	}
	public static void deleteContact(Contatto c, Session session) throws Exception {
		
		List<Contatto> contatti = selectAll(session);
		for (Contatto c1 : contatti) {
			if(c1.equals(c)) {
				Transaction transaction = session.beginTransaction();
				session.delete(c1);
				transaction.commit();
				System.out.println("COntatto eliminato");
			}
			
		}
}

	public static void addContact(Contatto c, Session session) throws Exception {
		Transaction transaction = session.beginTransaction();
		session.save(c);
		transaction.commit();
		System.out.println("Contatto inserito");

	}
}
