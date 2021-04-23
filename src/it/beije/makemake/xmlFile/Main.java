package it.beije.makemake.xmlFile;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, TransformerException {
		
	    //XmlManager xml=new XmlManager();
		//xml.readFile("C:\\Users\\Padawan01\\git\\Makemake\\rubrica.xml");
		
		CreatXml creatxml = new CreatXml();
		creatxml.creatXml();

	}

}
