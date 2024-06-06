package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.country;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAllCountryResponse {
    private Integer id;
    private String binaryCode;
    private String tripleCode;
    private String name;
    private String phoneCode;
}
