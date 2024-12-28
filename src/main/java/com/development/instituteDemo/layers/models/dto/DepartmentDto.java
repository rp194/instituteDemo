package com.development.instituteDemo.layers.models.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DepartmentDto {
    private Long id;
    private String name;
    @NotNull(message = "Field cannot be null")
    private Long instituteId;
}
