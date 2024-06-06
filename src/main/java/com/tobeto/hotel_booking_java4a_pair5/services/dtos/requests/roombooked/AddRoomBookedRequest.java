package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roombooked;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddRoomBookedRequest {
    private Integer bookingId;
    private Integer roomId;
}
