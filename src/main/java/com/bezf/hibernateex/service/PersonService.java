package com.bezf.hibernateex.service;

import com.bezf.hibernateex.entities.Person;
import com.bezf.hibernateex.entities.PersonalData;
import com.bezf.hibernateex.expections.PersonNotFoundException;
import com.bezf.hibernateex.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class PersonService {
    private static final String PERSON_WITH_SPECIFIED_ID_NOT_FOUND_MESSAGE = "Person with specified id %s is not found";
    private static final String PERSON_WITH_SPECIFIED_NAME_AND_SURNAME_NOT_FOUND_MESSAGE = "Person with specified " +
            "name %s and surname %s is not found";
    private final PersonRepository personRepository;

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public Optional<Person> findById(PersonalData personalData) throws PersonNotFoundException {
        var personOptional = personRepository.findById(personalData);

        if (personOptional.isPresent()) {
            return personOptional;
        } else {
            throw new PersonNotFoundException(format(PERSON_WITH_SPECIFIED_ID_NOT_FOUND_MESSAGE, personalData));
        }
    }

    public void deleteById(PersonalData personalData) {
        personRepository.deleteById(personalData);
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public List<Person> findByCityOfLiving(String cityOfLiving) {
        return personRepository.findByCityOfLiving(cityOfLiving);
    }

    public List<Person> findByPersonalDataAgeLessThanOrderByPersonalDataAgeDesc(int age) {
        return personRepository.findByPersonalDataAgeLessThanOrderByPersonalDataAgeDesc(age);
    }

    public Optional<Person> findByPersonalDataNameAndPersonalDataSurname(String name, String surname) throws PersonNotFoundException {
        var personOptional = personRepository.findByPersonalDataNameAndPersonalDataSurname(name, surname);

        if (personOptional.isPresent()) {
            return personOptional;
        } else {
            throw new PersonNotFoundException(format(PERSON_WITH_SPECIFIED_NAME_AND_SURNAME_NOT_FOUND_MESSAGE,
                    name, surname));
        }
    }
}
