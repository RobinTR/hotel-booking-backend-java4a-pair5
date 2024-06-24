package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.room;

import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomtype.GetByIdRoomTypeResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetByIdRoomForHotelResponse {
    private Integer id;
    private GetByIdRoomTypeResponse roomType;
    private int number;
    private double cost;
    private boolean isAvailable;
}
