package HDBEx;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import it.beije.makemake.rubrica.Contatto;

public class DbManagement {

	@SuppressWarnings("deprecation")
	static Configuration configuration = new Configuration().configure()
			.addAnnotatedClass(Contatto.class);
	static SessionFactory sessionFactory = configuration.buildSessionFactory();
	static Scanner x = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception{
		
		boolean exit_pool = true;
	
		CICLO: while(exit_pool) {		
			System.out.println("Benvenuto!: ");

			System.out.println("Scegli un'opzione dal nostro menù "
			+ "o digita 'exit' per uscire");
			System.out.println("-----------Menù----------");
			System.out.println("Digita '1' per stampare il DB su PC");
			System.out.println("Digita '2' per aggiungere al DB una lista di "
			+ "nuovi contatti");
			System.out.println("Digita '3' per scaricare il contenuto di un DB"
			+ " in un file csv sul PC");
			System.out.println("Digita '4' per scaricare il contenuto di un DB"
			+ " in un file xml sul PC");
			System.out.println("Digita '5' per rimuovere un contatto dal DB");
			System.out.println("Digita '6' per stampare il totale dei contatti");
			System.out.println("Digita '7' per cercare un contatto");
			System.out.println("Digita 'exit' per uscire                   ");
		
		switch(x.nextLine()) {
		
		case "1":
			//stampo il contenuto dell'intero DB
			DbManagement.listallDB();
			break;
		case "2":
			//aggiungo a DB una lista di nuovi contatti
			DbManagement.wrtlistonDB(null);
			break;
		case "3":
			//salvo contenuto del db in csv
			DbManagement.fromDBtoCsv();
			break;
		case "4":
			//salvo contenuto del db in xml
			DbManagement.fromDBtoXml();
			break;
		case "5":
			break;
		case "6":
			//conto e stampo il n di contatti
			DbManagement.countContact();
			break;
		case "7":
			//Ricerca di contatto in rubrica
			DbManagement.findContact();
			break;
			
			
		
		}
		}
	}
	
	private static void fromDBtoXml( ) throws IOException, ParserConfigurationException, TransformerException {
		
		DocumentBuilderFactory factorynew = DocumentBuilderFactory.newInstance();
		DocumentBuilder buildernew = factorynew.newDocumentBuilder();
		Document document1 = buildernew.newDocument();

		Element root = document1.createElement("contatti");
		
		   Session session = sessionFactory.openSession();
		   Transaction tx = null;	   
		   
		   try {
		      tx = session.beginTransaction();
		      Criteria cr = session.createCriteria(Contatto.class);
		      List<Contatto> contatti = cr.list();
		      System.out.println("Scrivi il path del file che vuoi salvare");
		      FileWriter writer = new FileWriter(x.nextLine(), true);
		      
		      for(Contatto cont : contatti) {
		  		Element contatto1 = document1.createElement("contatto");
				Element nome = document1.createElement("nome");
				nome.setTextContent(cont.getNome());
				Element cognome = document1.createElement("cognome");
				cognome.setTextContent(cont.getCognome());
				Element telefono = document1.createElement("telefono");
				telefono.setTextContent(cont.getTelefono());
				Element email = document1.createElement("email");
				email.setTextContent(cont.getEmail());

				contatto1.appendChild(nome);
				contatto1.appendChild(cognome);
				contatto1.appendChild(telefono);
				contatto1.appendChild(email);

				root.appendChild(contatto1);
		      }
		      
		      document1.appendChild(root);

		  	// write the content into xml file
		  	TransformerFactory transformerFactory = TransformerFactory.newInstance();
		  	Transformer transformer = transformerFactory.newTransformer();
		  	DOMSource source = new DOMSource(document1);
		  	System.out.println("Inserisci il nome col path del file xml da creare: ");
		  	StreamResult result = new StreamResult(new File(x.nextLine()));

		  	// Output to console for testing
		  	StreamResult syso = new StreamResult(System.out);

		  	transformer.transform(source, result);
		  	transformer.transform(source, syso);

		  	System.out.println("File saved!");
		  	
		   }catch (HibernateException e) {
		      if (tx!=null) tx.rollback();
		      e.printStackTrace(); 
		   } finally {
		      session.close(); 
		   }
		} 	
		
