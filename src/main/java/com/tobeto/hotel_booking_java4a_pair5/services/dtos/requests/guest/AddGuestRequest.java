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
    @NotNull(message = "You must enter user an id.")
    private Integer userId;
}
