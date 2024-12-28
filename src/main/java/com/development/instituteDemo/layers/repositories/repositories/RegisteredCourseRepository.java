package com.development.instituteDemo.layers.repositories.repositories;

import com.development.instituteDemo.layers.models.Course;
import com.development.instituteDemo.layers.models.RegisteredCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface RegisteredCourseRepository extends JpaRepository<RegisteredCourse, Long> {
    @Query("SELECT rc.course FROM RegisteredCourse rc WHERE rc.student.id = :stdNo")
    List<Course> findCoursesByStudentId(@Param("stdNo") Long stdNo);
    @Query("SELECT rc FROM RegisteredCourse rc " +
            "JOIN rc.course c " +
            "WHERE c.professor.id = :prfNo " +
            "AND c.id = :courseId " +
            "AND rc.student.id = :stdNo")
    RegisteredCourse findStudentsByProfNo(@Param("prfNo") Long prfNo,
                                          @Param("courseId") Long courseId,
                                          @Param("stdNo") Long stdNo);
    @Query("SELECT AVG(rc.grade) FROM RegisteredCourse rc WHERE rc.student = :stdNo")
    Double findGpa(@Param("stdNo") Long studentId);
}
