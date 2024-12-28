package com.development.instituteDemo.layers.Mappers;

import com.development.instituteDemo.layers.models.Person;
import com.development.instituteDemo.layers.models.Student;
import com.development.instituteDemo.layers.models.dto.StudentDto;
import com.development.instituteDemo.layers.repositories.repositories.PersonRepository;
import com.development.instituteDemo.layers.repositories.repositories.StudentRepository;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @Mapping(target = "person.nationalId", source = "personId")
    Student toEntity(StudentDto studentDto);
    @Mapping(target = "personId", source = "person")
    StudentDto toDto(Student student);
    default String map(Person person) {
        return (person != null) ? person.getNationalId() : null;
    }

    default Person map(String id, @Context PersonRepository personRepository) {
        return (id != null) ? personRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Person with ID " + id + " not found")) : null;
    }

}
