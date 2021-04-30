package it.beije.makemake.db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import it.beije.makemake.rubrica.ContattoRubrica;

public class SessionManager { //gestione sessioni

	    private SessionManager() {
	       Configuration configuration = new Configuration().configure()
	                .addAnnotatedClass(ContattoRubrica.class);
	        SessionManager.sessionFactory = configuration.buildSessionFactory();
	    }

	    private static SessionManager instance;
	    private static SessionFactory sessionFactory;
	    private static List<Session> sessionList = new ArrayList<>();

	    public static SessionManager getSessionManager() {
	        if (instance == null) {
	            instance = new SessionManager();
	        }

	        return instance;
	    }

	    public static Session getSession() throws TooManySessionsException{
	        Session session;
	        for (Session s : sessionList) {
	            if (!s.isOpen()) {
	                s.close();
	                sessionList.remove(s);
	            }
	        }
	        if (sessionList.size() == 150) {
	            throw new SessionException("Max number of concurrent sessions reached");
	        } else {
	            session = sessionFactory.openSession();
	            sessionList.add(session);
	            
	        }
	        System.out.println(sessionList.size());
	        return session;
	      
	    }

	    public  static void closeSession(Session session) {
	        session.close();
	        sessionList.remove(session);
	    }

	}
