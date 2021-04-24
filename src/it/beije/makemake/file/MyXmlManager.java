package it.beije.makemake.file;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import it.beije.makemake.rubrica.ContattiManager;
import it.beije.makemake.rubrica.Contatto;

public class MyXmlManager {
	public final static String xmlPath = "C:\\Users\\Padawan09\\git\\Makemake\\src\\it\\beije\\makemake\\file\\fileXml\\rubrica.xml";
	public final static String Path= "C:\\Users\\Padawan09\\git\\Makemake\\src\\it\\beije\\makemake\\file\\fileXml\\rubrica.xml";
	public static void printFile(File f) throws Exception {
		
		FileReader fileReader = new FileReader(f);
		while (fileReader.ready()) {
			System.out.print((char) fileReader.read());
		}
		fileReader.close();
	}

	public static List<Contatto> retrieveContactList(File f) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(f);

		Element rubrica = document.getDocumentElement();
		NodeList contatti = rubrica.getElementsByTagName("contatto");

		List<Contatto> contactList = new ArrayList<Contatto>();
		Element contatto;
		for (int i = 0; i < contatti.getLength(); i++) {
			contatto = (Element) contatti.item(i);
			Element nome = (Element) contatto.getElementsByTagName("nome").item(0);
			Element cognome = (Element) contatto.getElementsByTagName("cognome").item(0);
			Element telefono = (Element) contatto.getElementsByTagName("telefono").item(0);
			Element email = (Element) contatto.getElementsByTagName("email").item(0);
			Contatto contact = new Contatto(nome.getTextContent(), cognome.getTextContent(), telefono.getTextContent(),
					email == null ? null : email.getTextContent());
			contact.setEta(Integer.valueOf(contatto.getAttribute("eta")));
			contactList.add(contact);
		}
		return contactList;
	}

	public static void writeXmlFile(List<Contatto> contactList) throws Exception {
		
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        
        Element root = document.createElement("contatti");
        
//        Element contatto = document.createElement("contatto");
//        contatto.setAttribute("eta", Integer.toString(22));
//        Element nome = document.createElement("nome");
//        nome.setTextContent("Pippo");
//        Element cognome = document.createElement("cognome");
//        cognome.setTextContent("Pluto");
//        Element telefono = document.createElement("telefono");
//        telefono.setTextContent("0201567823");
//
//        contatto.appendChild(nome);
//        contatto.appendChild(cognome);
//        contatto.appendChild(telefono);
//        
//        root.appendChild(contatto);
        for(Contatto contact : contactList) {
        	  Element contatto = document.createElement("contatto");
              contatto.setAttribute("eta", Integer.toString(contact.getEta()));
              Element nome = document.createElement("nome");
              nome.setTextContent(contact.getNome());
              Element cognome = document.createElement("cognome");
              cognome.setTextContent(contact.getCognome());
              Element telefono = document.createElement("telefono");
              telefono.setTextContent(contact.getTelefono());
              Element email = document.createElement("email");
              telefono.setTextContent(contact.getEmail());
             
              
              contatto.appendChild(nome);
              contatto.appendChild(cognome);
              contatto.appendChild(telefono);
              contatto.appendChild(email);
              root.appendChild(contatto);
        	
        }
        document.appendChild(root);
		
        
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		
		StreamResult result = new StreamResult(new File(Path));

		// Output to console for testing
		StreamResult syso = new StreamResult(System.out);

		transformer.transform(source, result);
		transformer.transform(source, syso);

		System.out.println("File saved!");
		
		
	}

	
	public static void main(String[] args) throws Exception {
		File f = new File(xmlPath);
		if (f.exists()) {
			printFile(f);//questo metodo riassume lerighe sotto
//			FileReader fileReader = new FileReader(f);
//			while (fileReader.ready()) {
//				System.out.print((char) fileReader.read());
//			}
//			fileReader.close();

			System.out.println("\n-------------------\n\n");
			
			ContattiManager.printContactList(retrieveContactList(f));
			
		}
	}
}