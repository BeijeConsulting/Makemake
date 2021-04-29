package it.beije.makemake.database;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import it.beije.makemake.rubrica.Contatto;

public class HDBConnection {
	
	private static Session session;
	private static Configuration config;
	private static List<Session> sessions = new ArrayList<Session>();
	private final static int MAX_SESSIONS = 20;
	
	private HDBConnection() {}
	
	public static Session getConnection() {
		
		if(sessions.size() <= MAX_SESSIONS) {
			config = new Configuration().configure().addAnnotatedClass(Contatto.class);
			SessionFactory sessionFactory = config.buildSessionFactory();
			session = sessionFactory.openSession();
			sessions.add(session);
		}
		else {
			System.out.println("Hai raggiunto il numero massimo di sessioni aperte.");
		}
		return session;
	}
	
	public static boolean isClosed(Session session) {
		
		boolean flag = true;
		if(session.isConnected()) {
			flag = false;
		}
		else {
			sessions.remove(session);
		}
		return flag;
	}
}