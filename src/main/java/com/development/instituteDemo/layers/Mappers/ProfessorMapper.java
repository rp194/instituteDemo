package com.development.instituteDemo.layers.Mappers;

import com.development.instituteDemo.layers.models.Professor;
import com.development.instituteDemo.layers.models.Person;
import com.development.instituteDemo.layers.models.dto.ProfessorDto;
import com.development.instituteDemo.layers.repositories.repositories.PersonRepository;
import com.development.instituteDemo.layers.repositories.repositories.ProfessorRepository;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProfessorMapper {
    @Mapping(target = "person.nationalId", source = "personId")
    Professor toEntity(ProfessorDto professorDto);
    @Mapping(target = "personId", source = "person")
    ProfessorDto toDto(Professor professor);
    default String map(Person person) {
        return (person != null) ? person.getNationalId() : null;
    }

    default Person map(String id, @Context PersonRepository personRepository) {
        return (id != null) ? personRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Person with ID " + id + " not found")) : null;
    }

}
