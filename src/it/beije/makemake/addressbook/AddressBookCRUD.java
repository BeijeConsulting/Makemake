package it.beije.makemake.addressbook;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import it.beije.makemake.database.HDBConnection;
import it.beije.makemake.rubrica.Contatto;

public class AddressBookCRUD {
	
	private Session session = HDBConnection.getConnection();
	private Transaction transaction;
	private Criteria cr = session.createCriteria(Contatto.class);
	private Contatto contatto = new Contatto();
	private List<Contatto> contatti = new ArrayList<Contatto>();
	
	public List<Contatto> getContactList(){
		contatti = cr.list();
		session.close();
		return contatti;
	}
	
	public void addContact(Contatto c) {
		transaction = session.beginTransaction();
		session.save(c);
		transaction.commit();
		session.close();
	}
	
	public void deleteContact(String nome, String cognome) {
		
		Criterion name = Restrictions.like(contatto.getNome(), nome);
		Criterion surname = Restrictions.like(contatto.getCognome(), cognome);
		LogicalExpression andExp = Restrictions.and(name, surname);
		cr.add(andExp);
		contatti = cr.list();
		
		for(Contatto c : contatti) {
			session.remove(c);
		}
		session.close();
		
	}

}
