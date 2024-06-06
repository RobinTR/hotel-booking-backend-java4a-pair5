package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.manager;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddManagerRequest {
    private Integer hotelId;
    private Integer addressId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
}
