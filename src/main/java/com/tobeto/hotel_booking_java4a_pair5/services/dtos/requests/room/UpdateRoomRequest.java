package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.room;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateRoomRequest {
    @NotNull(message = "You must enter an id.")
    private Integer id;
    @NotNull(message = "You must enter a hotel id.")
    private Integer hotelId;
    @NotNull(message = "You must enter a room type id.")
    private Integer roomTypeId;
    private int number;
    private boolean isAvailable;
}
