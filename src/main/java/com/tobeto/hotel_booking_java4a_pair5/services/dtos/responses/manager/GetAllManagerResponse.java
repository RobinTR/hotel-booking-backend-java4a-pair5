package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.manager;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAllManagerResponse {
    private Integer id;
    private String hotelName;
    private String fullAddress;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
}
