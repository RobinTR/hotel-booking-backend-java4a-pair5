package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.city;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAllCityResponse {
    private Integer id;
    private String countryName;
    private String name;
    private String plateNo;
    private String phoneCode;
}
