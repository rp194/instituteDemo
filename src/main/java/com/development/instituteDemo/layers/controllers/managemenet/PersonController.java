package com.development.instituteDemo.layers.controllers.managemenet;

import com.development.instituteDemo.layers.Mappers.PersonMapper;
import com.development.instituteDemo.layers.Services.PersonService;
import com.development.instituteDemo.layers.models.Person;
import com.development.instituteDemo.layers.models.dto.PersonDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operator/person")
public class PersonController {
    private PersonService personService;
    private PersonMapper personMapper;

    public PersonController(PersonService personService, PersonMapper personMapper) {
        this.personService = personService;
        this.personMapper = personMapper;
    }

    @PostMapping
    public ResponseEntity<PersonDto> createPerson(@Valid @RequestBody PersonDto personDto) {
        Person person = personMapper.toEntity(personDto);
        Person createdPerson = personService.savePerson(person);
        PersonDto createdPersonDto = personMapper.toDto(createdPerson);
        return new ResponseEntity<>(createdPersonDto, HttpStatus.CREATED);
    }
}
