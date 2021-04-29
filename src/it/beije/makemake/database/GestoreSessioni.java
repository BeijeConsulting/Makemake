package it.beije.makemake.database;


import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



	public class GestoreSessioni {
		
		private GestoreSessioni() {}
		
		private static Session session; 
		
		public static Session getSessione()  {
			
			if (session == null ||  !(session.isOpen())) {
				SessionFactory sessionFactory = (new Configuration().configure()).buildSessionFactory();
				session = sessionFactory.openSession();
			}
			
			return session;
		}
		
	}

