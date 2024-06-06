package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.country;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCountryRequest {
    private Integer id;
    private String binaryCode;
    private String tripleCode;
    private String name;
    private String phoneCode;
}
