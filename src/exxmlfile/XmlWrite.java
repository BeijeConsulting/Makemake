package exxmlfile;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

import it.beije.makemake.rubrica.Contatto;

public class XmlWrite {
public static void main(String[] args) throws Exception {

		File f = new File("C:\\Users\\Padawan13\\Desktop\\rubrica.xml");
		List<Contatto> contattilist = new ArrayList<Contatto>();
		
		System.out.println("file exists ? " + f.exists());
		
		System.out.println("\n-------------------\n\n");
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
		
        // Load the input XML document, parse it and return an instance of the Document class.
        Document document = builder.parse(f);
        
        Element rubrica = document.getDocumentElement();
		System.out.println("getChildNodes : " + rubrica.getChildNodes().getLength());
		NodeList contatti = rubrica.getElementsByTagName("contatto");
		System.out.println("getElementsByTagName : " + contatti.getLength());
		
		//Stampa l'arraylist creato dai contatti di Rubrica
		appendInRubrica(contattilist, contatti);
		for(Contatto single : contattilist) {
			System.out.println(single);

		//Scrivere una file XML
			
	DocumentBuilderFactory factorynew = DocumentBuilderFactory.newInstance();
	DocumentBuilder buildernew = factorynew.newDocumentBuilder();
	Document document1 = buildernew.newDocument();

	Element root = document1.createElement("contatti");

	for(Contatto cont: contattilist) {
	
		Element contatto = document1.createElement("contatto");
		Element nome = document1.createElement("nome");
		nome.setTextContent(cont.getNome());
		Element cognome = document1.createElement("cognome");
		cognome.setTextContent(cont.getCognome());
		Element telefono = document1.createElement("telefono");
		telefono.setTextContent(cont.getTelefono());
		Element email = document1.createElement("email");
		email.setTextContent(cont.getEmail());

		contatto.appendChild(nome);
		contatto.appendChild(cognome);
		contatto.appendChild(telefono);
		contatto.appendChild(email);

		root.appendChild(contatto);

	
	}
		document1.appendChild(root);

	// write the content into xml file
	TransformerFactory transformerFactory = TransformerFactory.newInstance();
	Transformer transformer = transformerFactory.newTransformer();
	DOMSource source = new DOMSource(document1);

	StreamResult result = new StreamResult(new File("C:\\Users\\Padawan13\\Desktop\\new_rubrica.xml"));

	// Output to console for testing
	StreamResult syso = new StreamResult(System.out);

	transformer.transform(source, result);
	transformer.transform(source, syso);

	System.out.println("File saved!");
	}
}
		
		
		
		
		
		
		
		
		public static void appendInRubrica(List<Contatto> contattilist, NodeList contatti) throws Exception {
			for (int i = 0; i < contatti.getLength(); i++) {
					Element contatto = (Element) contatti.item(i);
					
					Element nome = (Element) contatto.getElementsByTagName("nome").item(0);
					Element cognome = (Element) contatto.getElementsByTagName("cognome").item(0);
					Element telefono = (Element) contatto.getElementsByTagName("telefono").item(0);
					Element email = (Element) contatto.getElementsByTagName("email").item(0);
					
					Contatto x = new Contatto();
					x.setNome(nome.getTextContent());
					x.setCognome(cognome.getTextContent());
					x.setTelefono(telefono.getTextContent());
					if(email != null)
					x.setEmail(email.getTextContent());
					
					contattilist.add(x);
				}
		}
}
