package com.apps.test.repository;


import com.apps.test.model.Person;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class PersonRepository extends SimpleJpaRepository<Person, String> {
    private final EntityManager em;
    public PersonRepository(EntityManager em) {
        super(Person.class, em);
        this.em = em;
    }
    @Override
    public List<Person> findAll() {
        return em.createNativeQuery("Select * from \"testing\".\"Person\"", Person.class).getResultList();
    }
}