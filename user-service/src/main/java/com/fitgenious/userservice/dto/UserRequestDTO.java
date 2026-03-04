package com.fitgenious.userservice.dto;

import com.fitgenious.userservice.model.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserRequestDTO {
    @NotBlank(message = "Email is Required")
    @Email(message = "Invalid Email format")
    private String email;

    @NotBlank(message = "Password is Required")
    @Size(min =6, message = "Password must be atleast 6 characters")
    private String password;

    @NotBlank(message = "First Name  is Required")
    private String firstName;

    @NotBlank(message = "Last Name  is Required")
    private String lastName;

}
