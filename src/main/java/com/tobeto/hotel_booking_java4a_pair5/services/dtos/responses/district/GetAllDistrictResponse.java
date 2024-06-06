package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.district;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAllDistrictResponse {
    private Integer id;
    private String cityName;
    private String name;
}
