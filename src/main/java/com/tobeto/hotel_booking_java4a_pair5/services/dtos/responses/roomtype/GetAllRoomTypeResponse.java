package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomtype;

import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomtypefeature.GetAllRoomTypeFeatureResponse;
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
    private List<GetAllRoomTypeFeatureResponse> features;
    private boolean isAllInclusive;
}
