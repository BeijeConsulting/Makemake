package HDBEx;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import javassist.bytecode.Descriptor.Iterator;

public class CriteriaProva {
@SuppressWarnings("deprecation")


	static Configuration configuration = new Configuration().configure()
			.addAnnotatedClass(Animal.class);
	
	static SessionFactory sessionFactory = configuration.buildSessionFactory();


public static void main(String[] args) {
	
	String name = "pipistrello";
	String age="5";
	String diet="erbivoro"; 
	String habitat="bosco";
	Integer anId = addAnimal(19, name, age, diet, habitat);
	
	CriteriaProva.countAnimal();
	
	CriteriaProva.listAnimals();
	

}



/* Method to CREATE an animal in the database */
private static Integer addAnimal(int id, String name, String age, String diet, String habitat){
	Session session = sessionFactory.openSession();
	
    Transaction tx = null;
    Integer animalID = null;
    
    try {
       tx = session.beginTransaction();
       Animal animal = new Animal();
       animal.setId(id);
       animal.setNome(name);
       animal.setDiet(diet);
       animal.setHabitat(habitat);
       //Criteria cr = session.createCriteria(Animal.class);
       animalID = (Integer) session.save(animal);
       //List<Animal> animals = cr.list();
       //animals.add(animal);
       tx.commit();
    } catch (HibernateException e) {
       if (tx!=null) tx.rollback();
       e.printStackTrace(); 
    } finally {
       session.close(); 
    }
    return animalID;
 }


/* Method to print total number of records */
private static void countAnimal(){
   Session session = sessionFactory.openSession();
   Transaction tx = null;
   
   try {
      tx = session.beginTransaction();
      Criteria cr = session.createCriteria(Animal.class);

      // To get total row count.
      cr.setProjection(Projections.rowCount());
      List rowCount = cr.list();

      System.out.println("Total Coint: " + rowCount.get(0) );
      tx.commit();
   } catch (HibernateException e) {
      if (tx!=null) tx.rollback();
      e.printStackTrace(); 
   } finally {
      session.close(); 
   }
}


/* Method to  READ all the animals */
private static void listAnimals( ) {
   Session session = sessionFactory.openSession();
   Transaction tx = null;
   Animal animal = null;
   
   try {
      tx = session.beginTransaction();
      Criteria cr = session.createCriteria(Animal.class);
      List<Animal> animals = cr.list();
      
      for(int i=0; i<animals.size(); i++) {
    	  animal = (Animal) animals.get(i);
    	  System.out.print("Name: " + animal.getNome()); 
          System.out.print("Age: " + animal.getAge()); 
          System.out.print("Diet: " + animal.getDiet());
          System.out.println("Habitat: " + animal.getHabitat());      
      }
   } catch (HibernateException e) {
      if (tx!=null) tx.rollback();
      e.printStackTrace(); 
   } finally {
      session.close(); 
   }
} 

}

/* Method to  LOOK4 all the animals 
private static void look4Animals(String namecol, String name) {
   Session session = sessionFactory.openSession();
   Transaction tx = null;
   Animal animal = null;
   
   try {
      tx = session.beginTransaction();
      Criteria cr = session.createCriteria(Animal.class);
      // Add restriction.
      cr.add(Restrictions.eq(namecol, name));
      List animals = cr.list();
      
      for(int i=0; i<animals.size(); i++) {
    	  animal = (Animal) animals.get(i);
    	  System.out.print("Name: " + animal.getNome()); 
          System.out.print("Age: " + animal.getAge()); 
          System.out.println("Habitat: " + animal.getHabitat()); 
      }
   } catch (HibernateException e) {
      if (tx!=null) tx.rollback();
      e.printStackTrace(); 
   } finally {
      session.close(); 
   }
} 

}
*/