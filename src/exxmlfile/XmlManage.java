package exxmlfile;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import it.beije.makemake.rubrica.Contatto;

public class XmlManage {
	public static void main(String[] args) throws Exception {
		
		List<Contatto> contattilist = new ArrayList<Contatto>();
		File f = new File("C:\\Users\\Padawan13\\Desktop\\rubrica.xml");
		
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
		
		appendInRubrica(contattilist, contatti);
		for(Contatto single : contattilist) {
			System.out.println(single);
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

