package com.development.instituteDemo.layers.validators.impls;

import com.development.instituteDemo.layers.models.Person;
import com.development.instituteDemo.layers.models.Student;
import com.development.instituteDemo.layers.repositories.repositories.PersonRepository;
import com.development.instituteDemo.layers.validators.Validator;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class StudentValidator implements Validator<Student> {
    private PersonRepository personRepository;

    public StudentValidator(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void validateFields(Student studentEntity) {
        validateParentPerson(studentEntity.getPerson());
    }

    private void validateParentPerson(Person person) {
        if (!personRepository.existsById(person.getNationalId())) {
            throw new ValidationException("No such person with id:" + person.getNationalId() + " exists yet!");
        }
    }
}
