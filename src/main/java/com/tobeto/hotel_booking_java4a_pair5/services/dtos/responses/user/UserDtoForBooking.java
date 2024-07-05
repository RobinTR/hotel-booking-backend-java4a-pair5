package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDtoForBooking {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
