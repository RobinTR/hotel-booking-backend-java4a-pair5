package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.room;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAllRoomResponse {
    private Integer id;
    private String hotelName;
    private String roomTypeName;
    private int number;
    private double cost;

    public GetAllRoomResponse(Integer id, String hotelName, String roomTypeName, int number) {
        this.id = id;
        this.hotelName = hotelName;
        this.roomTypeName = roomTypeName;
        this.number = number;
    }
}
