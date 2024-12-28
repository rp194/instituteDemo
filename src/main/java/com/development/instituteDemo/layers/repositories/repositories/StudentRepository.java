package com.development.instituteDemo.layers.repositories.repositories;

import com.development.instituteDemo.layers.models.Person;
import com.development.instituteDemo.layers.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s.person FROM Student s WHERE s.id = :id")
    Person findPersonByStudentId(@Param("id") Long id);


}
