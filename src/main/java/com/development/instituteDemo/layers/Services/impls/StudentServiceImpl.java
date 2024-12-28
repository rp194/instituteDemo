package com.development.instituteDemo.layers.Services.impls;

import com.development.instituteDemo.layers.Services.StudentService;
import com.development.instituteDemo.layers.models.Person;
import com.development.instituteDemo.layers.models.Student;
import com.development.instituteDemo.layers.models.User;
import com.development.instituteDemo.layers.repositories.repositories.PersonRepository;
import com.development.instituteDemo.layers.repositories.repositories.StudentRepository;
import com.development.instituteDemo.layers.repositories.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    private UserRepository userRepository;
    private PersonRepository personRepository;


    public StudentServiceImpl(StudentRepository studentRepository, UserRepository userRepository, PersonRepository personRepository) {
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
        this.personRepository = personRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        Person studentPersonalInformation = personRepository.findPersonByPersonId(student.getPerson().getNationalId());
        if (studentPersonalInformation == null) {
            throw new IllegalArgumentException("No such person with national id:" + student.getPerson().getNationalId() + "already exists!");
        }
        Student createdStudent = studentRepository.save(student);
        User user = new User();
        user.setUsername(
                (studentPersonalInformation.getFirstName() != null ?
                        studentPersonalInformation.getFirstName() : "") +
                (studentPersonalInformation.getLastName() != null ?
                        studentPersonalInformation.getLastName() : "") +
                student.getId().toString());
        user.setPassword("qwerty123456");
        user.setPerson(studentPersonalInformation);
        userRepository.save(user);
        return createdStudent;
    }
}
