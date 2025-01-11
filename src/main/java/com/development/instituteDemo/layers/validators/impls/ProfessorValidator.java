package com.development.instituteDemo.layers.validators.impls;

import com.development.instituteDemo.layers.models.Person;
import com.development.instituteDemo.layers.models.Professor;
import com.development.instituteDemo.layers.repositories.repositories.PersonRepository;
import com.development.instituteDemo.layers.validators.Validator;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class ProfessorValidator implements Validator<Professor> {
    private PersonRepository personRepository;

    public ProfessorValidator(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void validateFields(Professor professorEntity) {
        validateParentPerson(professorEntity.getPerson());
    }

    private void validateParentPerson(Person person) {
        if (!personRepository.existsById(person.getNationalId())) {
            throw new ValidationException("No such person with id:" + person.getNationalId() + " exists yet!");
        }
    }
}
