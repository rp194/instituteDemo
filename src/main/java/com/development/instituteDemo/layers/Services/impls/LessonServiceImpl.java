package com.development.instituteDemo.layers.Services.impls;

import com.development.instituteDemo.layers.Services.LessonService;
import com.development.instituteDemo.layers.models.Lesson;
import com.development.instituteDemo.layers.repositories.repositories.LessonRepository;
import org.springframework.stereotype.Service;

@Service
public class LessonServiceImpl implements LessonService {
    private LessonRepository lessonRepository;

    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public Lesson saveLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }
}
