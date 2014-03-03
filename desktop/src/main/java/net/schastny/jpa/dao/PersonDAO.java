package net.schastny.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import net.schastny.jpa.domain.Person;

public class PersonDAO {
    private EntityManagerFactory entityManagerFactory;

    public PersonDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("company_unit");
    }
    
    public void store(Person person) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try {
            tx.begin();
            manager.merge(person);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        } finally {
            manager.close();
        }
    }

    public void delete(Long personId) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        try {
            tx.begin();
            Person person = manager.find(Person.class, personId);
            manager.remove(person);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        } finally {
            manager.close();
        }
    }

    public Person findById(Long personId) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        try {
            return manager.find(Person.class, personId);
        } finally {
            manager.close();
        }
    }

    public List<Person> findAll() {
        EntityManager manager = entityManagerFactory.createEntityManager();
        try {
            Query query = manager.createQuery("select person from Person person");
            @SuppressWarnings("unchecked")
            List<Person> items = query.getResultList();
            for (Person item : items) {
                item.getProjects().size();
            }
            
            return items;

        } finally {
            manager.close();
        }
    }
    
}