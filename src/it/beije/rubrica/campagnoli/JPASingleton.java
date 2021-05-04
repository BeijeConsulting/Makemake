package it.beije.rubrica.campagnoli;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPASingleton {
		private static JPASingleton instance;
		private static  EntityManagerFactory factory;
		
		private JPASingleton() {
			
		}
		public static JPASingleton getInstance() {
			if(instance == null) {
				instance = new JPASingleton();
				JPASingleton.factory = Persistence.createEntityManagerFactory("Makemake");
			}
			
			return instance;
		}
		
		public static EntityManager getEntityManager() {
			return factory.createEntityManager();
		}
	}
