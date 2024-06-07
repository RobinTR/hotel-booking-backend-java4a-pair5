package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.city;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCityRequest {
    private Integer id;

    private Integer countryId;

    private String name;

    private String plateNo;

    private String phoneCode;
}
