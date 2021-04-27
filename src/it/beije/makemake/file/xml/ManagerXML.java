package it.beije.makemake.file.xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import it.beije.makemake.file.rubrica.Contatto;

public class ManagerXML{

	/**
	  	Metodo che va a rimuovermi i childNodes di un element
	  	che rappresentano degli a capo
	 	attenzione ogni volta che in un file xml c'è un  a capo 
		il parse mi considera il a capo come un childNode
		root.getChildNodes();
		mentre getElement sembrerebbe più comodo in realtà mi da proplemi
		se ho tag dello stesso tipo anndidati in quanto andrà a considerami anche quelli
		e non solo quelli di primo livello ossia fa una ricerca in profondità e non in ampiezza.
		root.getElementsByTagName("nomeDelTag");
	**/ 
	
	public static void getChildElements(Element el) throws Exception {
		//mi fornisce la lista dei ChildNodes se non ce ne sono ottengo una lista vuota
		NodeList nodeList = el.getChildNodes();

		for(int i = 0; i < nodeList.getLength(); i++) {
			//figli di un tag che possono essere degli \n oppure degli element.
			Node node = nodeList.item(i);
			if(node instanceof Element) {
				System.out.println("elemento "+ ((Element)node).getTagName());
			}else {
				System.out.println("No element");
			}
		}
	}
	
	public static Document openFileToRead(String path) throws IOException, IllegalArgumentException, ParserConfigurationException, org.xml.sax.SAXException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		File file = new File(path);
		
		Document document = builder.parse(file);
	
		return document;
		
	}
	
	public static void openFileToWrite(String path, Document newDocument) {	
		try {
			StreamResult result = new StreamResult(new File(path));
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			
			DOMSource source = new DOMSource(newDocument);
			
			transformer.transform(source, result);
			System.out.println("File saved!");
		}catch(Exception e) {
			e.getStackTrace();
		}
		
	}

	public static ArrayList<Contatto> retriveContactTags(Document doc) {
		//estraggo il root tag
		Element rubrica = doc.getDocumentElement();
		//estraggo tag figli di tipo contatto del tag rubrica
		NodeList contactListTag = rubrica.getElementsByTagName("contatto");
		//creo una lista in cui salvare tutti i contatti estratti
		ArrayList<Contatto> contactList = new ArrayList<>();
		Element contactNode = null;
		
		
		for(int i=0 ; i<contactListTag.getLength(); i++) {
			contactNode = (Element) contactListTag.item(i);
			
			Element tagName = (Element) contactNode.getElementsByTagName("nome").item(0);
			Element tagSurname = (Element) contactNode.getElementsByTagName("cognome").item(0);
			Element tagTelef = (Element) contactNode.getElementsByTagName("telefono").item(0);
			Element tagEmail = (Element) contactNode.getElementsByTagName("email").item(0);
			
			contactList.add(new Contatto( tagName.getTextContent(),
										  tagSurname.getTextContent(),
										  tagTelef.getTextContent(),
										  tagEmail.getTextContent()
										)
							);
		}
		return contactList;
	}

	public static void printXmlDocument(ArrayList<Contatto> contactList) {
		for(Contatto cont : contactList) {
			System.out.println(cont);
		}
	}
	
	public static Element createDocumentElement(Contatto cont, Document document) {
		Element contatto = document.createElement("contatto");
		
		Element nome = document.createElement("nome");
		Element cognome = document.createElement("cognome");
		Element telefono = document.createElement("telefono");
		Element email = document.createElement("email");
		
		nome.setTextContent(cont.getNome());
		cognome.setTextContent(cont.getCognome());
		telefono.setTextContent(cont.getTelefono());
		email.setTextContent(cont.getEmail());
		
		contatto.appendChild(nome);
		contatto.appendChild(cognome);
		contatto.appendChild(telefono);
		contatto.appendChild(email);
		
		return contatto;
	}
	
	public static Document createDocument(ArrayList<Contatto> contactList) throws ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.newDocument();
		
		Element rootTag = document.createElement("rubrica");
		
		for(Contatto cont : contactList) {;
			Element contatto = createDocumentElement(cont, document);
			rootTag.appendChild(contatto);
		}
		
		document.appendChild(rootTag);
		
		return document;
	}
	
	public static void addContact(String path, Contatto cont){
		//non uso il fileWriter o Reader ma mi creo un oggetto document
		try {
			
			Document document = openFileToRead(path);
			Document newDocument;
			
			ArrayList<Contatto> contactList = retriveContactTags(document);
			
			contactList.add(cont);
			
			newDocument = createDocument(contactList);
			openFileToWrite(path, newDocument);
		
		}catch(Exception e) {
			e.getStackTrace();
		}
			
		
	}
}
