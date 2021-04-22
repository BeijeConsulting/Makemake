package it.beije.makemake.esercizi.file;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import it.beije.makemake.rubrica.Contatto;

public class WriteXml {
	
	public static void createXml(ArrayList<Contatto> contatti) throws Exception {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
	
        Element root = document.createElement("contatti");
        
       for (int i=0; i<contatti.size(); i++) {
    	   
    	   Element contatto = document.createElement("contatto");
           
           Element nome = document.createElement("nome");
           nome.setTextContent(contatti.get(i).getNome());
           Element cognome = document.createElement("cognome");
           cognome.setTextContent(contatti.get(i).getCognome());
           Element telefono = document.createElement("telefono");
           telefono.setTextContent(contatti.get(i).getTelefono());
    	   
           contatto.appendChild(nome);
           contatto.appendChild(cognome);
           contatto.appendChild(telefono);
           
           root.appendChild(contatto);
       }
       
       document.appendChild(root);
    // write the content into xml file
    	TransformerFactory transformerFactory = TransformerFactory.newInstance();
    	Transformer transformer = transformerFactory.newTransformer();
    	DOMSource source = new DOMSource(document);
    		
    	StreamResult result = new StreamResult(new File("C:\\Users\\Padawan04\\git\\Makemake\\newRubrica.xml"));

    	// Output to console for testing
    	StreamResult video = new StreamResult(System.out);

    	transformer.transform(source, result);
    	transformer.transform(source, video);

    	System.out.println("File saved!");
	}
	
	
	public static void main (String [] args) throws Exception {
		File f = new File("C:\\Users\\Padawan04\\git\\Makemake\\rubrica.xml");
		ArrayList<Contatto> contatti = XmlManager.load(f);
		createXml(contatti);
		
	}
}
