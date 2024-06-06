package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.manager;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetByIdManagerResponse {
    private Integer id;
    private String hotelName;
}
