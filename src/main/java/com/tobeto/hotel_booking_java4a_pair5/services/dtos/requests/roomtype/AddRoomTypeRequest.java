package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomtype;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddRoomTypeRequest {
    @NotBlank(message = "Payment method name cannot be blank.")
    private String name;

    private String description;

    private int capacity;

    private boolean isAllInclusive;
}
