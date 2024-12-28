package com.development.instituteDemo.layers.repositories.repositories;

import com.development.instituteDemo.layers.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
