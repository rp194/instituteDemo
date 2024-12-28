package com.development.instituteDemo.layers.models.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class RegisteredCourseDto {
    private Long id;
    private double grade;
    @NotNull(message = "Field cannot be null")
    private Long studentId;
    @NotNull(message = "Field cannot be null")
    private Long courseId;
}
