package rubrica;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class JPAManager {

	private static JPASingleton instance;
	private static Scanner tastiera = new Scanner(System.in);

	public static void select() {
		String jplSelect = "SELECT c FROM Contatto as c";
		Query query = instance.getEntityManager().createQuery(jplSelect);
		List<Contatto> contatti = query.getResultList();
		contatti.toString();
	}

	
	public static Contatto cercaContatto(int id) {
		Contatto c = instance.getEntityManager().find(Contatto.class, id);
		return c;
	}
	
	public static void insert(Contatto newContatto) {
		EntityTransaction transaction = instance.getEntityManager().getTransaction();
		transaction.begin();
		instance.getEntityManager().persist(newContatto);
		transaction.commit();
	}
	
	public static void update(int id) {
		String nome, cognome,telefono,email;
		System.out.println("Nuovo nome: ");
		nome= tastiera.nextLine();
		System.out.println("Nuovo cognome: ");
		cognome= tastiera.nextLine();
		System.out.println("Nuovo telefono: ");
		telefono= tastiera.nextLine();
		System.out.println("Nuovo email: ");
		email= tastiera.nextLine();
		
		String jplUpdate = "UPDATE Contatto SET nome ='"+nome+"',cognome ='"+cognome+"',telefono='"+telefono+"',email ='"+email+"' WHERE id='"+id+"'";
		Query query = instance.getEntityManager().createQuery(jplUpdate);
		
	}
	
	
	
	
	public static void main(String[] args) {
		instance = JPASingleton.getInstance();		
	}

}
