package com.development.instituteDemo.layers.models.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CourseDto {
    private Long id;
    private Integer capacity;
    @NotNull(message = "Field cannot be null")
    private Long professorId;
    @NotNull(message = "Field cannot be null")
    private Long departmentId;
    @NotNull(message = "Field cannot be null")
    private Long lessonId;
    @NotNull(message = "Field cannot be null")
    private Long semesterId;
    @Range(min = 1, max = 7, message = "Day must be within 1 to 7")
    private Integer day_1;
    @Range(min = 1, max = 7, message = "Day must be within 1 to 7")
    private Integer day_2;
    @Range(min = 0, max = 23, message = "Hour must be within 0 to 23")
    private Integer startHour;
    @Range(min = 0, max = 23, message = "Hour must be within 0 to 23")
    private Integer endHour;
}
