package com.development.instituteDemo.layers.Services.impls;

import com.development.instituteDemo.layers.Services.StudentService;
import com.development.instituteDemo.layers.models.Person;
import com.development.instituteDemo.layers.models.Student;
import com.development.instituteDemo.layers.models.User;
import com.development.instituteDemo.layers.repositories.repositories.StudentRepository;
import com.development.instituteDemo.layers.repositories.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    private UserRepository userRepository;


    public StudentServiceImpl(StudentRepository studentRepository, UserRepository userRepository) {
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        Student createdStudent = studentRepository.save(student);
        Person studentPersonalInformation = studentRepository.findPersonByStudentId(createdStudent.getId());
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
