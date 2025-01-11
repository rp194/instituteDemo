package com.development.instituteDemo.layers.Services.impls;

import com.development.instituteDemo.layers.Services.ProfessorService;
import com.development.instituteDemo.layers.models.Person;
import com.development.instituteDemo.layers.models.Professor;
import com.development.instituteDemo.layers.models.User;
import com.development.instituteDemo.layers.repositories.repositories.PersonRepository;
import com.development.instituteDemo.layers.repositories.repositories.ProfessorRepository;
import com.development.instituteDemo.layers.repositories.repositories.UserRepository;
import com.development.instituteDemo.layers.validators.Validator;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class ProfessorServiceImpl implements ProfessorService {
    private ProfessorRepository professorRepository;
    private UserRepository userRepository;
    private PersonRepository personRepository;
    private Validator<Professor> professorValidator;

    public ProfessorServiceImpl(ProfessorRepository professorRepository,
                                UserRepository userRepository,
                                PersonRepository personRepository,
                                Validator<Professor> professorValidator) {
        this.professorRepository = professorRepository;
        this.userRepository = userRepository;
        this.personRepository = personRepository;
        this.professorValidator = professorValidator;
    }

    @Override
    public Professor saveProfessor(Professor professor) {
        professorValidator.validateFields(professor);
        Person professorPersonalInformation = personRepository.findPersonByPersonId(professor.getPerson().getNationalId());
        Professor createdProfessor = professorRepository.save(professor);
        User user = new User();
        user.setUsername(
                (professorPersonalInformation.getFirstName() != null ?
                        professorPersonalInformation.getFirstName() : "") +
                        (professorPersonalInformation.getLastName() != null ?
                                professorPersonalInformation.getLastName() : "") +
                        professor.getId().toString());
        user.setPerson(professorPersonalInformation);
        userRepository.save(user);
        return createdProfessor;
    }
}
