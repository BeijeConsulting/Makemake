package it.beije.makemake.rubrica;

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

public class XmlRubrica {

	static List <Contatto> myRubrica=new ArrayList<Contatto>();
	
	public static void main(String[] args) throws Exception {
	
		getRubrica();
		
		for(Contatto c : myRubrica) {
			System.out.println(c.toString());
		}
		writeRubrica(myRubrica);
        
	}
	
	public static void getRubrica() throws Exception{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        File f = new File("C:\\Users\\Padawan02\\Desktop\\temp\\rubrica.xml");
		System.out.println("file exists ? " + f.exists());
        Document document=builder.parse(f);
        
        Element rubrica = document.getDocumentElement();
        NodeList contatti=rubrica.getElementsByTagName("contatto");
        
        Element contatto=null;
        
        for(int i=0;i<contatti.getLength();i++) {
        	contatto= (Element) contatti.item(i);
        	
        	Element nome = (Element) contatto.getElementsByTagName("nome").item(0);
			Element cognome = (Element) contatto.getElementsByTagName("cognome").item(0);
			Element telefono = (Element) contatto.getElementsByTagName("telefono").item(0);
			Element email= (Element) contatto.getElementsByTagName("email").item(0);
        	
			contatto= (Element) contatti.item(i);
			
        	Contatto c= new Contatto();
        	c.setNome(nome.getTextContent());
        	c.setCognome(cognome.getTextContent());
        	c.setTelefono(telefono.getTextContent());
        	if(email==null) { 
        		c.setEmail(null) ;
        	}else {
        		c.setEmail(email.getTextContent());
        	}
        	myRubrica.add(c);        	
        }
	}

	public static void writeRubrica(List<Contatto> myRubrica) throws Exception{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        
        Element root = document.createElement("contatti");
        for(Contatto c : myRubrica) {
        	 Element contatto = document.createElement("contatto");
        	 Element nome = document.createElement("nome");
        	 nome.setTextContent(c.getNome());
        	 Element cognome = document.createElement("cognome");
             cognome.setTextContent(c.getCognome());
             Element telefono = document.createElement("telefono");
             telefono.setTextContent(c.getTelefono());
             Element email = document.createElement("email");
             email.setTextContent(c.getEmail());
             
             contatto.appendChild(nome);
             contatto.appendChild(cognome);
             contatto.appendChild(telefono);
             contatto.appendChild(email);
             root.appendChild(contatto);
             
        }
        
        document.appendChild(root);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File("C:\\Users\\Padawan02\\Desktop\\temp\\new_rubrica.xml"));
		
		//StreamResult syso = new StreamResult(System.out);

		transformer.transform(source, result);
		//transformer.transform(source, syso);

		System.out.println("File saved!");

       
	}
}
