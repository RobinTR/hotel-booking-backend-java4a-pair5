package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.user;

import com.tobeto.hotel_booking_java4a_pair5.entities.Guest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetByIdUserResponse {
    private Integer id;
    private String fullAddress;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Guest guest;
}
