package com.development.instituteDemo.layers.controllers.managemenet;

import com.development.instituteDemo.layers.Mappers.LessonMapper;
import com.development.instituteDemo.layers.Services.LessonService;
import com.development.instituteDemo.layers.models.Lesson;
import com.development.instituteDemo.layers.models.dto.LessonDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operator/lesson")
public class LessonController {
    private LessonService lessonService;
    private LessonMapper lessonMapper;

    public LessonController(LessonService lessonService, LessonMapper lessonMapper) {
        this.lessonService = lessonService;
        this.lessonMapper = lessonMapper;
    }

    @PostMapping
    public ResponseEntity<LessonDto> createLesson(@Valid @RequestBody LessonDto lessonDto) {
        Lesson lesson = lessonMapper.toEntity(lessonDto);
        Lesson createdLesson = lessonService.saveLesson(lesson);
        LessonDto createdLessonDto = lessonMapper.toDto(createdLesson);
        return new ResponseEntity<>(createdLessonDto, HttpStatus.CREATED);
    }
}
