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
	
	public static List<Contatto> leggiXmlInArray(File f) throws Exception {
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
			
			
			Contatto cont = new Contatto(null, null, null, null);
			if(cognome!=null)
				cont.setCognome(cognome.getTextContent());
			if(telefono!=null)
				cont.setTelefono(telefono.getTextContent());
			if(nome!=null)
				cont.setNome(nome.getTextContent());
			if(email!=null)
				cont.setEmail(email.getTextContent());
			
				
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

