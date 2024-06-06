package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.area;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetByIdAreaResponse {
    private Integer id;
    private String districtName;
    private String name;
}
