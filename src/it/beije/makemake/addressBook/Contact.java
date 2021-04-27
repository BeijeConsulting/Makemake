package it.beije.makemake.addressBook;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.Locale;

public class Contact implements Comparable<Contact> {

    private String name = "";
    private String surname = "";
    private String phone = "";
    private String mail = "";
    private String address = "";

    public Contact(String[] fields) {
        name = fields[0] == null ? "" : fields[0];
        surname = fields[0] == null ? "" : fields[1];
        phone = fields[0] == null ? "" : fields[2];
        mail = fields[0] == null ? "" : fields[3];
        address = fields[0] == null ? "" : fields[4];
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Contact(String name, String surname, String phone, String mail, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.mail = mail;
        this.address = address;
    }

    public Contact(String name, String surname, String phone, String mail) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.mail = mail;
    }

    public Contact(String name) {
        this.name = name;
    }

    public Contact(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Contact(String name, String surname, String phone) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }


    public static Contact parseContact(String contactString, String delim, boolean useQuotes) {
        String[] fields = contactString.split(delim);
        if (useQuotes) {
            for (int i = 0; i < fields.length; i++) {
                fields[i] = removeQuotes(fields[i]);
            }
        }
        String name = fields[0];
        String surname = fields[1];
        String phone = fields[2];
        String mail = fields[3];
        String address = fields.length > 4 ? fields[4] : "";

        return new Contact(name, surname, phone, mail, address);
    }


    private static String removeQuotes(String field) {
        return field.substring(1, field.length()-1);
    }

    public String format(String delim) {
        StringBuilder result = new StringBuilder();
        result.append(name).append(delim)
                .append(surname).append(delim)
                .append(phone).append(delim)
                .append(mail).append(delim)
                .append(address)
                .append("\n");
        return result.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: " + name);
        sb.append(" Surname: " + surname);
        sb.append(" Phone: " + phone);
        sb.append(" Mail: " + mail);
        sb.append(" Address: " + address);
        sb.append("\n");
        return sb.toString();
    }

    @Override
    public int compareTo(Contact o) {
        int r = 0;
        if (!this.name.isEmpty() && !o.name.isEmpty()) {
            r = this.name.toLowerCase(Locale.ROOT).compareTo(o.name.toLowerCase(Locale.ROOT));
            if (r != 0) return r;
        }
        if (!this.surname.isEmpty() && !o.surname.isEmpty()) {
            r = this.surname.toLowerCase(Locale.ROOT).compareTo(o.surname.toLowerCase(Locale.ROOT));
            if (r != 0) return r;
        }
        if (!this.phone.isEmpty() && !o.phone.isEmpty()) {
            r = this.phone.toLowerCase(Locale.ROOT).compareTo(o.phone.toLowerCase(Locale.ROOT));
            if (r != 0) return r;
        }
        if (!this.mail.isEmpty() && !o.mail.isEmpty()) {
            r = this.mail.toLowerCase(Locale.ROOT).compareTo(o.mail.toLowerCase(Locale.ROOT));
            if (r != 0) return r;
        }
        if (!this.address.isEmpty() && !o.address.isEmpty()) {
            r = this.address.toLowerCase(Locale.ROOT).compareTo(o.address.toLowerCase(Locale.ROOT));
            if (r != 0) return r;
        }
        return r;
    }

    public Element getXMLElement(Document document) throws Exception {
        Element contact = document.createElement("contatto");
        Element name = document.createElement("nome");
        Element surname = document.createElement("cognome");
        Element phone = document.createElement("telefono");
        Element mail = document.createElement("mail");
        Element address = document.createElement("indirizzo");
        name.setTextContent(this.name);
        surname.setTextContent(this.surname);
        phone.setTextContent(this.phone);
        mail.setTextContent(this.mail);
        address.setTextContent(this.address);
        contact.appendChild(name);
        contact.appendChild(surname);
        contact.appendChild(phone);
        contact.appendChild(mail);
        contact.appendChild(address);
        return contact;
    }



    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Contact) {
            Contact c = (Contact)obj;
            return this.compareTo(c) == 0;
        }
        return false;
    }
}
