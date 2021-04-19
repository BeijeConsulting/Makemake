package it.beije.makemake.addressBook;

public class Contact implements Comparable<Contact> {

    private String name;
    private String surname;
    private String phone;
    private String mail;
    private String address;

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

    private Contact(String name, String surname, String phone, String mail, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.mail = mail;
        this.address = address;
    }

    private Contact(String name, String surname, String phone, String mail) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.mail = mail;
        this.address = "";
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
        return format(" ");
    }


    @Override
    public int compareTo(Contact o) {
        if (this.name.compareTo(o.name) != 0)
            return this.name.compareTo(o.name);
        else
            return this.surname.compareTo(o.surname);
    }
}