	private static void fromDBtoCsv( ) throws IOException {
		   Session session = sessionFactory.openSession();
		   Transaction tx = null;
		   Contatto contatto = null;	   
		   
		   try {
		      tx = session.beginTransaction();
		      Criteria cr = session.createCriteria(Contatto.class);
		      List<Contatto> contatti = cr.list();
		      System.out.println("Scrivi il path del file che vuoi salvare");
		      FileWriter writer = new FileWriter(x.nextLine());
		      
		      for(int i=0; i<contatti.size(); i++) {
		    	contatto = (Contatto) contatti.get(i);	    	
		  		writer.write(contatto.getCognome());
		  		writer.write(';');
		  		writer.write(contatto.getNome());
		  		writer.write(';');
		  		writer.write(contatto.getTelefono());
		  		writer.write(';');
		  		writer.write(contatto.getEmail());
		  		writer.write('\n');

		  		writer.flush();
		  		writer.close();
		      }
		   } catch (HibernateException e) {
		      if (tx!=null) tx.rollback();
		      e.printStackTrace(); 
		   } finally {
		      session.close(); 
		   }
		} 	
	
	private static void listallDB( ) {
		   Session session = sessionFactory.openSession();
		   Transaction tx = null;
		   Contatto contatto = null;	   
		   
		   try {
		      tx = session.beginTransaction();
		      Criteria cr = session.createCriteria(Contatto.class);
		      List<Contatto> contatti = cr.list();
		      
		      for(int i=0; i<contatti.size(); i++) {
		    	  contatto = (Contatto) contatti.get(i);
		    	  System.out.print("Name: " + contatto.getNome()); 
		          System.out.print("Surname: " + contatto.getCognome()); 
		          System.out.print("Tel: " + contatto.getTelefono());
		          System.out.println("email: " + contatto.getEmail()); 
		      }		      
		   } catch (HibernateException e) {
		      if (tx!=null) tx.rollback();
		      e.printStackTrace(); 
		   } finally {
		      session.close(); 
		   }
		} 	

	private static Integer wrtlistonDB(List<Contatto> contatti) {
			Session session = sessionFactory.openSession();
			
		    Transaction tx = null;
		    Integer animalID = null;
		    
		    try {
		       tx = session.beginTransaction();
		       for (Contatto contatto : contatti) {
		       contatto.getId();
		       contatto.getNome();
		       contatto.getCognome();
		       contatto.getTelefono();
		       contatto.getEmail();
		       animalID = (Integer) session.save(contatto);
		       tx.commit();
		       }
		    } catch (HibernateException e) {
		       if (tx!=null) tx.rollback();
		       e.printStackTrace(); 
		    } finally {
		       session.close(); 
		    }
		    return animalID;
		 }
	
	private static void removefDB() {
		
		 Session session = sessionFactory.openSession();
		 Transaction tx = null;
		 Contatto contatto = null;
		 
		 try {
		      tx = session.beginTransaction();
		      Criteria cr = session.createCriteria(Contatto.class);
		      List<Contatto> contatti = cr.list();
		      System.out.println("Inserisci il Cognome e Nome del contatto da"
		      		+ " eliminare dal DB");
		      String cognome = x.nextLine();
		      String nome = x.nextLine();
		      String name = cognome+nome;
		      
		      for(int i=0; i<contatti.size(); i++) {
		    	  contatto = (Contatto) contatti.get(i);
		    	  String namecp = contatto.getCognome()+contatto.getNome();
		    	  if(namecp.equals(name)) {
		    		  contatti.remove(i);
		    	  }
		      }		      
		   } catch (HibernateException e) {
		      if (tx!=null) tx.rollback();
		      e.printStackTrace(); 
		   } finally {
		      session.close(); 
		   }
		
	}

	private static void countContact(){
	   Session session = sessionFactory.openSession();
	   Transaction tx = null;
	   
	   try {
	      tx = session.beginTransaction();
	      Criteria cr = session.createCriteria(Contatto.class);

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

	private static void findContact() {
		
		Session session = sessionFactory.openSession();
		   Transaction tx = null;
		   Contatto contatto = null;
		   
		   try {
		      tx = session.beginTransaction();
		      Criteria cr = session.createCriteria(Contatto.class);

		      // To get total row count.
		      cr.setProjection(Projections.rowCount());
		      List<Contatto> contatti = cr.list();

		      System.out.println("Inserisci Cognome: ");
		      String gn = x.nextLine();
		      System.out.println("Inserisci Nome: ");
		      String nm = x.nextLine();
		      boolean flag = false;
		      
		      for(int i=0;i<contatti.size();i++) {
		    	  contatto = (Contatto) contatti.get(i);
		    	  if((contatto.getCognome()+contatto.getNome()).equals(gn+nm)) {
		    		  System.out.println("Contatto: "+contatto.getCognome()+
		    				  " "+contatto.getNome());
		    		  System.out.println("Telefono: "+contatto.getTelefono());
		    		  System.out.println("Email: "+contatto.getEmail());
		    		  flag = true;
		    	  }    	  
		      }
		      if (flag==false) System.out.println("Contatto non presente in rubrica!");
		      tx.commit();
		   } catch (HibernateException e) {
		      if (tx!=null) tx.rollback();
		      e.printStackTrace(); 
		   } finally {
		      session.close(); 
		   }
		
	}
}