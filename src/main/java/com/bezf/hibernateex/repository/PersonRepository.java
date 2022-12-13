package com.bezf.hibernateex.repository;

import com.bezf.hibernateex.entities.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        var query = entityManager.createQuery("select p from Person p where p.city_of_living = :city");
        query.setParameter("city_of_living", city);
        return (List<Person>) query.getResultList();
    }
}
