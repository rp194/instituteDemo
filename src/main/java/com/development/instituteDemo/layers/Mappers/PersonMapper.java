package com.development.instituteDemo.layers.Mappers;

import com.development.instituteDemo.layers.models.Person;
import com.development.instituteDemo.layers.models.dto.PersonDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    Person toEntity(PersonDto personDto);
    PersonDto toDto(Person person);
}
