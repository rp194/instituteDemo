package com.development.instituteDemo.layers.Services.impls;

import com.development.instituteDemo.layers.Services.ProfessorService;
import com.development.instituteDemo.layers.models.Person;
import com.development.instituteDemo.layers.models.Professor;
import com.development.instituteDemo.layers.models.User;
import com.development.instituteDemo.layers.repositories.repositories.PersonRepository;
import com.development.instituteDemo.layers.repositories.repositories.ProfessorRepository;
import com.development.instituteDemo.layers.repositories.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfessorServiceImpl implements ProfessorService {
    private ProfessorRepository professorRepository;
    private UserRepository userRepository;
    private PersonRepository personRepository;

    public ProfessorServiceImpl(ProfessorRepository professorRepository, UserRepository userRepository, PersonRepository personRepository) {
        this.professorRepository = professorRepository;
        this.userRepository = userRepository;
        this.personRepository = personRepository;
    }

    @Override
    public Professor saveProfessor(Professor professor) {
        Person professorPersonalInformation = personRepository.findPersonByPersonId(professor.getPerson().getNationalId());
        if (professorPersonalInformation == null) {
            throw new IllegalArgumentException("No such person with national id:" + professor.getPerson().getNationalId() + "already exists!");
        }
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
