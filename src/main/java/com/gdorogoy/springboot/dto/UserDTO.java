package com.gdorogoy.springboot.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;

    @NotEmpty(message = "Name should not be empty or null")
    private String firstName;

    @NotEmpty(message = "Name should not be empty or null")
    private String lastName;

    @NotEmpty(message = "Email should not be empty or null")
    @Email(message = "Email should be va;id")
    private String email;
}
