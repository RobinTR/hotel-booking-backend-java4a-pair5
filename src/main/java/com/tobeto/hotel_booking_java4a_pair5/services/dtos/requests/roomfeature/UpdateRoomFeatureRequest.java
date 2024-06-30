package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.roomfeature;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateRoomFeatureRequest {
    private Integer id;
    private Integer roomId;
    private Integer featureId;
    private boolean isAvailable;
}
