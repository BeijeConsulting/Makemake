package it.beije.makemake.databaseex;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

import it.beije.makemake.rubrica.Contatto;

public class Criteria {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Contatto.class);

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = null;
//		cr.addOrder(Order.asc("salary"));
//		cr.add(Restrictions.gt("salary", 2000));

		session.beginTransaction();
		org.hibernate.Criteria criteria = session.createCriteria(Contatto.class).addOrder(org.hibernate.criterion.Order.asc("nome"));//.addOrder(org.hibernate.criterion.Order.asc("nome"));
		List<Contatto> contatti = criteria.list();
		System.out.println();
		Contatto contatto = null;
		criteria.add(Restrictions.ge("yasmin", "nome"));
		
		for (Contatto c : contatti) {
			System.out.println("id "+c.getId());
			System.out.println("nome "+c.getNome());
			System.out.println("cognome "+c.getCognome());
			System.out.println("email "+c.getEmail());
			System.out.println("-------------------------------");
			


			contatto = c;
		}
		
		
//		get contatto
		
		//System.out.println(criteria.add(Restrictions.gt("nome", "yasmin")));
		
		
		

	}

}
