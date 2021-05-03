package it.beije.makemake.addressbook;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import it.beije.makemake.database.HDBConnection;
import it.beije.makemake.database.JPAConnection;
import it.beije.makemake.rubrica.Contatto;

public class AddressBookCRUD {
	
	private Session session = HDBConnection.getConnection();
	private EntityManager entityM = JPAConnection.getConnection();
	private Transaction transaction;
	private EntityTransaction entityTransaction = entityM.getTransaction();
	private Criteria cr = session.createCriteria(Contatto.class);
	private Contatto contatto = new Contatto();
	private List<Contatto> contatti = new ArrayList<Contatto>();
	
	public List<Contatto> getContactList(){
		contatti = cr.list();
		session.close();
		return contatti;
	}
	
	public void listaContatti(){
		String select = "SELECT c FROM Contatto as c";
		Query query = entityM.createQuery(select);
		contatti = query.getResultList();
		for(Contatto c : contatti) {
			System.out.println(c.toString());
		}
		entityM.close();
	}
	
	public void addContact(Contatto c) {
		transaction = session.beginTransaction();
		session.save(c);
		transaction.commit();
		session.close();
	}
	
	public void aggiungiContatto(Contatto con) {
		entityTransaction.begin();
		entityM.persist(con);
		entityTransaction.commit();
		entityM.close();
	}
	
	public int getContact(String nome, String cognome) {
		int id = 0;
		Criterion name = Restrictions.like("nome", nome);
		Criterion surname = Restrictions.like("cognome", cognome);
		LogicalExpression andExp = Restrictions.and(name, surname);
		cr.add(andExp);
		contatti = cr.list();
		for(Contatto c : contatti) {
			id = c.getId();
		}
		return id;
	}
	
	public void updateContact(int id, String update, String change) {
		transaction = session.beginTransaction();
		cr.add(Restrictions.idEq(id));
		contatti = cr.list();
		for(Contatto c : contatti) {
			if(update.equals("cognome"))
				c.setCognome(change);
			else if(update.equals("nome"))
				c.setNome(change);
			else if(update.equals("telefono"))
				c.setTelefono(change);
			else if(update.equals("email"))
				c.setEmail(change);
			session.save(c);
		}
		transaction.commit();
		session.close();
	}
	
	public void modificaContatto(int id, String update, String newData) {
		contatto = entityM.find(Contatto.class, id);
		if(update.equals("cognome"))
			contatto.setCognome(newData);
		else if(update.equals("nome"))
			contatto.setNome(newData);
		else if(update.equals("telefono"))
			contatto.setTelefono(newData);
		else if(update.equals("email"))
			contatto.setEmail(newData);
		entityTransaction.begin();
		entityM.persist(contatto);
		entityTransaction.commit();
		entityM.close();
	}
	
	public void deleteContact(String nome, String cognome) {
		transaction = session.beginTransaction();
		Criterion name = Restrictions.ilike("nome", nome);
		Criterion surname = Restrictions.ilike("cognome", cognome);
		LogicalExpression andExp = Restrictions.and(name, surname);
		cr.add(andExp);
		contatti = cr.list();
		
		for(Contatto c : contatti) {
			contatto = c;
		}
		session.remove(contatto);
		transaction.commit();
		session.close();
		
	}
	public void eliminaContatto(int id) {
		contatto = entityM.find(Contatto.class, id);
		entityTransaction.begin();
		entityM.remove(contatto);
		entityTransaction.commit();
		entityM.close();
	}

}
