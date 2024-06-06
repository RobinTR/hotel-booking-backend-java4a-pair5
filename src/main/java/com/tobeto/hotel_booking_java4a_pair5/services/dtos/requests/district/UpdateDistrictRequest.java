package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.district;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateDistrictRequest {
    private Integer id;
    private Integer cityId;
    private String name;
}
