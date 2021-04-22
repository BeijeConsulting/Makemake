package it.andrea.esercitazione.xml;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import it.andrea.esercitazione.contatti.ContattiManager;
import it.beije.makemake.rubrica.Contatto;

public class MyXmlManager {
	public final static String xmlPath = "C:/Users/Padawan10/git/Makemake/src/it/andrea/esercitazione/xml/xmlfiles/rubrica.xml";

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
			contactList.add(new Contatto(nome.getTextContent(), cognome.getTextContent(), telefono.getTextContent(),
					email == null ? null : email.getTextContent()));
		}
		return contactList;
	}

	public static void main(String[] args) throws Exception {
		File f = new File(xmlPath);
		if (f.exists()) {
			printFile(f);
			System.out.println("\n-------------------\n\n");
			
			ContattiManager.printContactList(retrieveContactList(f));
		}
	}
}
