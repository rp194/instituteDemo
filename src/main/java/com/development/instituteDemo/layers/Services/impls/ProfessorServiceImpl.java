package com.development.instituteDemo.layers.Services.impls;

import com.development.instituteDemo.layers.Services.ProfessorService;
import com.development.instituteDemo.layers.models.Person;
import com.development.instituteDemo.layers.models.Professor;
import com.development.instituteDemo.layers.models.User;
import com.development.instituteDemo.layers.repositories.repositories.ProfessorRepository;
import com.development.instituteDemo.layers.repositories.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfessorServiceImpl implements ProfessorService {
    private ProfessorRepository professorRepository;
    private UserRepository userRepository;

    public ProfessorServiceImpl(ProfessorRepository professorRepository, UserRepository userRepository) {
        this.professorRepository = professorRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Professor saveProfessor(Professor professor) {
        Person professorPersonalInformation = professor.getPerson();
        User user = new User();
        user.setUsername(professorPersonalInformation.getFirstName() +
                professorPersonalInformation.getLastName() +
                professor.getId());
        user.setPassword("qwerty123456");
        userRepository.save(user);
        return professorRepository.save(professor);
    }
}
