package file;

import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args)
			throws IOException, ParserConfigurationException, SAXException, TransformerException {

		// XmlManager xml=new XmlManager();
		// xml.readFile("C:\\Users\\Padawan01\\git\\Makemake\\rubrica.xml");

	     CreatXml creatxml = new CreatXml();

		Scanner input = new Scanner(System.in);

        String name;                                
        String lastName;                                     
        String phoneNumber; 
		try {
			System.out.print("Enter a your name: ");
			name = input.nextLine();
			creatxml.setNome(name);

			System.out.print("Enter a your last name: ");
			lastName = input.nextLine();
			creatxml.setCognome(lastName);
			
			System.out.print("Enter a your phone number: ");
			phoneNumber = input.nextLine();
			creatxml.setCognome(phoneNumber);
			creatxml.creatXml();

			//System.out.println("\n----------- User Info ------------");
			//System.out.println("Name: " + name);
			//System.out.println("Job: " + job);
			//System.out.println("Age: " + age);
		} catch (Exception e) { 
			System.out.print(e.toString());
		} finally {
			input.close();
		}

	}

}
