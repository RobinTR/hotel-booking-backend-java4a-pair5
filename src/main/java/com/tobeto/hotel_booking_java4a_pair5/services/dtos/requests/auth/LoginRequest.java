package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    @NotBlank(message = "Email cannot be blank.")
    @Email(message = "You must enter a valid email.")
    private String email;

    @NotBlank(message = "Password cannot be blank.")
    private String password;
}
