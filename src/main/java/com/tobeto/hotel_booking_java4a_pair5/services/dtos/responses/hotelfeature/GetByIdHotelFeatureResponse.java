package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotelfeature;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetByIdHotelFeatureResponse {
    private Integer id;
    private Integer hotelId;
    private Integer featureId;
    private boolean isAvailable;
}
