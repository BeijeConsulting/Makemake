package it.beije.makemake.addressBook;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddressBook {

    private List<Contact> contactList = new ArrayList<>();
    private Contact header;

    public List<Contact> getContactList() {
        return contactList;
    }


    public static AddressBook createFromCSV(String path, String delim, boolean useQuotes) throws Exception {
        AddressBook addressBook = new AddressBook();
        FileReader fileReader = null;
        fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        addressBook.header = Contact.parseContact(bufferedReader.readLine(), delim, useQuotes);
        while (bufferedReader.ready()) {
            String row = bufferedReader.readLine();
            Contact c = Contact.parseContact(row, delim, useQuotes);
            addressBook.contactList.add(c);
        }
        fileReader.close();
        return addressBook;
    }

    public static AddressBook createFromXML(String path) throws ParserConfigurationException, FileNotFoundException, SAXException, IOException {

        AddressBook result = new AddressBook();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();

        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException("Il file specificato non esiste!");
        }
        Document document = documentBuilder.parse(file);
        Element addressBook = document.getDocumentElement();
        NodeList contacts = addressBook.getElementsByTagName("contatto");

        for (int i = 0; i < contacts.getLength(); i++) {
            Element contact = (Element)contacts.item(i);

            Element name = (Element)contact.getElementsByTagName("nome").item(0);
            Element surname = (Element)contact.getElementsByTagName("cognome").item(0);
            Element phone = (Element)contact.getElementsByTagName("telefono").item(0);
            Element mail = (Element)contact.getElementsByTagName("mail").item(0);

            Contact c1;
            if (mail != null) {
                c1 = new Contact(name.getTextContent(),
                        surname.getTextContent(),
                        phone.getTextContent(),
                        mail.getTextContent());
            } else {
                c1 = new Contact(name.getTextContent(),
                        surname.getTextContent(),
                        phone.getTextContent());
            }

            result.contactList.add(c1);

        }

        return result;

    }

    public void toXMLFile(String destPath) throws Exception {
        FileWriter fileWriter = new FileWriter(destPath);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();

        Element root = document.createElement("contatti");
        for (Contact contact :
                contactList) {
            Element contactElement = contact.getXMLElement(document);
            root.appendChild(contactElement);
        }
        document.appendChild(root);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);

        StreamResult result = new StreamResult(new File(destPath));

        transformer.transform(domSource, result);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Contact contact :
                contactList) {
            sb.append(contact.toString());
        }
        return sb.toString();
    }

    public String format(String delim) {
        StringBuilder result = new StringBuilder();
        result.append(header.format(delim));
        for (Contact contact :
                contactList) {
            result.append(contact.format(delim));
        }
        return result.toString();
    }

    public void toFile(String destPath, String delim) throws IOException {
        File file = new File(destPath);
        FileWriter fileWriter = new FileWriter(file);
        String content = format(delim);
        fileWriter.write(content);
        fileWriter.close();
    }

    public AddressBook addContact(Contact contact) {
        contactList.add(contact);
        return this;
    }

    public AddressBook addContact(String contactString, String delim, boolean useQuotes) {
        Contact c = Contact.parseContact(contactString, delim, useQuotes);
        addContact(c);
        return this;
    }

    public AddressBook addContact(String[] fields) {
        Contact c = new Contact(fields);
        addContact(c);
        return this;
    }

    public AddressBook merge(AddressBook addressBook) {
        for (Contact c :
                addressBook.contactList) {
            this.addContact(c);
        }
        return this;
    }

    public AddressBook merge(String filePath, String delim, boolean useQuotes) throws Exception {
        AddressBook newBook = AddressBook.createFromCSV(filePath, delim, useQuotes);
        return this.merge(newBook);
    }

    public AddressBook sort() {
        Collections.sort(contactList);
        return this;
    }

    public List<Contact> search(Contact contact) {
        List<Contact> result = new ArrayList<>();
        sort();
        int i = Collections.binarySearch(contactList, contact);
        if (i < 0)
            return result;
        int k = i;
        while(k >= 0 && contactList.get(k).compareTo(contact)==0)
            result.add(contactList.get(k--));
        k = i+1;
        while(k < contactList.size() && contactList.get(k).compareTo(contact)==0)
            result.add(contactList.get(k++));
        return result;
    }

    public List<Contact> search(String name) {
        Contact c = new Contact(name);
        return search(c);
    }

    public boolean remove(Contact c) {
        return contactList.remove(c);
    }








}
