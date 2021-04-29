package it.beije.makemake.esercizi.file;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


import it.beije.makemake.rubrica.ContattoAnnotation;

public class XmlManager {

	public static  ArrayList<ContattoAnnotation> load(File file) throws Exception{
		
		FileReader fileReader = new FileReader(file);
		while (fileReader.ready()) {
			System.out.print((char)fileReader.read());
		}
		fileReader.close();

		System.out.println("\n-------------------\n\n");
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
		
        Document document = builder.parse(file);
        Element rubrica = document.getDocumentElement();
        NodeList contatti = rubrica.getElementsByTagName("contatto");
        
        Element contatto = null;
        ArrayList<ContattoAnnotation> contact = new ArrayList<>();
        Element nome = null;
        Element cognome = null;
        Element telefono = null;
        //Element email = null;
        
		for (int i = 0; i < contatti.getLength(); i++) {
			contatto = (Element) contatti.item(i);
			//System.out.println("getChildNodes : " + contatto.getChildNodes().getLength());
			ContattoAnnotation c = new ContattoAnnotation();
			
			nome = (Element) contatto.getElementsByTagName("nome").item(0);
			cognome = (Element) contatto.getElementsByTagName("cognome").item(0);
			telefono = (Element) contatto.getElementsByTagName("telefono").item(0);
			//email =(Element) contatto.getElementsByTagName("email");
			
			c.setNome(nome.getTextContent());
			c.setCognome(cognome.getTextContent());
			c.setTelefono(telefono.getTextContent());
			//c.setEmail(email.getTextContent());
			contact.add(c);			
		}
		
	return contact;
	}
	
	public static void main (String [] args) throws Exception {
		File f = new File("C:\\Users\\Padawan04\\git\\Makemake\\rubrica.xml");
		System.out.println(load(f).toString());
		
	}
	
}
