package it.beije.makemake.addressBook.test;

import it.beije.makemake.addressBook.Contact;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MyJPAExample {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Makemake");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Contact c = entityManager.find(Contact.class, 63);
        System.out.println(c);

        entityManager.close();
    }

}
