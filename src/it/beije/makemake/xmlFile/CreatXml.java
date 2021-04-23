package it.beije.makemake.xmlFile;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreatXml {
	public void creatXml() throws ParserConfigurationException, TransformerException{
		DocumentBuilderFactory factory;
		DocumentBuilder builder ;
		Document document;
		
	 factory = DocumentBuilderFactory.newInstance();
    builder = factory.newDocumentBuilder();
    document = builder.newDocument();
    
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
	
	StreamResult result = new StreamResult(new File("C:\\Users\\Padawan01\\git\\Makemake\\contatto.xml"));

	// Output to console for testing
	StreamResult syso = new StreamResult(System.out);

	transformer.transform(source, result);
	transformer.transform(source, syso);

	System.out.println("File saved!");
	}

}
