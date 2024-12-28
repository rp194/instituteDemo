package com.development.instituteDemo.layers.Mappers;

import com.development.instituteDemo.layers.models.Institute;
import com.development.instituteDemo.layers.models.dto.InstituteDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InstituteMapper {
    Institute toEntity(InstituteDto instituteDto);
    InstituteDto toDto(Institute institute);
}
