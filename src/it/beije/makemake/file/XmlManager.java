package it.beije.makemake.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import it.beije.makemake.rubrica.Contatto;

public class XmlManager extends CsvManager {
	
	public static void main(String[] args)  throws Exception {
		
		File f = new File("C:\\Users\\Padawan07\\Desktop\\rubrica\\rubrica.xml");
		System.out.println("file exists ? " + f.exists());

		System.out.print("\n-------------------\n");
		
		//Tutti i contatti in un array
		List<Contatto> listacontatti = leggiXmlInArray(f);
		scriviInXml(listacontatti, "C:\\Users\\Padawan07\\Desktop\\rubrica\\rubrica1.xml");
		
		
	}
	public static List leggiXmlInArray(File f) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
		
        // Load the input XML document, parse it and return an instance of the Document class.
        //Document document = builder.parse("/temp/rubrica.xml");
        Document document = builder.parse(f);
        
        Element rubrica = document.getDocumentElement();
		NodeList contatti = rubrica.getElementsByTagName("contatto");
		
		Element contatto = null;
		List<Contatto> listacontatti = new ArrayList<Contatto>();
		
		for (int i = 0; i < contatti.getLength(); i++) {
			contatto = (Element) contatti.item(i);
			
			Element nome = (Element) contatto.getElementsByTagName("nome").item(0);
			Element cognome = (Element) contatto.getElementsByTagName("cognome").item(0);
			Element telefono = (Element) contatto.getElementsByTagName("telefono").item(0);
			Element email = (Element) contatto.getElementsByTagName("email").item(0);
			
			String cognome1 = cognome.getTextContent();
			String nome1 = nome.getTextContent();
			String email1 = email.getTextContent();
			String telefono1 = cognome.getTextContent();
			Contatto cont = new Contatto(nome1, cognome1, telefono1, email1);	
			listacontatti.add(cont);
			//System.out.println(cont.toString());
			
		}
		return listacontatti;
		
	}

	public static void scriviInXml(List<Contatto> lista, String percorso) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element root = document.createElement("rubrica");
        
        for (int i = 0; i < lista.size(); i++) {
            Element contatto = document.createElement("contatto");
            Element nome = document.createElement("nome");
            nome.setTextContent(lista.get(i).getNome());
            Element cognome = document.createElement("cognome");
            cognome.setTextContent(lista.get(i).getCognome());
            Element telefono = document.createElement("telefono");
            telefono.setTextContent(lista.get(i).getTelefono());

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
		
		StreamResult result = new StreamResult(new File(percorso));
		transformer.transform(source, result);

		System.out.println("File saved!");
	}
}

