package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.roomfeature;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAllRoomFeatureResponse {
    private Integer id;
    private Integer roomId;
    private Integer featureId;
    private boolean isAvailable;
}
