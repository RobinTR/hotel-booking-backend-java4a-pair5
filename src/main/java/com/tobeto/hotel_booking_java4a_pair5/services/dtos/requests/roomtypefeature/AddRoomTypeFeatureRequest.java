package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomtypefeature;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddRoomTypeFeatureRequest {
    private Integer roomTypeId;
    private Integer featureId;
    private boolean isAvailable;
}
