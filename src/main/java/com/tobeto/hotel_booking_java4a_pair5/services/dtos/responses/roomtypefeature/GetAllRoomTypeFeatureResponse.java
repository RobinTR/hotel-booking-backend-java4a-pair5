package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomtypefeature;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAllRoomTypeFeatureResponse {
    private Integer id;
    private Integer roomTypeId;
    private Integer featureId;
    private boolean isAvailable;
}
