package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomtype;

import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomtypefeature.GetAllRoomTypeFeatureResponse;
import com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomtypefeature.GetAllRoomTypeFeaturesByRoomTypeIdResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetByIdRoomTypeResponse {
    private Integer id;
    private String name;
    private String description;
    private int capacity;
    private List<GetAllRoomTypeFeaturesByRoomTypeIdResponse> features;
    private boolean isAllInclusive;
}
