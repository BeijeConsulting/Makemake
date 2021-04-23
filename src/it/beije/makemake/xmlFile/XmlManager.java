package it.beije.makemake.xmlFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlManager {

	File f;
	FileReader fileReader;
	DocumentBuilderFactory factory;
	DocumentBuilder builder;
	NodeList contatti;

	public void readFile(String path) throws IOException, ParserConfigurationException, SAXException {

		f = new File(path);
		System.out.println("file exists ? " + f.exists());
		fileReader = new FileReader(f);
		while (fileReader.ready()) {
			System.out.print((char) fileReader.read());
		}
		fileReader.close();

		System.out.println("\n-------------------\n\n");

		factory = DocumentBuilderFactory.newInstance();
		builder = factory.newDocumentBuilder();

		// Load the input XML document, parse it and return an instance of the Document
		// class.
		// Document document = builder.parse("/temp/rubrica.xml");
		Document document = builder.parse(f);

		Element rubrica = document.getDocumentElement();
		System.out.println("getChildNodes : " + rubrica.getChildNodes().getLength());
		NodeList contatti = rubrica.getElementsByTagName("contatto");
		System.out.println("getElementsByTagName : " + contatti.getLength());
		// getChildElements(rubrica);

	
		}
	
	public void getContacts() {
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

}}
