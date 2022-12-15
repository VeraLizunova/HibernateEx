package com.bezf.hibernateex.controllers;

import com.bezf.hibernateex.entities.Person;
import com.bezf.hibernateex.entities.PersonalData;
import com.bezf.hibernateex.expections.PersonNotFoundException;
import com.bezf.hibernateex.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("hello")
    public String hello() {
        return "hello, user!";
    }

    @PostMapping("save")
    public Person save(Person person) {
        return personService.save(person);
    }

    @GetMapping("findById")
    public Optional<Person> findById(@RequestParam("name") String name, @RequestParam("surname") String surname,
                                     @RequestParam("age") int age)
            throws PersonNotFoundException {
        var personalData = getPersonalData(name, surname, age);
        return personService.findById(personalData);
    }

    @DeleteMapping("delete")
    public void deleteById(@RequestParam("name") String name, @RequestParam("surname") String surname,
                           @RequestParam("age") int age) {
        PersonalData personalData = getPersonalData(name, surname, age);
        personService.deleteById(personalData);
    }

    @GetMapping("findAll")
    public List<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping("findByCity")
    public List<Person> findByCityOfLiving(@RequestParam("city") String cityOfLiving) {
        return personService.findByCityOfLiving(cityOfLiving);
    }

    @GetMapping("findByPersonalDataAge")
    public List<Person> findByPersonalDataAgeLessThanOrderByPersonalDataAgeDesc(@RequestParam("age") int age) {
        return personService.findByPersonalDataAgeLessThanOrderByPersonalDataAgeDesc(age);
    }


    @GetMapping("findByNameAndSurname")
    public Optional<Person> findByPersonalDataNameAndPersonalDataSurname(String name, String surname) throws PersonNotFoundException {
        return personService.findByPersonalDataNameAndPersonalDataSurname(name, surname);
    }

    private static PersonalData getPersonalData(String name, String surname, int age) {
        var personalData = new PersonalData();
        personalData.setName(name);
        personalData.setSurname(surname);
        personalData.setAge(age);
        return personalData;
    }

}
