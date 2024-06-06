package com.tobeto.hotel_booking_java4a_pair5.services.dtos.requests.person;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePersonRequest {
    private Integer id;
    private Integer addressId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
}
