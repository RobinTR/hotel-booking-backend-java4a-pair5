package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.hotelfeature;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddHotelFeatureRequest {
    private Integer hotelId;
    private Integer featureId;
    private boolean isAvailable;
}
