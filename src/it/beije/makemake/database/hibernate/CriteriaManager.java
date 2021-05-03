package it.beije.makemake.database.hibernate;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import it.beije.makemake.file.rubrica.Contatto;

public class CriteriaManager {

	private static final HDBSingleton newSingleton = HDBSingleton.getHDBSingleton();
	public static void main(String arg[]) {
		select();
	}
	@SuppressWarnings("deprecation")
	public static void select(){
		Session session = newSingleton.getSession();
		
	
		
		System.out.println("This is a simple use of a criteria");
		Criteria criteria = session.createCriteria(Contatto.class);
		System.out.println(criteria.list());
		
		
		System.out.println("This criteria is more complex it has a where condition for id = 3");
		criteria = session.createCriteria(Contatto.class).add(Restrictions.eq("id", 3));
		System.out.println(criteria.list());
		
		
		System.out.println("This criteria uses agregation function");
		criteria = session.createCriteria(Contatto.class).setProjection(Projections.rowCount());
		System.err.println("--------------"+criteria.list().get(0)+"---------------");
		
		//Examples of Restrictions
		//returns the row with id>1 Restriction.lt() fa il contrario
		//criteria.add(Restrictions.gt("id", 1));
		//return row with name like that
		//criteria.add(Restrictions.like("name","A%o_y"));
		//if you want to concat more restriction togheter use criterion
		Criterion cond1 = Restrictions.gt("id", 1);
		Criterion cond2 = Restrictions.like("nome", "banana");
		LogicalExpression andExp = Restrictions.and(cond1, cond2);
		criteria = session.createCriteria(Contatto.class);
		criteria.add(andExp);
		//in order to get the result
		System.out.println(criteria.list());
		
		//Example of Projections
		//they are used to get aggregation functon result 
		criteria = session.createCriteria(Contatto.class);
		criteria.setProjection(Projections.rowCount());
		System.out.println(criteria.list());
		
		session.close();
	}

}
