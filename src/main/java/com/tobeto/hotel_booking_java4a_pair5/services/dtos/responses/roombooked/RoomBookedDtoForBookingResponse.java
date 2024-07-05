package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roombooked;

import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.room.RoomDtoForBookingResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomBookedDtoForBookingResponse {
    private Integer id;
    private RoomDtoForBookingResponse room;
}
