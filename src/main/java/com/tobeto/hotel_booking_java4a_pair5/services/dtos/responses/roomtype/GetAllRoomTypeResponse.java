package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomtype;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAllRoomTypeResponse {
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private boolean smokeFriendly;
    private boolean petFriendly;
    private boolean wifi;
    private boolean food;
    private boolean isAllInclusive;
}