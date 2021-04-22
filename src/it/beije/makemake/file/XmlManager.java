package it.beije.makemake.file;

import java.io.File;
import java.io.FileReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlManager {

	public static void getChildElements(Element element) {
		NodeList nodeList = element.getChildNodes();
		System.out.println("nodeList " + nodeList.getLength());
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node instanceof Element) {
				System.out.println("elemento " + ((Element) node).getTagName());
			} else {
				System.out.println("NO Element");
			}
		}
	}

	public static void readXml() throws Exception {
		
		File f = new File("C:/temp/rubrica.xml");
		System.out.println("file exists ? " + f.exists());
		FileReader fileReader = new FileReader(f);
		while (fileReader.ready()) {
			System.out.print((char) fileReader.read());
		}
		fileReader.close();

		System.out.println("\n-------------------\n\n");

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		// Load the input XML document, parse it and return an instance of the Document
		// class.
		// Document document = builder.parse("/temp/rubrica.xml");
		Document document = builder.parse(f);

		Element rubrica = document.getDocumentElement();
		System.out.println("getChildNodes : " + rubrica.getChildNodes().getLength());
		NodeList contatti = rubrica.getElementsByTagName("contatto");
		System.out.println("getElementsByTagName : " + contatti.getLength());
		// getChildElements(rubrica);

		Element contatto = null;
		for (int i = 0; i < contatti.getLength(); i++) {
			contatto = (Element) contatti.item(i);
			// System.out.println("getChildNodes : " +
			// contatto.getChildNodes().getLength());

			Element nome = (Element) contatto.getElementsByTagName("nome").item(0);
			Element cognome = (Element) contatto.getElementsByTagName("cognome").item(0);
			Element telefono = (Element) contatto.getElementsByTagName("telefono").item(0);

			System.out.println("eta : " + contatto.getAttribute("eta"));
			System.out.println("nome : " + nome.getTextContent());
			System.out.println("cognome : " + cognome.getTextContent());
			System.out.println("telefono : " + telefono.getTextContent());
		}

	}

	public static void main(String[] args) throws Exception {
		
		//PROVOCAZIONE!!!
//		FileWriter fileWriter = new FileWriter("/temp/new_rubrica.xml");
//		fileWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
//		fileWriter.write("<rubrica><contatto eta=\"35\"><nome>Carlo</nome></contatto></rubrica>");
//		fileWriter.flush();
//		fileWriter.close();
		
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        
        Element root = document.createElement("contatti");
        
        Element contatto = document.createElement("contatto");
        contatto.setAttribute("eta", Integer.toString(22));
        Element nome = document.createElement("nome");
        nome.setTextContent("Pippo");
        Element cognome = document.createElement("cognome");
        cognome.setTextContent("Pluto");
        Element telefono = document.createElement("telefono");
        telefono.setTextContent("0201567823");

        contatto.appendChild(nome);
        contatto.appendChild(cognome);
        contatto.appendChild(telefono);
        
        root.appendChild(contatto);
        
        document.appendChild(root);
		
        
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		
		StreamResult result = new StreamResult(new File("/temp/new_rubrica.xml"));

		// Output to console for testing
		StreamResult syso = new StreamResult(System.out);

		transformer.transform(source, result);
		transformer.transform(source, syso);

		System.out.println("File saved!");
	}

}
