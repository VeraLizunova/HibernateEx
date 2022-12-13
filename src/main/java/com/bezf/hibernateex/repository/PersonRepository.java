package com.bezf.hibernateex.repository;

import com.bezf.hibernateex.entities.Person;
import com.bezf.hibernateex.entities.PersonalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, PersonalData> {
    List<Person> findByCityOfLiving(String cityOfLiving);

    List<Person> findByPersonalDataAgeLessThanOrderByPersonalDataAgeDesc(int age);

    Optional<Person> findByPersonalDataNameAndPersonalDataSurname(String name, String surname);
}
