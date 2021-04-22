package it.beije.makemake.file.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import it.beije.makemake.file.rubrica.Contatto;




public class ManagreXML{

	public static void main(String arg[]) throws Exception {
		//fornisce le API per ottender un DOM Document a partire da un file XML
		//una volta ottenuta l'istanza posso parsare il file XMl da diverse fonti
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//mi fornisce un parser
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		//creo un istanza del file xml da cui voglio leggere
		File file = new File("C:/Users/Padawan11/Desktop/rubrica.xml");
		ArrayList<Contatto> rubrica = null;
		//mi estrapola tutti i tag del file e li mette nella classe document
		Document document = builder.parse(file);
		
		//mi restituisce il root element che è unico ossia il primo tag
		Element root = document.getDocumentElement();


	
		rubrica = retriveContacts(root);
		System.out.println(rubrica);
		
	}
	
	/**
	 * Metodo che va a rimuovermi i childNodes di un element
	 * che rappresentano degli a capoa
	 * @param el
	 */
	public static void getChildElements(Element el) throws Exception {
		//mi fornisce la lista dei ChildNodes se non ce ne sono ottengo una lista vuota
		NodeList nodeList = el.getChildNodes();
		//attenzione ogni volta che in un file xml c'è un  a capo 
		//il parse mi considera il a capo come un childNode
		//root.getChildNodes();
		//mentre getElement sembrerebbe più comodo in realtà mi da proplemi
		//se ho tag dello stesso tipo anndidati in quanto andrà a considerami anche quelli
		//e non solo quelli di primo livello ossia fa una ricerca in profondità e non in ampiezza.
		//root.getElementsByTagName("nomeDelTag");
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
	
	public static ArrayList<Contatto> retriveContacts(Element e) throws Exception{
		Element contatto = null;
		NodeList contatti = e.getElementsByTagName("contatto");
		ArrayList<Contatto> rubrica = new ArrayList<>();
		
		for(int i = 0; i <contatti.getLength(); i++) {
			contatto = (Element)contatti.item(i);
			Element no =(Element) contatto.getElementsByTagName("nome").item(0);
			Element cog =(Element) contatto.getElementsByTagName("cognome").item(0);
			Element tel =(Element) contatto.getElementsByTagName("telefono").item(0);
			Element email = (Element) contatto.getElementsByTagName("email").item(0);
			String nome = no.getTextContent();
			String cognome = cog.getTextContent();
			String telef = tel.getTextContent();
			String mail = email != null  ? email.getTextContent() : "";
			rubrica.add(new Contatto(nome, cognome, telef, mail));
		}
		
		return rubrica;
		
	}
}
