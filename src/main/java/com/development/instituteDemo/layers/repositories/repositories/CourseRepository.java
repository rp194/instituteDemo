package com.development.instituteDemo.layers.repositories.repositories;

import com.development.instituteDemo.layers.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
