package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roombooked;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetByIdRoomBookedResponse {
    private Integer id;
    private String bookingHotelName;
    private String roomTypeName;
}
