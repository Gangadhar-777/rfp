package com.my3tech.user.security;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AuthenticationRequest {
    @NotEmpty(message = "Email Shouldn't be empty or null")
    @Email(message = "Invalid email format")
    private String email;

    @NotEmpty(message = "Password Cannot be empty")
    @Size(min = 5, max = 20, message = "Password must be in between 5 to 20 characters")
    private String password;
}
