package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.hotel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelDtoForBookingResponse {
    private Integer id;
    private String name;
    private String contactNumber;
    private String email;
    private String website;
    private String description;
}
