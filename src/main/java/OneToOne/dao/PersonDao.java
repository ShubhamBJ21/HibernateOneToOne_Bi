package OneToOne.dao;

import java.util.List;
import OneToOne.dto.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class PersonDao {

    public EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory("shubham").createEntityManager();
    }

    public void savePerson(Person person) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();
        entityManager.persist(person);
        entityTransaction.commit();
        System.out.println("Person details added successfully");
    }

    public void updatePerson(int id, Person person) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        Person receivedPerson = entityManager.find(Person.class, id);

        if (receivedPerson != null) {
            entityTransaction.begin();

            person.setId(id);
            entityManager.merge(person);

            entityTransaction.commit();
            System.out.println("Person data updated successfully");
        } else {
            System.out.println("Person doesn't exist");
        }
    }

    public void deletePerson(int id) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        Person person = entityManager.find(Person.class, id);

        if (person != null) {
            entityTransaction.begin();
            entityManager.remove(person);
            entityTransaction.commit();
            System.out.println("Person details deleted successfully");
        } else {
            System.out.println("Person doesn't exist");
        }
    }

    public void getPersonDetails(int id) {
        EntityManager entityManager = getEntityManager();
        Person person = entityManager.find(Person.class, id);
        if (person != null) {
            System.out.println(person);
        } else {
            System.out.println("Person not found with id: " + id);
        }
    }

    public List<Person> getAllPersons() {
        EntityManager entityManager = getEntityManager();

        Query query = entityManager.createQuery("SELECT p FROM Person p");

        List<Person> list = query.getResultList();
        return list;
    }
}
