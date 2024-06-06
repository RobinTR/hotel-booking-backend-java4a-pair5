package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.room;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateRoomRequest {
    private Integer id;
    private Integer hotelId;
    private Integer roomTypeId;
    private int number;
    private boolean isAvailable;
}
