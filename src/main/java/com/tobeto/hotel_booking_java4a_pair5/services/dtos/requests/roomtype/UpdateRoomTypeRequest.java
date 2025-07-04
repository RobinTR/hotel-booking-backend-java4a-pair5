package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomtype;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateRoomTypeRequest {
    @NotNull(message = "You must enter a room type id.")
    private Integer id;

    @NotBlank(message = "Room Type name cannot be blank.")
    private String name;

    private String description;

    private int capacity;
}
