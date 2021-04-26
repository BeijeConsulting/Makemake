package it.beije.makemake.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlManager {
	
//	public static void getChildElements(Element element) {
//      NodeList nodeList = element.getChildNodes();
//      System.out.println("nodeList " + nodeList.getLength());
//      for (int i = 0; i < nodeList.getLength(); i++) {
//      	Node node = nodeList.item(i);
//      	if (node instanceof Element) {
//      		System.out.println("elemento " + ((Element)node).getTagName());
//      	} else {
//      		System.out.println("NO Element");
//      	}
//      }
//	}
	
	public static NodeList listaContatti(File file) throws Exception{
		if(file.exists()) {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();
	        Document document = builder.parse(file);
	        Element rubrica = document.getDocumentElement();
	        NodeList contatti = rubrica.getElementsByTagName("contatto");
	        
	        Element contatto = null;
			for (int i = 0; i < contatti.getLength(); i++) {
				contatto = (Element) contatti.item(i);
				//System.out.println("getChildNodes : " + contatto.getChildNodes().getLength());
				
				Element nome = (Element) contatto.getElementsByTagName("nome").item(0);
				Element cognome = (Element) contatto.getElementsByTagName("cognome").item(0);
				//Element email = (Element) contatto.getElementsByTagName("email").item(0);
				
				System.out.println("nome : " + nome.getTextContent());
				System.out.println("cognome : " + cognome.getTextContent());
				//System.out.println("email : " + email.getTextContent());
			}
			return contatti;
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		
		File f = new File("C:/Users/Padawan03/git/makemake/rubrica.xml");
		NodeList contactList = listaContatti(f);
		for(int i=0; i<contactList.getLength(); i++) {
			System.out.println(contactList.item(i));
		}
//		System.out.println("file exists ? " + f.exists());
//		FileReader fileReader = new FileReader(f);
//		while (fileReader.ready()) {
//			System.out.print((char)fileReader.read());
//		}
//		fileReader.close();
//
//		System.out.println("\n-------------------\n\n");
//		
//		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder = factory.newDocumentBuilder();
//		
//        // Load the input XML document, parse it and return an instance of the Document class.
//        //Document document = builder.parse("/temp/rubrica.xml");
//        Document document = builder.parse(f);
//        
//        Element rubrica = document.getDocumentElement();
//		System.out.println("getChildNodes : " + rubrica.getChildNodes().getLength());
//		NodeList contatti = rubrica.getElementsByTagName("contatto");
//		System.out.println("getElementsByTagName : " + contatti.getLength());
//		//getChildElements(rubrica);
//		
//		Element contatto = null;
//		for (int i = 0; i < contatti.getLength(); i++) {
//			contatto = (Element) contatti.item(i);
//			//System.out.println("getChildNodes : " + contatto.getChildNodes().getLength());
//			
//			Element nome = (Element) contatto.getElementsByTagName("nome").item(0);
//			Element cognome = (Element) contatto.getElementsByTagName("cognome").item(0);
//			Element telefono = (Element) contatto.getElementsByTagName("telefono").item(0);
//			
//			System.out.println("eta : " + contatto.getAttribute("eta"));
//			System.out.println("nome : " + nome.getTextContent());
//			System.out.println("cognome : " + cognome.getTextContent());
//			System.out.println("telefono : " + telefono.getTextContent());
//		}
		
	}

}
