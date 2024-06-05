package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.address;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAddressRequest {
    private Integer id;
    private Integer countryId;
    private Integer cityId;
    private Integer districtId;
    private Integer areaId;
    private Integer neighborhoodId;
    private String fullAddress;
}
