package com.development.instituteDemo.layers.models.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class StudentDto {
    private Long id;
    private Integer entranceYear;
    @NotNull(message = "Field cannot be null")
    private String personId;
}
