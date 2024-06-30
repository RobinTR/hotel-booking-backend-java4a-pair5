package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomtype;

import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomfeature.GetAllRoomFeatureResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetAllRoomTypeResponse {
    private Integer id;
    private String name;
    private String description;
    private int capacity;
}
