package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomtype;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetByIdRoomTypeResponse {
    private Integer id;
    private String name;
    private String description;
    private int capacity;
}
