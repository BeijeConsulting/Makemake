package it.beije.makemake.file.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;




public class ManagreXML{

	public static void main(String arg[]) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		//si occupa di interpretare tutti i tag nel file e li riporta nel documento
		File file = new File("C:/Users/Padawan11/Desktop/file.xml");
		Document document = builder.parse(file);
		
		//mi restituisce il root element che è unico ossia il primo tag
		Element root = document.getDocumentElement();

		//attenzione ogni volta che in un file xml c'è un  a capo 
		//il parse mi considera il a capo come un childNode
		root.getChildNodes();
		
		//mentre getElement sembrerebbe più comodo in realtà mi da proplemi
		//se ho tag dello stesso tipo anndidati in quanto andrà a considerami anche quelli
		//e non solo quelli di primo livello ossia fa una ricerca in profondità e non in ampiezza.
		root.getElementsByTagName("nomeDelTag");
		
		
	}
	
	/**
	 * Metodo che va a rimuovermi i childNodes di un element
	 * che rappresentano degli a capoa
	 * @param el
	 */
	public static void getChildElements(Element el) throws Exception {
		NodeList nodeList = el.getChildNodes();
		
		for(int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if(node instanceof Element) {
				System.out.println("elemento "+ (Element) node.getTagName());
			}else {
				
			}
		}
	}
}
