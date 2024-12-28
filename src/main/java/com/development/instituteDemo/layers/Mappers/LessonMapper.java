package com.development.instituteDemo.layers.Mappers;

import com.development.instituteDemo.layers.models.Lesson;
import com.development.instituteDemo.layers.models.dto.LessonDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LessonMapper {
    Lesson toEntity(LessonDto lessonDto);
    LessonDto toDto(Lesson lesson);
}
