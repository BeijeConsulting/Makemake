package it.beije.makemake.myDatabase;

import it.beije.makemake.addressBook.Contact;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sun.dc.path.PathError;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JPAManager {

    private JPAManager() {
        entityManagerFactory = Persistence.createEntityManagerFactory("Makemake");
    }

    private static JPAManager instance;
    private EntityManagerFactory entityManagerFactory;
    private List<EntityManager> entityManagerList = new ArrayList<>();

    public static JPAManager getJPAManager() {
        if (instance == null) {
            instance = new JPAManager();
        }

        return instance;
    }

    public EntityManager getEntityManager() {
        EntityManager entityManager;
        for (EntityManager e : entityManagerList) {
            if (!e.isOpen()) {
                e.close();
                entityManagerList.remove(e);
            }
        }
        if (entityManagerList.size() == 150) {
            throw new EntityNotFoundException("Max number of concurrent sessions reached");
        } else {
            entityManager = entityManagerFactory.createEntityManager();
            entityManagerList.add(entityManager);
        }
        return entityManager;
    }

    public void closeEntityManager(EntityManager entityManager) {
        entityManager.close();
        entityManagerList.remove(entityManager);
    }

}
