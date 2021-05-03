package ComunicazioneConJPA;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.beije.makemake.rubrica.Contatto;
public class JPAesempio{


		public static void main(String[] args) {
			
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("Makemake");
			
			EntityManager entityManager = factory.createEntityManager();
			
			Contatto c = entityManager.find(Contatto.class, 26);
			System.out.println(c);
			
			//Query JPQL
			String jpqlSelect = "SELECT c FROM Contatto as c";
			Query query = entityManager.createQuery(jpqlSelect);
			List<Contatto> contatti = query.getResultList();

			for (Contatto contatto : contatti) {
				System.out.println("id : " + contatto.getId());
				System.out.println("name : " + contatto.getNome());
				System.out.println("surname : " + contatto.getCognome());
				System.out.println("telephone : " + contatto.getTelefono());
				System.out.println("email : " + contatto.getEmail());
			}
			
			
			//Transaction
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			
			//INSERT
			Contatto newContatto = new Contatto();
			newContatto.setCognome("Viscomi");
			newContatto.setNome("Filippo");
			newContatto.setEmail("f.viscomi@beije.it");
			System.out.println("contatto PRE : " + newContatto);
			entityManager.persist(newContatto);
			System.out.println("contatto POST : " + newContatto);
			
//			//UPDATE
			c.setCognome("Zippo");
			c.setTelefono("43214342");
			entityManager.persist(c);
			
//			//DELETE
			entityManager.remove(c);
			
			entityTransaction.commit();
			entityTransaction.rollback();
			
			entityManager.close();

		}

	}



