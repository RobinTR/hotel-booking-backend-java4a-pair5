package com.tobeto.hotel_booking_java4a_pair5.services.dtos.responses.person;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetByIdPersonResponse {
    private Integer id;
    private String fullAddress;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
