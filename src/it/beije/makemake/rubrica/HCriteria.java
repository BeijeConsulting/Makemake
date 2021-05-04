package it.beije.makemake.rubrica;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import it.beije.makemake.database.EntityManagerMan;
import it.beije.makemake.database.SessionManager;
import it.beije.makemake.file.CsvManager;
import it.beije.makemake.file.XmlManager;

public class HCriteria {

	public static void main(String[] args) throws Exception {
		//EntityManager e = EntityManagerMan.getEntity();
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
				deleteContact(GestisciRubrica.leggiContatto(s),session);
				continue;
			case "3":// mostra tutti i contatti
				selectAll(session);// criteria
				//selectAllJPA(e); // JPA
				continue;
			case "4":
				modifyContact(session,GestisciRubrica.leggiContatto(s),s);
			default:
				break CICLO;
			case "5":
				CsvManager.scriviListaInCsv(selectAll(session),ottieniPercorso(s,0));
				continue;
			case "6":
				XmlManager.scriviInXml(selectAll(session),ottieniPercorso(s,1));
				continue;
			case "7":
				List<Contatto> cont= XmlManager.leggiXmlInArray(new File(ottieniPercorso(s,1)));
				for(Contatto c: cont) {
					addContact(c, session);
				}
				continue;
			case "8":
				List<Contatto> cont1= CsvManager.leggiCsv(ottieniPercorso(s, 0));
				for(Contatto c: cont1) {
					addContact(c, session);
				}
				continue;
			}
		} while (flag);
		System.out.println("fine");

		SessionManager.close(session);
		//EntityManagerMan.close(e);

	}
	public static String ottieniPercorso(Scanner s,int i) {
		String percorso;
		if(i == 0) {
			 percorso = "C:/Users/Padawan07/Desktop/rubrica/rubrica.txt";}
		else {
			 percorso = "C:/Users/Padawan07/Desktop/rubrica/rubrica1.xml";}

		System.out.println("vuoi creare nuovo file? S/N o qualsiasi");
		
		if(s.nextLine().equals("S")) {
			System.out.println("inserisci nome nuovo file");
			percorso = "C:/Users/Padawan07/Desktop/rubrica/"+s.nextLine();
		}
		return percorso;
		
	}
	
	public static String modifyContact(Session session,Contatto c,Scanner s) throws Exception {
		if(selectContact(c, session) == null)
			return"IL CONTATTO INSERITO NON E' IN RUBRICA";
		else {
			List<Contatto> contatti = selectAll(session);
			try {
			System.out.println(contatti);
			System.out.println("QUALE CAMPO VUOI MODIFICARE?: \n"
					+ "1: NOME\n2: COGNOME\n3: EMAIL\n4: TELEFONO\n");
			String str = s.nextLine();			
			System.out.println("Inserire nuovo valore: ");
			String valore = s.nextLine();
			for (Contatto c1 : contatti) {
				if(c1.equals(c)) {
					Transaction transaction = session.beginTransaction();
					switch (str) {
					case "1":
						c1.setNome(valore);
						break;
					case "2":
						c1.setCognome(valore);
						break;
					case "3":
						c1.setEmail(valore);
						break;
					case "4":
						c1.setTelefono(valore);
						break;
					default:
						throw new NumberFormatException();}
					session.save(c1);
					transaction.commit();
					System.out.println("CONTATTO AGGIORNATO");
				}
				
			}
			}catch (NumberFormatException e) {
				System.out.println("ERRORE: inserire numero da 1 a 4");
			}
			return null;
		}
		
			
	}

	public static List<Contatto> selectAll(Session session) throws Exception {

		Criteria criteria = session.createCriteria(Contatto.class);

		List<Contatto> contatti = criteria.list();
		
		for(Contatto c: contatti) {
			System.out.println(c);
		}
		return contatti;

	}
	
	public static List<Contatto> selectAllJPA(EntityManager entityManager) throws Exception {
		
		String jpqlSelect = "SELECT c FROM Contatto as c";
		Query query = entityManager.createQuery(jpqlSelect);
		List<Contatto> contatti = query.getResultList();
		
		for(Contatto c: contatti) {
			System.out.println(c);
		}
		return contatti;

	}
	
	public static List<Contatto> selectContact(Contatto c, Session session) throws Exception {
		
		Criteria criteria = session.createCriteria(Contatto.class);
		criteria.add(Restrictions.eq("nome", c.getNome())).add(Restrictions.eq("cognome", c.getCognome()))
				.add(Restrictions.eq("email", c.getEmail())).add(Restrictions.eq("telefono", c.getTelefono()));
		List<Contatto> contatti = criteria.list();

		if(contatti.size()==0)
			return null;
		
		return contatti;

	}
	public static void stampaMenu() {
		System.out.println("\nCOSA VUOI FARE? " + "\n 1) AGGIUNGERE CONTATTO" + "\n 2) RIMUOVERE CONTATTO"
				+ "\n 3) LEGGERE RUBRICA" + "\n 4) MODIFICA CONTATTO\n"+ " 5) METTI DATABASE IN CSV\n"+ " 6) METTI DATABASE IN XML\n"+ " 7) METTI XML IN DB\n");

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
