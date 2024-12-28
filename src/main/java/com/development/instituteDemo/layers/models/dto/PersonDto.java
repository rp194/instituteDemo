package com.development.instituteDemo.layers.models.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PersonDto {
    @NotNull(message = "Field cannot be null")
    @Pattern(regexp = "^[0-9]{10}$", message = "Field must be exactly 10 digits")
    private String nationalId;
    private String firstName;
    private String lastName;
    private String role;
    private String email;
}
