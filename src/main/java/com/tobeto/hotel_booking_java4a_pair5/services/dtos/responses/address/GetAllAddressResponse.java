package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.address;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAllAddressResponse {
    private Integer id;
    private String countryName;
    private String cityName;
    private String districtName;
    private String areaName;
    private String neighborhoodName;
    private String fullAddress;
}
