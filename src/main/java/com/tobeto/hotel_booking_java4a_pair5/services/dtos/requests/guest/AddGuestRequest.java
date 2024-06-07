package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.guest;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddGuestRequest {
    @NotNull(message = "You must enter a address id.")
    private Integer addressId;
    @NotBlank(message = "First name cannot be blank.")
    @Size(min = 2, max = 32, message = "First name must be between 2-32 characters.")
    private String firstName;
    @NotBlank(message = "Last name cannot be blank.")
    @Size(min = 2, max = 32, message = "Last name must be between 2-32 characters.")
    private String lastName;
    @NotBlank(message = "Email cannot be blank.")
    @Email(message = "You must enter a valid email.")
    @Size(max = 100, message = "Email must be maximum 100 characters.")
    private String email;
    @NotBlank(message = "Phone cannot be blank.")
    private String phone;
    @NotBlank(message = "Password cannot be blank.")
    @Size(min = 8, max = 32, message = "Password must be between 8-32 characters.")
    private String password;
    @NotNull(message = "You must enter a payment by card id.")
    private Integer paymentByCardId;
}