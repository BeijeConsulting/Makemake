package it.beije.makemake.esercizi.database;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import it.beije.makemake.rubrica.ContattoAnnotation;


public class HDBManager {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		SessionManager.getSession();
	
		
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
				
			Query<ContattoAnnotation> query = s.createQuery("SELECT c FROM ContattoAnnotation as c");
			List<ContattoAnnotation> contatti = query.list();
			
			ContattoAnnotation contatto = null;
			for (ContattoAnnotation c : contatti) {
				System.out.println(c);
				contatto = c;
			}
			
			
			Transaction transaction = s.beginTransaction();
			
				// INSERT
				ContattoAnnotation newContatto = new ContattoAnnotation();
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
	public static ContattoAnnotation leggiContatto(Scanner in) {
		String Nome ="", Cognome="", Telefono="", Email="";
		boolean flag = false;
		
		while (flag == false) {
			System.out.println("Inserisci nome");
			 Nome = in.nextLine();
			if (!(Nome.isEmpty())) {
				flag = true;
			}
		}
		 flag = false;
		
		while (flag == false) {
			System.out.println("Inserisci cognome");
			Cognome = in.nextLine();
			if (!(Cognome.isEmpty())) {
				flag = true;
			}
		}
		 flag = false;
		while (flag == false) {
			System.out.println("Inserisci telefono");
			Telefono = in.nextLine();
			if (!(Telefono.isEmpty())) {
				flag = true;
			}
		}
		 flag = false;
		while (flag == false) {
			System.out.println("Inserisci email");
			Email = in.nextLine();
			if (!(Email.isEmpty())) {
				flag = true;
			}
		}
		
		ContattoAnnotation contatto = new ContattoAnnotation(Nome, Cognome, Telefono, Email);
		return contatto;
	}


}