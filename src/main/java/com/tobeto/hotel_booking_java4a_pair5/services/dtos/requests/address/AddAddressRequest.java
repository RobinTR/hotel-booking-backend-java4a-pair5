package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddAddressRequest {
    private Integer neighborhoodId;

    @NotBlank(message = "Full address cannot be blank.")
    private String fullAddress;
}
