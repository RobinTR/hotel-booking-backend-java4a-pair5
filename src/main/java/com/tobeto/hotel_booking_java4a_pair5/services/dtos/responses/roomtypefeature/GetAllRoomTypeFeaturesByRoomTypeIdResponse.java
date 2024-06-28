package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomtypefeature;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAllRoomTypeFeaturesByRoomTypeIdResponse {
    private String featureName;
    private boolean isAvailable;
}
