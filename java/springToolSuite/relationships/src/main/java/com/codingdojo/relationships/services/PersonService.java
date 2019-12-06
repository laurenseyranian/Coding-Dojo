package com.codingdojo.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepository;
    
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
////CREATES a person//////////////////////////////////////////////////////////////////
    public Person createPerson(Person createPerson) {
        return personRepository.save(createPerson);
    }
////READS all persons//////////////////////////////////////////////////////////////////
    public List<Person> allPersons() {
        return personRepository.findAll();
    }
////RETRIEVES a person by id/////////////////////////////////////////////////////////// 
    public Person findPerson(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if(optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            return null;
        }
    }
////DELETES a person b/////////////////////////////////////////////////////////////////
 	public void deletePerson(Long id) {
 		Person deletePerson = this.findPerson(id);
 		personRepository.delete(deletePerson);
 	}
}
