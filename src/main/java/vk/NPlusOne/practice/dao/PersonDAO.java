package vk.NPlusOne.practice.dao;


import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import vk.NPlusOne.practice.models.Person;

import java.util.List;

@Component
public class PersonDAO {

    private final EntityManager entityManager;

    @Autowired
    public PersonDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(readOnly = true)
    public void testNPlusOne(){
        Session session = entityManager.unwrap(Session.class);

        //first request
        List<Person> people = session.createQuery("select p from Person p", Person.class)
                .getResultList();

        //N requests to DB
        for(Person person : people){
            System.out.println("Person " + person.getName() + " has: " + person.getItems());
        }


    }
}
