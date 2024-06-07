package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roombooked;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddRoomBookedRequest {
    @NotNull(message = "You must enter a booking id.")
    private Integer bookingId;

    @NotNull(message = "You must enter a room id.")
    private Integer roomId;
}
