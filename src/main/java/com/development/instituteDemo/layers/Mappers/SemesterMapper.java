package com.development.instituteDemo.layers.Mappers;

import com.development.instituteDemo.layers.models.Semester;
import com.development.instituteDemo.layers.models.dto.SemesterDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SemesterMapper {
    Semester toEntity(SemesterDto semesterDto);
    SemesterDto toDto(Semester semester);
}
