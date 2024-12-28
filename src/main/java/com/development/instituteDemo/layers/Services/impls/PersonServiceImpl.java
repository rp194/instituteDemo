package com.development.instituteDemo.layers.Services.impls;

import com.development.instituteDemo.layers.Services.PersonService;
import com.development.instituteDemo.layers.models.Person;
import com.development.instituteDemo.layers.repositories.repositories.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    private PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }
}
