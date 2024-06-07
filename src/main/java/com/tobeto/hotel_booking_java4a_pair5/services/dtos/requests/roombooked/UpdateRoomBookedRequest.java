package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roombooked;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateRoomBookedRequest {
    @NotNull(message = "You must enter an id.")
    private Integer id;

    @NotNull(message = "You must enter a booking id.")
    private Integer bookingId;

    @NotNull(message = "You must enter a room id.")
    private Integer roomId;
}
