package com.development.instituteDemo.layers.models.dto;

import lombok.*;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class LessonDto {
    private Long id;
    private String title;
    @Range(min = 1, max = 5, message = "Units count must be between 1 and 5")
    private Integer units;
}
